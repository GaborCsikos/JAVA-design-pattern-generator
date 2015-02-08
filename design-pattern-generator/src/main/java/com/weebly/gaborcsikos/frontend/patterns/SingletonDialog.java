/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Dialog for generating Singleton
 * 
 * @author Gabor Csikos
 * 
 */
public class SingletonDialog extends ClassGenerateDialog {
	private static final String CONSTRUCTOR_MESSAGE = "Is constructor protected";
	private static final String CONSTRUCTOR_INFO = "If selected constructor will be protected, otherwise it will be private";
	private static final String STATICALLY_LOAD = "Instance class during class loading";
	private static final String DYNAMICALLY_LOAD = "Instance class during first call";
	private ButtonGroup group;
	private JRadioButton staticallyLoaded;
	private JRadioButton dinamicallyLoaded;
	private JPanel singletonPanel;
	private JCheckBox protectedConstructor;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SingletonDialog(final JFrame frame) {
		super(frame);
	}

	public void getInformation() {
		// TODO return information selected

	}

	public void initSingletonView() {
		singletonPanel = new JPanel(new FlowLayout());
		initConstructorInfo();
		initInformation();
		singletonPanel.setVisible(true);
		super.panel.add(singletonPanel, BorderLayout.CENTER);
		super.add(panel);
	}

	private void initInformation() {
		group = new ButtonGroup();
		staticallyLoaded = new JRadioButton(STATICALLY_LOAD);
		dinamicallyLoaded = new JRadioButton(DYNAMICALLY_LOAD);
		staticallyLoaded.setSelected(true);
		dinamicallyLoaded.setSelected(false);
		singletonPanel.add(staticallyLoaded);
		singletonPanel.add(dinamicallyLoaded);
		group.add(staticallyLoaded);
		group.add(dinamicallyLoaded);
	}

	private void initConstructorInfo() {
		protectedConstructor = new JCheckBox(CONSTRUCTOR_MESSAGE);
		protectedConstructor.setToolTipText(CONSTRUCTOR_INFO);
		protectedConstructor.setSelected(true);
		singletonPanel.add(protectedConstructor);
	}

	@Override
	protected void initDefaultGeneratableOptions() {
		initSingletonView();

	}

}
