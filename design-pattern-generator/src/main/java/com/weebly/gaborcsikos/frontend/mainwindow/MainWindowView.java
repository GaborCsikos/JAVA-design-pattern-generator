/**
 * 
 */
package com.weebly.gaborcsikos.frontend.mainwindow;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.weebly.gaborcsikos.backend.designpattern.DesignPattern;

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
	private final JComboBox<DesignPattern> combobox;

	/**
	 * Default Constructor
	 */
	public MainWindowView() {
		panel = new JPanel();
		flowLayout = new FlowLayout();
		selectButton = new JButton("SELECT");
		combobox = new JComboBox<DesignPattern>();
	}

	public void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 50);
		this.setVisible(true);
		this.setTitle(FRAME_TITLE);
		setLayout();
		addElemetsToLayout();
		this.add(panel);
		// TODO set combobox elements
	}
	private void setLayout() {
		panel.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		panel.setLayout(flowLayout);
	}

	private void addElemetsToLayout() {
		panel.add(selectButton);
		// TODO add listener to button in controller
	}

}
