/**
 * 
 */
package com.weebly.gaborcsikos.backend.builder;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.BUILDER;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.BuilderDialog;

/**
 * @author Gabor Csikos
 *
 */
public class BuilderController extends GeneralController {

	private final BuilderModel model;
	private final BuilderDialog dialog;

	public BuilderController(final BuilderModel model,
			final BuilderDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#setData()
	 */
	@Override
	public void setData() {
		model.setContainsBuildMethod(dialog.isAddBuildMethod());
		model.addAllFields(dialog.getAllElements());
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#init()
	 */
	@Override
	public void init() {
		addActionListeners();
		initFields();
		model.setContainsBuildMethod(false);
		model.setName(BUILDER.getName());

	}

	private void addActionListeners() {
		dialog.addDeleteButtonListener(new DeleteFieldListener());
		dialog.addAddFieldListener(new AddNewFieldListener());
		dialog.addGeneratePatternListener(new GeneratePatternListener());
	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setCommonData();
			if (!mandatoryFieldsAreEmpty()
					&& !mandatoryFieldsAreEmptyForBuilder()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						generateFile();
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForBuilder() {
			if (dialog.getAllElements().isEmpty()) {
				dialog.openMessageDialog("Fields can't be empty");
				return true;
			}
			return false;
		}
	}

	// field
	class AddNewFieldListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			String type = dialog.getFieldType();
			String name = dialog.getFieldName();
			FieldWithType field = new FieldWithType(type, name);
			model.addField(field);
			dialog.addFieldToList(field.getStringForDialog());
		}
	}

	class DeleteFieldListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			int index = dialog.getSelectedIndex();
			if (index != -1) {
				System.out.println("Index to delete:" + index);
				model.deleteItem(index);
				dialog.deleteElement(index);
			}
		}
	}
}
