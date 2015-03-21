/**
 * 
 */
package com.weebly.gaborcsikos.backend.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.api.PatternEnum;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.AdapterDialog;

/**
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
		model.setName(PatternEnum.ADAPTER.getName());
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

	}

	private void initFields() {
		model.getBasicTemplate().setClassName(dialog.getClassName());
		model.getBasicTemplate().setPackageName(dialog.getPackageName());
		setData();
	}

	private void addActionListeners() {
		dialog.addGeneratePatternListener(new GeneratePatternListener());

	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
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
			if (dialog.getTargetClassType().isEmpty()
					|| dialog.getTargetClassName().isEmpty()
					|| dialog.getTargetMethod().isEmpty()
					|| dialog.getMethodReturnType().isEmpty()
					|| dialog.getExtendedClassMethodName().isEmpty()) {
				dialog.openMessageDialog("All fields are required");
				return true;
			}
			return false;
		}
	}
}
