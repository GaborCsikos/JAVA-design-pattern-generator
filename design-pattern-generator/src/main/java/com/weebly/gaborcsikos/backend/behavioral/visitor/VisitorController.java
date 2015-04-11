/**
 * 
 */
package com.weebly.gaborcsikos.backend.behavioral.visitor;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.VISITOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang3.StringUtils;

import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.VisitorDialog;

/**
 * @author Gabor Csikos
 *
 */
public class VisitorController extends GeneralController {
	private final VisitorModel model;
	private final VisitorDialog dialog;

	public VisitorController(final VisitorModel model,
			final VisitorDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#setData()
	 */
	@Override
	public void setData() {
		model.setClassNameToVisit(dialog.getClassNameToVisit());
		model.setClassTypeToVisit(dialog.getClassTypeToVisit());
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#init()
	 */
	@Override
	public void init() {
		addActionListeners();
		initFields();
		model.setName(VISITOR.getName());
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
					&& !mandatoryFieldsAreEmptyForVisitor()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						generateFile();
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForVisitor() {
			if (StringUtils.isEmpty(dialog.getClassNameToVisit())
					|| StringUtils.isEmpty(dialog.getClassTypeToVisit())) {
				openFieldsAreEmptyDialog();
				return true;
			}
			return false;
		}
	}
}
