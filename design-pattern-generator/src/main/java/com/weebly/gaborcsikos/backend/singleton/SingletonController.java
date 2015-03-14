/**
 * 
 */
package com.weebly.gaborcsikos.backend.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang3.StringUtils;

import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.SingletonDialog;

/**
 * Controller for Singleton
 * 
 * @author Gabor Csikos
 * 
 */
public class SingletonController extends GeneralController {

	private final SingletonModel singleton;
	private final SingletonDialog dialog;
	
	public SingletonController(final SingletonModel model,
			final SingletonDialog dialog) {
		super(dialog, model);
		this.singleton = model;
		this.dialog = dialog;
	}

	@Override
	public void setData() {
		singleton.setEnumType(dialog.isEnumType());
		singleton.setConstructorPrivate(dialog.isPrivateConstructor());
		singleton.setInstanceName(dialog.getInstanceName());
	}

	class EnumSetterListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			singleton.setEnumType(dialog.isEnumType());
			dialog.setOptions(dialog.isEnumType());
		}
	}

	class ConstructorSetterListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			singleton.setConstructorPrivate(dialog.isPrivateConstructor());
		}
	}

	class EagerLoadingListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setLoadingType();
		}
	}

	class LazyLoadingListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setLoadingType();
		}
	}

	class InstanceSetterListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			singleton.setInstanceName(dialog.getInstanceName());
		}
	}
	public void init() {
		addActionListeners();
		initFields();
	}

	private void initFields() {
		singleton.getBasicTemplate().setClassName(dialog.getClassName());
		singleton.getBasicTemplate().setPackageName(dialog.getPackageName());
		singleton.setConstructorPrivate(true);
		singleton.setEnumType(false);
		singleton.setEagerLoaded(true);
		singleton.setLazyLoaded(false);
		singleton.setInstanceName(dialog.getInstanceName());
	}

	private void addActionListeners() {
		dialog.addGeneratePatternListener(new GeneratePatternListener());
		dialog.addEnumListener(new EnumSetterListener());
		dialog.addConstructorListener(new ConstructorSetterListener());
		dialog.addEagerLoadingListener(new EagerLoadingListener());
		dialog.addlazyLoadingListener(new LazyLoadingListener());
		dialog.addInstanceListener(new InstanceSetterListener());
	}

	private void printEvent(final ActionEvent e) {
		System.out.println("action happened:" + e.getActionCommand() + " from:"
				+ e.getSource());
	}

	private void setLoadingType() {
		singleton.setEagerLoaded(dialog.isEagerLoading());
		singleton.setLazyLoaded(dialog.isLazyLoading());
	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			if (!mandatoryFieldsAreEmpty()
					&& !mandatoryFieldsAreEmptyForSingleton()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						generateFile();
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForSingleton() {
			if (StringUtils.isEmpty(dialog.getInstanceName())) {
				dialog.openMessageDialog("instance name can't be empty");
				return true;
			}
			return false;
		}
	}

}
