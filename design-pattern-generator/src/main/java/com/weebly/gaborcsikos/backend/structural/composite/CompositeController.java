/**
 * 
 */
package com.weebly.gaborcsikos.backend.structural.composite;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.COMPOSITE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.CompositeDialog;

/**
 * Controller for composite
 * 
 * @author Gabor Csikos
 * 
 */
public class CompositeController extends GeneralController {
	private final CompositeModel model;
	private final CompositeDialog dialog;

	public CompositeController(final CompositeModel model,
			final CompositeDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}

	@Override
	public void setData() {
		model.setInterfaceMethodName(dialog.getInterfaceMethodName());
		model.setInterfaceName(dialog.getInterfaceName());
		model.setOverrridenMethod(dialog.getOverrridenMethod());
		model.setListName(dialog.getListName());
	}

	@Override
	public void init() {
		addActionListeners();
		initFields();
		model.setName(COMPOSITE.getName());
	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setCommonData();
			if (!mandatoryFieldsAreEmpty()
					&& !mandatoryFieldsAreEmptyForComposite()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						generateFile();
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForComposite() {
			if (dialog.getInterfaceMethodName().isEmpty()
					|| dialog.getInterfaceName().isEmpty()
					|| dialog.getOverrridenMethod().isEmpty()
					|| dialog.getListName().isEmpty()) {
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
