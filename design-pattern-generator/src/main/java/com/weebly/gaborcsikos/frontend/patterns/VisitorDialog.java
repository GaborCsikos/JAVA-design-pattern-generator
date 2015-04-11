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
 * @author Gabor Csikos
 *
 */
public class VisitorDialog extends ClassGenerateDialog {
	private JLabel classTypeToVisitLabel;
	private JLabel classNameToVisitLabel;

	private JTextField classTypeToVisit;
	private JTextField classNameToVisit;
	private JPanel visitorPanel;
	public VisitorDialog(final JFrame frame) {
		super(frame);
	}

	public String getClassTypeToVisit() {
		return classTypeToVisit.getText();
	}

	public String getClassNameToVisit() {
		return classNameToVisit.getText();
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
		initVisitor();
	}

	private void initVisitor() {
		visitorPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		visitorPanel = new JPanel(flowLayout);
		addClassToVisit();
		visitorPanel.setVisible(true);
		super.panel.add(visitorPanel, BorderLayout.CENTER);
		super.add(panel);
	}

	private void addClassToVisit() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel infoPanel = new JPanel(flowLayout);
		classTypeToVisitLabel = new JLabel("Class to visit type:");
		classTypeToVisit = new JTextField("Object", 10);
		classNameToVisitLabel = new JLabel("Class to cisit Name:");
		classNameToVisit = new JTextField("toVisit", 10);
		infoPanel.add(classTypeToVisitLabel);
		infoPanel.add(classTypeToVisit);
		infoPanel.add(classNameToVisitLabel);
		infoPanel.add(classNameToVisit);
		visitorPanel.add(infoPanel);
	}

}
