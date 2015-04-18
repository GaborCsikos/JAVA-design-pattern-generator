/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Dialog for COR
 * 
 * @author Gabor Csikos
 * 
 */
public class ChainOfResponsibilityDialog extends ClassGenerateDialog {
	private JLabel nextNameText;
	private JTextField nextName;
	private JLabel actionNameText;
	private JTextField actionName;
	private JPanel corPanel;
	public ChainOfResponsibilityDialog(final JFrame frame) {
		super(frame);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void initDefaultGeneratableOptions() {
		initCOR();
	}
	public String getNextName() {
		return nextName.getText();
	}

	public String getActionName() {
		return actionName.getText();
	}
	private void initCOR() {
		corPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		corPanel = new JPanel(flowLayout);
		addData();
		corPanel.setVisible(true);
		super.panel.add(corPanel, BorderLayout.CENTER);
		super.add(panel);
	}

	private void addData() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel infoPanel = new JPanel(flowLayout);
		nextNameText = new JLabel("Name of next responsible item:");
		nextName = new JTextField("nextItem", 10);
		actionNameText = new JLabel("Action method name:");
		actionName = new JTextField("handleItem", 10);
		infoPanel.add(nextNameText);
		infoPanel.add(nextName);
		infoPanel.add(actionNameText);
		infoPanel.add(actionName);
		corPanel.add(infoPanel);
	}

}
