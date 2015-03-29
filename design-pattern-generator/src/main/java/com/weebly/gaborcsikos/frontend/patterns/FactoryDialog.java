/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
 * @author Gabor Csikos
 *
 */
public class FactoryDialog extends ClassGenerateDialog {

	private JCheckBox simplaFactory;
	private JLabel objectTypeReturnLabel;
	private JLabel objectTypeName;

	// TODO add View
	// Simpple Factory
	private JLabel classToReturnLabel;

	private JPanel factorypanel;
	// Field stuff
	private JLabel fieldLabel;
	private JComboBox<String> fields;
	private JButton deleteButton;
	private JButton addNewButton;
	private JLabel typeLabel;
	private JLabel nameLabel;
	private JTextField typeField;
	private JTextField nameField;
	public FactoryDialog(final JFrame frame) {
		super(frame);
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
		initFactory();
	}

	private void initFactory() {
		factorypanel = new JPanel();
		factorypanel.setLayout(new BoxLayout(factorypanel, BoxLayout.Y_AXIS));
		initSimpleFactory();
		initFields();
		factorypanel.setVisible(true);
		super.panel.add(factorypanel, BorderLayout.CENTER);
		super.add(panel);

	}

	private void initSimpleFactory() {
		// TODO Auto-generated method stub

	}

	private void initFields() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel fieldPanel = new JPanel(flowLayout);

		fieldLabel = new JLabel("Factory fields:");
		fieldPanel.add(fieldLabel);
		fields = new JComboBox<String>();
		fieldPanel.add(fields);
		deleteButton = new JButton("Delete");
		fieldPanel.add(deleteButton);

		// ADD
		typeLabel = new JLabel("String criteria:");
		fieldPanel.add(typeLabel);
		typeField = new JTextField("String", 10);
		fieldPanel.add(typeField);
		nameLabel = new JLabel("Returned Class:");
		fieldPanel.add(nameLabel);
		nameField = new JTextField("exampleField", 10);
		fieldPanel.add(nameField);
		addNewButton = new JButton("Add");
		fieldPanel.add(addNewButton);

		factorypanel.add(fieldPanel);

	}

	// Field
	public void addElement(final String element) {
		fields.addItem(element);
	}

	public void deleteElement(final int index) {
		fields.removeItemAt(index);
	}

	public List<FieldWithType> getAllElements() {
		List<FieldWithType> result = new ArrayList<FieldWithType>();
		for (int i = 0; i < fields.getModel().getSize(); i++) {
			String toCut = fields.getModel().getElementAt(i);
			String[] strArray = toCut.split("-->");
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
}
