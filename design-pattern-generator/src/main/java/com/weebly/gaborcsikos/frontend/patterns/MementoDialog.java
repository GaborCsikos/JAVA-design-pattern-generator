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
 * Dialog for Memento
 * 
 * @author Gabor Csikos
 * 
 */
public class MementoDialog extends ClassGenerateDialog {

	private JLabel stateTypeLabel;
	private JLabel stateNameLabel;

	private JTextField stateType;
	private JTextField stateName;

	private JPanel mementoPanel;

	public MementoDialog(final JFrame frame) {
		super(frame);
		super.setClassName("Memento");
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
		initMemento();
	}

	private void initMemento() {
		mementoPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		mementoPanel = new JPanel(flowLayout);
		initTypeAndName();
		mementoPanel.setVisible(true);
		super.panel.add(mementoPanel, BorderLayout.CENTER);
		super.add(panel);
	}

	public String getStateName() {
		return stateName.getText();
	}

	public String getStateType() {
		return stateType.getText();
	}
	private void initTypeAndName() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel infoPanel = new JPanel(flowLayout);
		stateTypeLabel = new JLabel("State type:");
		stateType = new JTextField("Object", 10);
		infoPanel.add(stateTypeLabel);
		infoPanel.add(stateType);
		stateNameLabel = new JLabel("State name:");
		stateName = new JTextField("state", 10);
		infoPanel.add(stateNameLabel);
		infoPanel.add(stateName);
		mementoPanel.add(infoPanel);
	}

}
