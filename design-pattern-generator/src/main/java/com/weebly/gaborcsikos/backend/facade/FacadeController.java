/**
 * 
 */
package com.weebly.gaborcsikos.backend.facade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.designpattern.GeneralController;

/**
 * @author Gabor Csikos
 *
 */
public class FacadeController extends GeneralController {

	private final FacadeModel model;
	private final FacadeDialog dialog;

	public FacadeController(final FacadeModel model, final FacadeDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#setData()
	 */
	@Override
	public void setData() {
		model.setWithInterface(dialog.isWithInterface());
		model.addAllFields(dialog.getAllElements());
	}

	public void init() {
		addActionListeners();
		initFields();
	}

	private void addActionListeners() {
		dialog.addDeleteButtonListener(new DeleteFieldListener());
		dialog.addIsWithInterfaceListener(new IsWithInterFaceListener());
		dialog.addAddFieldListener(new AddNewFieldListener());
		dialog.addGeneratePatternListener(new GeneratePatternListener());
	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			if (!mandatoryFieldsAreEmpty()
					&& !mandatoryFieldsAreEmptyForFacade()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						if (model.isWithInterface()) {
							generateFile("Impl");
							generateFile();
						} else {
							generateFile();
						}
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForFacade() {
			if (dialog.getAllElements().isEmpty()) {
				dialog.openMessageDialog("Fields can't be empty");
				return true;
			}
			return false;
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

	class IsWithInterFaceListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			model.setWithInterface(dialog.isWithInterface());
		}
	}

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
	private void initFields() {
		model.getBasicTemplate().setClassName(dialog.getClassName());
		model.getBasicTemplate().setPackageName(dialog.getPackageName());
		model.setWithInterface(false);
	}

	private void printEvent(final ActionEvent e) {
		System.out.println("action happened:" + e.getActionCommand() + " from:"
				+ e.getSource());
	}
}
