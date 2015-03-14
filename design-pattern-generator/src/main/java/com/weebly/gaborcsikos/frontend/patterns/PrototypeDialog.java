/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Dialog for Prototype pattern
 * 
 * @author Gabor Csikos
 * 
 */
public class PrototypeDialog extends ClassGenerateDialog {

	private static final String CLONE = "make";
	private static final String CLONE_INFO_TOOL_TIP = "Can't use \"clone\" as method name";
	private JPanel prototypePanel;
	private JLabel cloneNameLabel;
	private JTextField cloneMethodName;
	private JCheckBox implementsClonableSelected;

	public PrototypeDialog(final JFrame frame) {
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
		initPrototypeView();

	}

	public void addImplementsClonableListener(final ActionListener l) {
		implementsClonableSelected.addActionListener(l);
	}

	public void addMethodNameListener(final ActionListener l) {
		cloneMethodName.addActionListener(l);
	}

	public String getCloneMethodName() {
		return cloneMethodName.getText();
	}

	public boolean IsImplementsClonableSelected() {
		return implementsClonableSelected.isSelected();
	}

	public void setOptions(final boolean isEnumType) {
		cloneMethodName.setEnabled(!isEnumType);
	}

	private void initPrototypeView() {
		prototypePanel = new JPanel();
		prototypePanel
				.setLayout(new BoxLayout(prototypePanel, BoxLayout.Y_AXIS));
		initCloneOptions();
		initCloneName();
		prototypePanel.setVisible(true);
		super.panel.add(prototypePanel, BorderLayout.CENTER);
		super.add(panel);
	}

	private void initCloneName() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel instancePanel = new JPanel(flowLayout);
		cloneNameLabel = new JLabel("Method name:");
		instancePanel.add(cloneNameLabel);
		cloneMethodName = new JTextField(CLONE);
		cloneMethodName.setToolTipText(CLONE_INFO_TOOL_TIP);
		cloneMethodName.setEnabled(false);
		instancePanel.add(cloneMethodName);
		prototypePanel.add(instancePanel);
	}

	private void initCloneOptions() {
		implementsClonableSelected = new JCheckBox("Implement Clonable");
		implementsClonableSelected.setSelected(true);
		prototypePanel.add(implementsClonableSelected);

	}
}
