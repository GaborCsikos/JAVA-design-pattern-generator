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
 * Dialog for Adapter
 * 
 * @author Gabor Csikos
 * 
 */
public class AdapterDialog extends ClassGenerateDialog {

	private static final String TARGET_CLASS_NAME = "Adaptee/Target class name:";
	private static final String TARGET_CLASS_TYPE = "Adaptee/Target class type:";
	private static final String EXTENDED_CLASS_NAME = "Extended class name:";
	private static final String METHOD_RETURN_TYPE = "Return type:";
	private static final String METHOD_NAME = "Method name of extended class:";
	private static final String TARGET_METHOD = "Adaptee/Target method name:";
	
	private JLabel targetClassNameLabel;
	private JTextField targetClassName;
	private JLabel targetClassTypeLabel;
	private JTextField targetClassType;
	private JLabel extendedClassNameLabel;
	private JTextField extendedClassName;
	private JLabel methodReturnTypeLabel;
	private JTextField methodReturnType;
	private JLabel methodNameLabel;
	private JTextField methodName;
	private JLabel targetMethodLabel;
	private JTextField targetMethod;

	private JPanel adapterPanel;

	public AdapterDialog(final JFrame frame) {
		super(frame);
	}

	// NO Need for ActionListeners on text

	public String getTargetClassName(){
		return targetClassName.getText();
	}

	public String getTargetClassType() {
		return targetClassType.getText();
	}

	public String getExtendedClassName() {
		return extendedClassName.getText();
	}

	public String getMethodReturnType() {
		return methodReturnType.getText();
	}

	public String getMethodName() {
		return methodName.getText();
	}

	public String getTargetMethod() {
		return targetMethod.getText();
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
		initAdapter();
	}

	private void initAdapter() {
		adapterPanel = new JPanel();
		adapterPanel.setLayout(new BoxLayout(adapterPanel, BoxLayout.Y_AXIS));
		initExtendedClassName();
		initTargetClassNameAndType();
		initReturnTypeAndName();
		adapterPanel.setVisible(true);
		super.panel.add(adapterPanel, BorderLayout.CENTER);
		super.add(panel);

	}

	private void initReturnTypeAndName() {
		// TODO Auto-generated method stub

	}

	private void initTargetClassNameAndType() {
		// TODO Auto-generated method stub

	}

	private void initExtendedClassName() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel fieldPanel = new JPanel(flowLayout);
		// TODO Add labels

		adapterPanel.add(fieldPanel);

	}

}
