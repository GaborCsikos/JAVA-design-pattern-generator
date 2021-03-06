/**
 * 
 */
package com.weebly.gaborcsikos.main;

import com.weebly.gaborcsikos.backend.mainwindow.MainWindowController;
import com.weebly.gaborcsikos.backend.mainwindow.MainWindowModel;
import com.weebly.gaborcsikos.frontend.mainwindow.MainWindowView;

/**
 * Application entry point
 * 
 * @author Gabor Csikos
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		try {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					final MainWindowView view = new MainWindowView();
					final MainWindowModel model = new MainWindowModel();
					final MainWindowController conroller = new MainWindowController(
							view, model);
					conroller.runApplication();
				}
			});

		} catch (final Exception e) {
			System.err.println("Unknown error happened");
			e.printStackTrace();
		}
	}

}
