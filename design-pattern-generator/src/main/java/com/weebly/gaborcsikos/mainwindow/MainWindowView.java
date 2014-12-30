/**
 * 
 */
package com.weebly.gaborcsikos.mainwindow;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View of Main window, responsible for GUI
 * 
 * @author Gabor Csikos
 * 
 */
public class MainWindowView extends JFrame {

	private final JPanel panel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6974720754301537182L;

	/**
	 * Default Constructor
	 */
	public MainWindowView() {
		panel = new JPanel();
	}

	public void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
		this.add(panel);
		// TODO add GUI elements
	}
}
