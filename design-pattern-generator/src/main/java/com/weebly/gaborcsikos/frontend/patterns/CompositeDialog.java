/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Gabor Csikos
 *
 */
public class CompositeDialog extends ClassGenerateDialog {

	private JLabel interfaceNameLabel;
	private JLabel interfaceMethodNameLabel;
	private JLabel overrridenMethodLabel;
	private JLabel listNameLabel;

	private JTextField interfaceName;
	private JTextField interfaceMethodName;
	private JTextField overrridenMethod;
	private JTextField listName;

	private JPanel compositePanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getInterfaceName() {
		return interfaceName.getText();
	}

	public String getInterfaceMethodName() {
		return interfaceMethodName.getText();
	}

	public String getOverrridenMethod() {
		return overrridenMethod.getText();
	}

	public String getListName() {
		return listName.getText();
	}
	public CompositeDialog(final JFrame frame) {
		super(frame);
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.frontend.patterns.ClassGenerateDialog#initDefaultGeneratableOptions()
	 */
	@Override
	protected void initDefaultGeneratableOptions() {
		initCompositeView();
	}

	private void initCompositeView() {
		compositePanel = new JPanel();
		compositePanel
				.setLayout(new BoxLayout(compositePanel, BoxLayout.Y_AXIS));
		initInterFaceDetails();
		initListAndMethod();
		compositePanel.setVisible(true);
		super.panel.add(compositePanel, BorderLayout.CENTER);
		super.add(panel);

	}

	private void initListAndMethod() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel infoPanel = new JPanel(flowLayout);
		interfaceNameLabel = new JLabel("Interface name:");
		infoPanel.add(interfaceNameLabel);
		interfaceName = new JTextField("Interface", 10);
		infoPanel.add(interfaceName);
		interfaceMethodNameLabel = new JLabel("Interface method to call:");
		infoPanel.add(interfaceMethodNameLabel);
		interfaceMethodName = new JTextField("method", 10);
		infoPanel.add(interfaceMethodName);
		compositePanel.add(infoPanel);
	}

	private void initInterFaceDetails() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel infoPanel = new JPanel(flowLayout);
		overrridenMethodLabel = new JLabel("Overriden method name:");
		infoPanel.add(overrridenMethodLabel);
		overrridenMethod = new JTextField("method", 10);
		infoPanel.add(overrridenMethod);
		listNameLabel = new JLabel("List name for composite:");
		infoPanel.add(listNameLabel);
		listName = new JTextField("elements", 10);
		infoPanel.add(listName);
		compositePanel.add(infoPanel);
	}

}
