/**
 * 
 */
package com.weebly.gaborcsikos.backend.behavioral.observer;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.api.PatternEnum;
import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.ObserverDialog;

/**
 * Constroller for Observer
 * 
 * @author Gabor Csikos
 * 
 */
public class ObserverController extends GeneralController {

	private final ObserverModel model;
	private final ObserverDialog dialog;

	public ObserverController(final ObserverModel model,
			final ObserverDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#setData()
	 */
	@Override
	public void setData() {
		model.setArrayList(dialog.isArrayList());
		model.setObserverName(dialog.getObserverName());
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#init()
	 */
	@Override
	public void init() {
		addActionListeners();
		initFields();
		model.setArrayList(dialog.isArrayList());
		model.setObserverName(dialog.getObserverName());
		model.setName(PatternEnum.OBSERVER.getName());
	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setCommonData();
			if (!mandatoryFieldsAreEmpty()
					&& !mandatoryFieldsAreEmptyForObserver()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
							generateFile();
						model.getBasicTemplate().setClassName(
								dialog.getObserverName());
							generateFile();
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForObserver() {
			if (isEmpty(dialog.getObserverName())) {
				openFieldsAreEmptyDialog();
				return true;
			}
			return false;
		}
	}

	private void addActionListeners() {
		dialog.addGeneratePatternListener(new GeneratePatternListener());

	}
}
