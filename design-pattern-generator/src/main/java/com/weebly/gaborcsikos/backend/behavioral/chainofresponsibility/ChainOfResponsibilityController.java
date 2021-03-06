/**
 * 
 */
package com.weebly.gaborcsikos.backend.behavioral.chainofresponsibility;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.CHAIN_OF_RESPONSIBILITY;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.ChainOfResponsibilityDialog;

/**
 * Controller for COR pattern
 * 
 * @author Gabor Csikos
 * 
 */
public class ChainOfResponsibilityController extends GeneralController {

	private final ChainOfResponsibilityModel model;
	private final ChainOfResponsibilityDialog dialog;

	public ChainOfResponsibilityController(
			final ChainOfResponsibilityModel model,
			final ChainOfResponsibilityDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}

	@Override
	public void setData() {
		model.setActionName(dialog.getActionName());
		model.setNextName(dialog.getNextName());
	}

	@Override
	public void init() {
		addActionListeners();
		initFields();
		model.setName(CHAIN_OF_RESPONSIBILITY.getName());
	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setCommonData();
			if (!mandatoryFieldsAreEmpty() && !mandatoryFieldsAreEmptyForCOR()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						generateFile();
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForCOR() {
			if (isEmpty(dialog.getActionName())
					|| isEmpty(dialog.getNextName())) {
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
