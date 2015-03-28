/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Gabor Csikos
 *
 */
public class ObserverDialog extends ClassGenerateDialog {

	private JLabel observerLabel;
	private JTextField observerName;
	private JCheckBox isArrayList;

	private JPanel observerPanel;

	public ObserverDialog(final JFrame frame) {
		super(frame);
		super.setClassName("Subject");
	}

	public String getObserverName() {
		return observerName.getText();
	}

	public boolean isArrayList() {
		return isArrayList.isSelected();
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
		initObserverView();
	}

	private void initObserverView() {
		observerPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		observerPanel = new JPanel(flowLayout);
		initSubjectAndObserver();
		observerPanel.setVisible(true);
		super.panel.add(observerPanel, BorderLayout.CENTER);
		super.add(panel);

	}

	private void initSubjectAndObserver() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel facadeInfoPanel = new JPanel(flowLayout);
		isArrayList = new JCheckBox("Use ArrayList");
		isArrayList.setSelected(true);
		facadeInfoPanel.add(isArrayList);
		observerLabel = new JLabel("Observer name:");
		observerName = new JTextField("Observer", 10);
		facadeInfoPanel.add(observerLabel);
		facadeInfoPanel.add(observerName);
		observerPanel.add(facadeInfoPanel);

	}

}
