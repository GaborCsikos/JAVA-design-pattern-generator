/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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
	private static final String PACKAGE_NAME_LABEL = "Package name : ";
	private static final String GENERATE_LABEL = "Generate";
	private static final String CANCEL_LABEL = "Cancel";

	private static final String EXAMPLE_CLASS = "ClassToGenerate";
	private static final String EXAMPLE_PACKAGE = "com.weebly.gaborcsikos";

	protected static final String CHOOSE_FOLDER_INFO = "Choose output folder";

	// TODO Delete
	public static final String testPath = "/home/csikirustu/test";

	protected JPanel panel;
	protected JButton generateButton;
	protected JButton cancelButton;
	private JPanel classPanel;
	private JPanel buttonPanel;
	protected JTextField className;
	protected JTextField packageName;
	private JFileChooser fileChooser;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1955102122485910281L;

	public ClassGenerateDialog(final JFrame frame) {
		super(frame);
		this.dialogInit();
		this.setSize(600, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initLayout();
		initDefaultGeneratableOptions();
		addButtonsToEnd();
		createJFileChooser();
		this.setVisible(true);
	}

	private void createJFileChooser() {
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choose folder to generate pattern");
		fileChooser.setCurrentDirectory(new File(testPath));
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

	}

	private void initLayout() {
		panel = new JPanel(new BorderLayout());
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		classPanel = new JPanel(flowLayout);

		addClassName();
		addPackageName();
		
		classPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(classPanel, BorderLayout.NORTH);
		this.add(panel);
	}

	private void addPackageName() {
		classPanel.add(new JLabel(PACKAGE_NAME_LABEL));
		packageName = new JTextField(EXAMPLE_PACKAGE);
		classPanel.add(packageName);
	}

	private void addClassName() {
		classPanel.add(new JLabel(CLASS_NAME_LABEL));
		className = new JTextField(EXAMPLE_CLASS);
		classPanel.add(className);
	}

	private void addButtonsToEnd() {
		buttonPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		buttonPanel = new JPanel(flowLayout);

		addCancelButton();
		addGenerateButton();

		buttonPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		this.add(panel);
	}

	private void addGenerateButton() {
		generateButton = new JButton(GENERATE_LABEL);
		buttonPanel.add(generateButton);
	}

	private void addCancelButton() {
		cancelButton = new JButton(CANCEL_LABEL);
		buttonPanel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(final ActionEvent e) {
				dispose();
			}
		});
	}

	protected abstract void initDefaultGeneratableOptions();

	public JFileChooser getFileChooser() {
		return fileChooser;
	}
	
}
