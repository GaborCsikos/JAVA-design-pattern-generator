/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang3.StringUtils;

import com.weebly.gaborcsikos.backend.api.PatternEnum;
import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.PrototypeDialog;

/**
 * Contorller for prototype
 * 
 * @author Gabor Csikos
 * 
 */
public class PrototypeController extends GeneralController {

	private final PrototypeDialog dialog;
	private final PrototypeModel prototypeModel;

	public PrototypeController(final PrototypeModel model,
			final PrototypeDialog dialog) {
		super(model, dialog);
		this.prototypeModel = model;
		this.dialog = dialog;
	}

	@Override
	public void init() {
		addActionListeners();
		initFields();
		prototypeModel.setCloneMethodName(dialog.getCloneMethodName());
		prototypeModel.setName(PatternEnum.PROTOTYPE.getName());
	}

	@Override
	public void setData() {
		prototypeModel.setImplementsClonable(dialog
				.IsImplementsClonableSelected());
		prototypeModel.setCloneMethodName(dialog.getCloneMethodName());
	}

	class ImplementsClonableListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			prototypeModel.setImplementsClonable(dialog
					.IsImplementsClonableSelected());
			dialog.setOptions(dialog.IsImplementsClonableSelected());
		}
	}

	class MethodNameListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			prototypeModel.setCloneMethodName(dialog.getCloneMethodName());
		}
	}
	class GeneratePatternListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setCommonData();
			if (!mandatoryFieldsAreEmpty()
					&& !mandatoryFieldsAreEmptyForPrototype()
					&& !checkIfMethodNameIsClone()) {
				if (fileOpenApproved()) {
					showPath();
					if (!classNameIsNullOrEmpty()) {
						setData();
						generateFile();
					}
				}
			}
		}

	}

	private boolean checkIfMethodNameIsClone() {
		if (!dialog.IsImplementsClonableSelected()) {
			if (PrototypeModel.CLONE_OWERRIDE.equals(dialog
					.getCloneMethodName())) {
				dialog.openMessageDialog("clone method name can't be used");
				return true;
			}
		}
		return false;
		
	}
	private boolean mandatoryFieldsAreEmptyForPrototype() {
		if (!dialog.IsImplementsClonableSelected()
				&& StringUtils.isEmpty(dialog.getCloneMethodName())) {
			dialog.openMessageDialog("Clone method can not be empty");
			return true;
		}
		return false;
	}

	private void addActionListeners() {
		dialog.addGeneratePatternListener(new GeneratePatternListener());
		dialog.addImplementsClonableListener(new ImplementsClonableListener());
		dialog.addMethodNameListener(new MethodNameListener());
	}
}
