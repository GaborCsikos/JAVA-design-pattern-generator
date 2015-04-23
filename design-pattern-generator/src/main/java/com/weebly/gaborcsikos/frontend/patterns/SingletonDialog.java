/**
 * 
 */
package com.weebly.gaborcsikos.frontend.patterns;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Dialog for generating Singleton
 * 
 * @author Gabor Csikos
 * 
 */
public class SingletonDialog extends ClassGenerateDialog {
	private static final String CONSTRUCTOR_MESSAGE = "Is constructor private";
	private static final String CONSTRUCTOR_INFO = "If selected constructor will be private, otherwise it will be protected";
	private static final String STATICALLY_LOAD = "Eager loading";
	private static final String DYNAMICALLY_LOAD = "Lazy loading";
	private static final String STATICALLY_LOAD_INFO = "Instance object during class loading";
	private static final String DYNAMICALLY_LOAD_INFO = "Instance object at first call";
	private static final String ENUM = "Enum";
	private static final String ENUM_INFO = "use enum as a singleton";
	private static final String INTANCE_LABEL = "instance:";
	private static final String INTANCE = "instance";
	private ButtonGroup group;
	private JRadioButton eagerLoading;
	private JRadioButton lazyLoading;
	private JPanel singletonPanel;
	private JCheckBox privateConstructor;
	private JCheckBox enumSelect;
	private JTextField instanceField;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SingletonDialog(final JFrame frame) {
		super(frame);
		super.setSize(600, 220);
	}


	@Override
	protected void initDefaultGeneratableOptions() {
		initSingletonView();
	}


	public void addEnumListener(final ActionListener listener) {
		enumSelect.addActionListener(listener);
	}

	public void addConstructorListener(final ActionListener listener) {
		privateConstructor.addActionListener(listener);
	}

	public void addEagerLoadingListener(final ActionListener listener) {
		eagerLoading.addActionListener(listener);
	}

	public void addlazyLoadingListener(final ActionListener listener) {
		lazyLoading.addActionListener(listener);
	}

	public void addInstanceListener(final ActionListener listener) {
		instanceField.addActionListener(listener);

	}
	public boolean isEnumType() {
		return enumSelect.isSelected();
	}

	public boolean isPrivateConstructor() {
		return privateConstructor.isSelected();
	}

	public boolean isEagerLoading() {
		return eagerLoading.isSelected();
	}
	public boolean isLazyLoading() {
		return lazyLoading.isSelected();
	}

	public String getInstanceName() {
		return instanceField.getText();
	}

	public void setOptions(final boolean isEnumType) {
		privateConstructor.setEnabled(!isEnumType);
		eagerLoading.setEnabled(!isEnumType);
		lazyLoading.setEnabled(!isEnumType);
	}

	private void initSingletonView() {
		singletonPanel = new JPanel();
		singletonPanel
				.setLayout(new BoxLayout(singletonPanel, BoxLayout.Y_AXIS));
		initEnumInfo();
		initConstructorInfo();
		initInformation();
		initInstanceName();
		singletonPanel.setVisible(true);
		super.panel.add(singletonPanel, BorderLayout.CENTER);
		super.add(panel);
	}

	private void initInstanceName() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		JPanel instancePanel = new JPanel(flowLayout);
		instancePanel.add(new JLabel(INTANCE_LABEL));
		instanceField = new JTextField(INTANCE, 10);
		instancePanel.add(instanceField);
		singletonPanel.add(instancePanel);
	}

	private void initEnumInfo() {
		enumSelect = new JCheckBox(ENUM);
		enumSelect.setToolTipText(ENUM_INFO);
		enumSelect.setSelected(false);
		singletonPanel.add(enumSelect);
	}

	private void initInformation() {
		group = new ButtonGroup();
		eagerLoading = new JRadioButton(STATICALLY_LOAD);
		eagerLoading.setToolTipText(STATICALLY_LOAD_INFO);
		lazyLoading = new JRadioButton(DYNAMICALLY_LOAD);
		lazyLoading.setToolTipText(DYNAMICALLY_LOAD_INFO);
		eagerLoading.setSelected(true);
		lazyLoading.setSelected(false);
		singletonPanel.add(eagerLoading);
		singletonPanel.add(lazyLoading);
		group.add(eagerLoading);
		group.add(lazyLoading);
	}

	private void initConstructorInfo() {
		privateConstructor = new JCheckBox(CONSTRUCTOR_MESSAGE);
		privateConstructor.setToolTipText(CONSTRUCTOR_INFO);
		privateConstructor.setSelected(true);
		singletonPanel.add(privateConstructor);
	}

}
