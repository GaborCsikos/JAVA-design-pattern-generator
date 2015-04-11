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
public class ProxyDialog extends ClassGenerateDialog {
	private JLabel extendendClassLabel;
	private JLabel extendendInstanceLabel;
	private JLabel overridenMethodLabel;

	private JTextField extendendClass;
	private JTextField extendendInstance;
	private JTextField overridenMethod;

	private JPanel proxyPanel;

	public String getExtendendClass() {
		return extendendClass.getText();
	}

	public String getExtendendInstance() {
		return extendendInstance.getText();
	}

	public String getOverridenMethod() {
		return overridenMethod.getText();
	}
	public ProxyDialog(final JFrame frame) {
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
		initProxy();
	}

	private void initProxy() {
		proxyPanel = new JPanel();
		proxyPanel.setLayout(new BoxLayout(proxyPanel, BoxLayout.Y_AXIS));
		initExtendedDetails();
		initOverridenMethodName();
		proxyPanel.setVisible(true);
		super.panel.add(proxyPanel, BorderLayout.CENTER);
		super.add(panel);
	}

	private void initOverridenMethodName() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel infoPanel = new JPanel(flowLayout);
		extendendClassLabel = new JLabel("Extended class name:");
		infoPanel.add(extendendClassLabel);
		extendendClass = new JTextField("ExtendedClass", 10);
		infoPanel.add(extendendClass);
		extendendInstanceLabel = new JLabel("Single element:");
		infoPanel.add(extendendInstanceLabel);
		extendendInstance = new JTextField("element", 10);
		infoPanel.add(extendendInstance);
		proxyPanel.add(infoPanel);
	}

	private void initExtendedDetails() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel infoPanel = new JPanel(flowLayout);
		overridenMethodLabel = new JLabel("Proxy method");
		infoPanel.add(overridenMethodLabel);
		overridenMethod = new JTextField("method", 10);
		infoPanel.add(overridenMethod);
		proxyPanel.add(infoPanel);
	}

}
