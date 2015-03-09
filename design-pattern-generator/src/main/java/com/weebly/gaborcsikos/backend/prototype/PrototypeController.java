/**
 * 
 */
package com.weebly.gaborcsikos.backend.prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.weebly.gaborcsikos.frontend.patterns.PrototypeDialog;

/**
 * Contorller for prototype
 * 
 * @author Gabor Csikos
 * 
 */
public class PrototypeController {

	private final PrototypeDialog dialog;
	private final PrototypeModel model;

	public PrototypeController(final PrototypeModel model,
			final PrototypeDialog dialog) {
		this.model = model;
		this.dialog = dialog;
	}

	public void init() {
		addActionListeners();
		initFields();
	}

	private void initFields() {
		model.getBasicTemplate().setClassName(dialog.getClassName());
		model.getBasicTemplate().setPackageName(dialog.getPackageName());
		model.setCloneMethodName(dialog.getCloneMethodName());

	}

	private void addActionListeners() {
		dialog.addGeneratePatternListener(new GeneratePatternListener());
		dialog.addImplementsClonableListener(new ImplementsClonableListener());
		dialog.addMethodNameListener(new MethodNameListener());
	}

	class GeneratePatternListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			// TODO add logic for controller
		}
	}

	class ImplementsClonableListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			model.setImplementsClonable(dialog.IsImplementsClonableSelected());
			dialog.setOptions(dialog.IsImplementsClonableSelected());
		}
	}

	class MethodNameListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
		}
	}
	private void printEvent(final ActionEvent e) {
		System.out.println("action happened:" + e.getActionCommand() + " from:"
				+ e.getSource());
	}
}
