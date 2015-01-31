/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Base Dialog for class
 * 
 * @author Gabor Csikos
 * 
 */
public abstract class ClassGenerateDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1955102122485910281L;

	public ClassGenerateDialog(final JFrame frame) {
		super(frame);
		this.dialogInit();
		this.setSize(frame.getSize());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		this.setVisible(true);
		initDefaultGeneratableOptions();
	}

	private void initDefaultGeneratableOptions() {
		// TODO Add default class generating oprions

	}
}
