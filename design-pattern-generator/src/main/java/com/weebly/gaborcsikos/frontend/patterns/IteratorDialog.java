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
 * Dialog for Iterator
 * 
 * @author Gabor Csikos
 * 
 */
public class IteratorDialog extends ClassGenerateDialog {
	
	private static final String REMOVE_SUPPORTED ="Remove operation supported";
	private static final String ITERATE_CLASS = "Class to Iterate:";

	private JCheckBox removeSupported;
	private JLabel classToIterateLabel;
	private JTextField classToIterate;
	
	private JPanel iteratorPanel;
	
	public IteratorDialog(final JFrame frame) {
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
		initIterator();
	}

	public boolean isRemoveSupported() {
		return removeSupported.isSelected();
	}

	public String getClassToIterate() {
		return classToIterate.getText();
	}

	private void initIterator() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		iteratorPanel = new JPanel(flowLayout);
		removeSupported = new JCheckBox(REMOVE_SUPPORTED);
		removeSupported.setSelected(false);
		classToIterateLabel = new JLabel(ITERATE_CLASS);
		classToIterate = new JTextField("ClassToIterate", 15);

		iteratorPanel.add(removeSupported);
		iteratorPanel.add(classToIterateLabel);
		iteratorPanel.add(classToIterate);
		iteratorPanel.setVisible(true);
		super.panel.add(iteratorPanel, BorderLayout.CENTER);
		super.add(panel);
	}

}
