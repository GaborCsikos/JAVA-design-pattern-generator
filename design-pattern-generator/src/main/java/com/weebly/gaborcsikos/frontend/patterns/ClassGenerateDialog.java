/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Base Dialog for class
 * 
 * @author Gabor Csikos
 * 
 */
public abstract class ClassGenerateDialog extends JDialog {
	private static final String CLASS_NAME_LABEL = "Class name : ";
	private static final String GENERATE_LABEL = "Generate";

	protected JPanel panel;
	private JPanel classPanel;
	private JPanel buttonPanel;
	private JTextField textField;
	private JButton generate;

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
		initLayout();
		initDefaultGeneratableOptions();
		addButtonsToEnd();
		this.setVisible(true);
	}

	private void initLayout() {
		panel = new JPanel(new BorderLayout());
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		classPanel = new JPanel(flowLayout);
		classPanel.add(new JLabel(CLASS_NAME_LABEL));
		textField = new JTextField(10);
		classPanel.add(textField);
		
		classPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(classPanel, BorderLayout.NORTH);
		this.add(panel);
	}

	private void addButtonsToEnd() {
		buttonPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		buttonPanel = new JPanel(flowLayout);
		generate = new JButton(GENERATE_LABEL);
		buttonPanel.add(generate);

		buttonPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		this.add(panel);
	}

	protected abstract void initDefaultGeneratableOptions();
	
}
