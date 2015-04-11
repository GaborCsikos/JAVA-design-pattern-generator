/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.factory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.api.PatternEnum;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.FactoryDialog;

/**
 * @author Gabor Csikos
 *
 */
public class FactoryController extends GeneralController {

	private final FactoryModel model;
	private final FactoryDialog dialog;

	public FactoryController(final FactoryModel model,
			final FactoryDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#setData()
	 */
	@Override
	public void setData() {
		model.setObjectToReturn(dialog.getClassToReturn());
		model.setObjectType(dialog.getObjectTypeName());
		model.setSimpleFactoryUsed(dialog.isSimplaFactory());
		model.addAllFields(dialog.getAllElements());

	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#init()
	 */
	@Override
	public void init() {
		addActionListeners();
		initFields();
		model.setName(PatternEnum.FACTORY.getName());

	}

	private void addActionListeners() {
		dialog.addDeleteButtonListener(new DeleteFieldListener());
		dialog.addAddFieldListener(new AddNewFieldListener());
		dialog.addSimpleFactoryActionListerner(new IsSimpleFactorySelected());
		dialog.addGeneratePatternListener(new GeneratePatternListener());
	}

	class IsSimpleFactorySelected implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			dialog.setEditable(dialog.isSimplaFactory());
		}
	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setCommonData();
			if (!mandatoryFieldsAreEmpty()
					&& !mandatoryFieldsAreEmptyForFactory()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						generateFile();
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForFactory() {
			if (dialog.isSimplaFactory()) {
				if (dialog.getClassToReturn().isEmpty()
						|| dialog.getObjectTypeName().isEmpty()) {
					dialog.openMessageDialog("Add field for factory method");
				}
			} else {
				if (dialog.getAllElements().isEmpty()
						|| dialog.getObjectTypeName().isEmpty()) {
					openFieldsAreEmptyDialog();
					return true;
				}
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
			dialog.addFieldToList(field.getStringForFactoryDialog());
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
