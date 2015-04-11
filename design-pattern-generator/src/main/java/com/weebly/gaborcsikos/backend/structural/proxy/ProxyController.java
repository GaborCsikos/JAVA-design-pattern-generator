/**
 * 
 */
package com.weebly.gaborcsikos.backend.structural.proxy;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.PROXY;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.backend.designpattern.GeneralController;
import com.weebly.gaborcsikos.frontend.patterns.ProxyDialog;

/**
 * @author Gabor Csikos
 *
 */
public class ProxyController extends GeneralController {
	private final ProxyModel model;
	private final ProxyDialog dialog;

	public ProxyController(final ProxyModel model, final ProxyDialog dialog) {
		super(model, dialog);
		this.model = model;
		this.dialog = dialog;
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#setData()
	 */
	@Override
	public void setData() {
		model.setExtendendClass(dialog.getExtendendClass());
		model.setExtendendInstance(dialog.getExtendendInstance());
		model.setOverridenMethod(dialog.getOverridenMethod());
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.GeneralController#init()
	 */
	@Override
	public void init() {
		addActionListeners();
		initFields();
		model.setName(PROXY.getName());
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
					&& !mandatoryFieldsAreEmptyForProxy()) {
				if (fileOpenApproved()) {
					showPath();
					setData();
					if (!classNameIsNullOrEmpty()) {
						generateFile();
					}
				}
			}
		}
		private boolean mandatoryFieldsAreEmptyForProxy() {
			if (dialog.getExtendendClass().isEmpty()
					&& dialog.getExtendendInstance().isEmpty()
					&& dialog.getOverridenMethod().isEmpty()) {
				dialog.openMessageDialog("Fields can't be empty");
				return true;
			}
			return false;
		}
	}
}
