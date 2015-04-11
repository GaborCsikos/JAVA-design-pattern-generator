/**
 * 
 */
package com.weebly.gaborcsikos.backend.composite;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.COMPOSITE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.CompositeDialog;

/**
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

	private void addActionListeners() {
		dialog.addGeneratePatternListener(new GeneratePatternListener());
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

		// TODO check empty logic, and encapsulate
		private boolean mandatoryFieldsAreEmptyForComposite() {
			if (dialog.getInterfaceMethodName().isEmpty()
					&& dialog.getInterfaceName().isEmpty()
					&& dialog.getOverrridenMethod().isEmpty()
					&& dialog.getListName().isEmpty()) {
				dialog.openMessageDialog("Fields can't be empty"); // TODO add
																	// encapsulate
																	// message
				return true;
			}
			return false;
		}
	}
}
