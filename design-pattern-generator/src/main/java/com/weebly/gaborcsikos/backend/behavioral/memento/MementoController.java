/**
 * 
 */
package com.weebly.gaborcsikos.backend.behavioral.memento;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.MEMENTO;
import static com.weebly.gaborcsikos.backend.behavioral.memento.MementoPrintState.PRINT_CARETAKE;
import static com.weebly.gaborcsikos.backend.behavioral.memento.MementoPrintState.PRINT_MEMENTO;
import static com.weebly.gaborcsikos.backend.behavioral.memento.MementoPrintState.PRINT_ORIGINATOR;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.MementoDialog;

/**
 * @author Gabor Csikos
 *
 */
public class MementoController extends GeneralController {

	private final MementoModel model;
	private final MementoDialog dialog;

	public MementoController(final MementoModel model,
			final MementoDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#setData()
	 */
	@Override
	public void setData() {
		model.setMementoName(dialog.getClassName());
		model.setStateName(dialog.getStateName());
		model.setStateType(dialog.getStateType());
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#init()
	 */
	@Override
	public void init() {
		addActionListeners();
		initFields();
		model.setState(PRINT_MEMENTO);
		model.setName(MEMENTO.getName());
	}

	private void addActionListeners() {
		dialog.addGeneratePatternListener(new GeneratePatternListener());
	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setCommonData();
			if (!mandatoryFieldsAreEmpty()
					&& !mandatoryFieldsAreEmptyForMemento()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						generateFile();
						model.getBasicTemplate().setClassName("Originator");
						model.setState(PRINT_ORIGINATOR);
						generateFile();
						model.getBasicTemplate().setClassName("CareTaker");
						model.setState(PRINT_CARETAKE);
						generateFile();
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForMemento() {
			if (isEmpty(dialog.getStateName())
					|| isEmpty(dialog.getStateType())) {
				openFieldsAreEmptyDialog();
				return true;
			}
			return false;
		}
	}
}
