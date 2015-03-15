/**
 * 
 */
package com.weebly.gaborcsikos.frontend.mainwindow;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View of Main window, responsible for GUI
 * 
 * @author Gabor Csikos
 * 
 */
public class MainWindowView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FRAME_TITLE = "Design pattern generator";
	private final JPanel panel;
	private final FlowLayout flowLayout;
	private final JButton selectButton;
	private final JComboBox<String> patternBox;
	private final JComboBox<String> patternTypeBox;

	/**
	 * Default Constructor
	 */
	public MainWindowView() {
		panel = new JPanel();
		flowLayout = new FlowLayout();
		selectButton = new JButton("SELECT");
		patternBox = new JComboBox<String>();
		patternTypeBox = new JComboBox<String>();
	}

	public void addSelectPatternListener(final ActionListener listener) {
		selectButton.addActionListener(listener);
	}

	public void addSelectPatternTypeListener(final ActionListener listener) {
		patternTypeBox.addActionListener(listener);
	}
	public void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 100);
		this.setVisible(true);
		this.setTitle(FRAME_TITLE);
		setLayout();
		addElemetsToLayout();
		this.add(panel);
	}

	public void addElementsToCombobox(final List<String> patterns) {
		for (final String pattern : patterns) {
			patternBox.addItem(pattern);
		}
	}

	public void addPatternTypes(final List<String> types) {
		for (final String type : types) {
			patternTypeBox.addItem(type);
		}
	}

	public void setPatterns(final List<String> patterns){
		patternBox.removeAllItems();
		addElementsToCombobox(patterns);
	}

	public String getSelectedPattern() {
		return (String) patternBox.getSelectedItem();
	}

	public String getSelectedPatternType() {
		return (String) patternTypeBox.getSelectedItem();
	}

	private void setLayout() {
		panel.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		panel.setLayout(flowLayout);
	}

	private void addElemetsToLayout() {
		panel.add(patternTypeBox);
		panel.add(patternBox);
		panel.add(selectButton);
	}

}
