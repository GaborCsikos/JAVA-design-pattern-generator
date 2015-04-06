/**
 * 
 */
package com.weebly.gaborcsikos.backend.chainofresponsibility;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.CHAIN_OF_RESPONSIBILITY;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.ChainOfResponsibilityDialog;

/**
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

	private void addActionListeners() {
		dialog.addGeneratePatternListener(new GeneratePatternListener());
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
			if (dialog.getActionName().isEmpty()
					&& dialog.getNextName().isEmpty()) {
				dialog.openMessageDialog("Fields can't be empty");
				return true;
			}
			return false;
		}
	}
}
