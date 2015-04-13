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
	private JLabel extendedClassMethodLabel;
	private JTextField extendedClassMethodName;
	private JLabel targetMethodLabel;
	private JTextField targetMethod;

	private JPanel adapterPanel;

	public AdapterDialog(final JFrame frame) {
		super(frame);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weebly.gaborcsikos.frontend.patterns.ClassGenerateDialog#
	 * initDefaultGeneratableOptions()
	 */
	@Override
	protected void initDefaultGeneratableOptions() {
		initAdapter();
	}
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

	public String getExtendedClassMethodName() {
		return extendedClassMethodName.getText();
	}

	public String getTargetMethod() {
		return targetMethod.getText();
	}
	private void initAdapter() {
		adapterPanel = new JPanel();
		adapterPanel.setLayout(new BoxLayout(adapterPanel, BoxLayout.Y_AXIS));
		initExtendedClassName();
		initTargetClassType();
		initTargetClassName();
		initReturnType();
		initReturnName();
		initReturnMethodName();
		adapterPanel.setVisible(true);
		super.panel.add(adapterPanel, BorderLayout.CENTER);
		super.add(panel);
	}

	private void initReturnMethodName() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel fieldPanel = new JPanel(flowLayout);
		targetMethodLabel = new JLabel(TARGET_METHOD);
		targetMethod = new JTextField("adapteeMethod", 15);
		fieldPanel.add(targetMethodLabel);
		fieldPanel.add(targetMethod);
		adapterPanel.add(fieldPanel);
	}

	private void initReturnType() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel fieldPanel = new JPanel(flowLayout);
		methodReturnTypeLabel = new JLabel(METHOD_RETURN_TYPE);

		methodReturnType = new JTextField("String", 15);

		fieldPanel.add(methodReturnTypeLabel);
		fieldPanel.add(methodReturnType);

		adapterPanel.add(fieldPanel);

	}

	private void initReturnName() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel fieldPanel = new JPanel(flowLayout);

		extendedClassMethodLabel = new JLabel(METHOD_NAME);
		extendedClassMethodName = new JTextField("extendedClassMethod", 15);

		fieldPanel.add(extendedClassMethodLabel);
		fieldPanel.add(extendedClassMethodName);

		adapterPanel.add(fieldPanel);
	}

	private void initTargetClassType() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel fieldPanel = new JPanel(flowLayout);

		targetClassTypeLabel = new JLabel(TARGET_CLASS_TYPE);
		targetClassType = new JTextField("Target", 15);

		fieldPanel.add(targetClassTypeLabel);
		fieldPanel.add(targetClassType);

		adapterPanel.add(fieldPanel);
	}

	private void initTargetClassName() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel fieldPanel = new JPanel(flowLayout);

		targetClassNameLabel = new JLabel(TARGET_CLASS_NAME);
		targetClassName = new JTextField("targetClass", 15);

		fieldPanel.add(targetClassNameLabel);
		fieldPanel.add(targetClassName);
		adapterPanel.add(fieldPanel);
	}
	private void initExtendedClassName() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel fieldPanel = new JPanel(flowLayout);

		extendedClassNameLabel = new JLabel(EXTENDED_CLASS_NAME);
		extendedClassName = new JTextField("ExtendedClass", 15);

		fieldPanel.add(extendedClassNameLabel);
		fieldPanel.add(extendedClassName);
		adapterPanel.add(fieldPanel);

	}

}
