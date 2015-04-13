/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;

/**
 * Dialog for Builder
 * 
 * @author Gabor Csikos
 * 
 */
public class BuilderDialog extends ClassGenerateDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel builderPanel;
	private JCheckBox addBuildMethod;
	// Field stuff
	private JLabel fieldLabel;
	private JComboBox<String> fields;
	private JButton deleteButton;
	private JButton addNewButton;
	private JLabel typeLabel;
	private JLabel nameLabel;
	private JTextField typeField;
	private JTextField nameField;
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.frontend.patterns.ClassGenerateDialog#initDefaultGeneratableOptions()
	 */
	@Override
	protected void initDefaultGeneratableOptions() {
		initBuilder();
	}
	public BuilderDialog(final JFrame frame) {
		super(frame);
	}

	public void addDeleteButtonListener(final ActionListener l) {
		deleteButton.addActionListener(l);
	}

	public void addAddFieldListener(final ActionListener l) {
		addNewButton.addActionListener(l);
	}
	// Field
	public void addElement(final String element) {
		fields.addItem(element);
	}

	public void deleteElement(final int index) {
		fields.removeItemAt(index);
	}

	public boolean isAddBuildMethod() {
		return addBuildMethod.isSelected();
	}

	public List<FieldWithType> getAllElements() {
		List<FieldWithType> result = new ArrayList<FieldWithType>();
		for (int i = 0; i < fields.getModel().getSize(); i++) {
			String toCut = fields.getModel().getElementAt(i);
			String[] strArray = toCut.split(" ");
			if (strArray.length == 2) {
				FieldWithType field = new FieldWithType(strArray[0],
						strArray[1]);
				result.add(field);
			}
		}
		return result;
	}

	public int getSelectedIndex() {
		return fields.getSelectedIndex();
	}

	public String getFieldType() {
		return typeField.getText();
	}

	public String getFieldName() {
		return nameField.getText();
	}

	public void addFieldToList(final String item) {
		fields.addItem(item);
	}
	// end
	private void initBuilder() {
		builderPanel = new JPanel();
		builderPanel.setLayout(new BoxLayout(builderPanel, BoxLayout.Y_AXIS));
		initBuilderField();
		initFields();
		builderPanel.setVisible(true);
		super.panel.add(builderPanel, BorderLayout.CENTER);
		super.add(panel);

	}

	private void initBuilderField() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel facadeInfoPanel = new JPanel(flowLayout);
		addBuildMethod = new JCheckBox("Add a build method");
		addBuildMethod.setSelected(false);
		facadeInfoPanel.add(addBuildMethod);
		builderPanel.add(facadeInfoPanel);
	}

	private void initFields() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel fieldPanel = new JPanel(flowLayout);

		fieldLabel = new JLabel("Fields:");
		fieldPanel.add(fieldLabel);
		fields = new JComboBox<String>();
		fieldPanel.add(fields);
		deleteButton = new JButton("Delete");
		fieldPanel.add(deleteButton);

		// ADD
		typeLabel = new JLabel("Type:");
		fieldPanel.add(typeLabel);
		typeField = new JTextField("String", 10);
		fieldPanel.add(typeField);
		nameLabel = new JLabel("Name:");
		fieldPanel.add(nameLabel);
		nameField = new JTextField("exampleField", 10);
		fieldPanel.add(nameField);
		addNewButton = new JButton("Add");
		fieldPanel.add(addNewButton);

		builderPanel.add(fieldPanel);

	}

}
