/**
 * 
 */
package com.weebly.gaborcsikos.backend.structural.adapter;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.api.PatternEnum;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.AdapterDialog;

/**
 * Controller of adapter pattern
 * 
 * @author Gabor Csikos
 * 
 */
public class AdapterController extends GeneralController {

	private final AdapterModel model;
	private final AdapterDialog dialog;

	public AdapterController(final AdapterModel model,
			final AdapterDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#setData()
	 */
	@Override
	public void setData() {
		model.setExtendedClass(dialog.getExtendedClassName());
		model.setTarget(new FieldWithType(dialog.getTargetClassType(), dialog
				.getTargetClassName()));
		model.setTargetMethodName(dialog.getTargetMethod());
		model.setTargetReturnType(dialog.getMethodReturnType());
		model.setExtendedClassMethodName(dialog.getExtendedClassMethodName());
	}

	@Override
	public void init() {
		addActionListeners();
		initFields();
		setData();
		model.setName(PatternEnum.ADAPTER.getName());
	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setCommonData();
			if (!mandatoryFieldsAreEmpty()
					&& !mandatoryFieldsAreEmptyForAdapter()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						generateFile();
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForAdapter() {
			if (isEmpty(dialog.getTargetClassType())
					|| isEmpty(dialog.getTargetClassName())
					|| isEmpty(dialog.getTargetMethod())
					|| isEmpty(dialog.getMethodReturnType())
					|| isEmpty(dialog.getExtendedClassMethodName())) {
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
