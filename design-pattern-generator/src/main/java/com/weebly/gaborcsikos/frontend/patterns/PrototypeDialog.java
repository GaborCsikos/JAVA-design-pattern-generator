/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import javax.swing.JFrame;

/**
 * Dialog for Prototype pattern
 * 
 * @author Gabor Csikos
 * 
 */
public class PrototypeDialog extends ClassGenerateDialog {

	public PrototypeDialog(final JFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.frontend.patterns.ClassGenerateDialog#initDefaultGeneratableOptions()
	 */
	@Override
	protected void initDefaultGeneratableOptions() {
		initPrototypeView();

	}

	private void initPrototypeView() {
		// TODO Auto-generated method stub

	}

}
