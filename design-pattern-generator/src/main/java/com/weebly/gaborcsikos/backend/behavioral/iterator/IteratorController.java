/**
 * 
 */
package com.weebly.gaborcsikos.backend.behavioral.iterator;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.ITERATOR;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.IteratorDialog;

/**
 * @author Gabor Csikos
 *
 */
public class IteratorController extends GeneralController {
	private final IteratorModel model;
	private final IteratorDialog dialog;

	public IteratorController(final IteratorModel model,
			final IteratorDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#setData()
	 */
	@Override
	public void setData() {
		model.setClassToIterate(dialog.getClassToIterate());
		model.setRemoveSupported(dialog.isRemoveSupported());
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#init()
	 */
	@Override
	public void init() {
		addActionListeners();
		initFields();
		model.setName(ITERATOR.getName());
		setData();
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
					&& !mandatoryFieldsAreEmptyForIterator()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						generateFile();
					}
				}
			}
		}

		private boolean mandatoryFieldsAreEmptyForIterator() {
			if (isEmpty(dialog.getClassToIterate())) {
				openFieldsAreEmptyDialog();
				return true;
			}
			return false;
		}
	}

}
