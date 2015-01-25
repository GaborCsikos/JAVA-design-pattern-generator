/**
 * 
 */
package com.weebly.gaborcsikos.frontend.mainwindow;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link MainWindowView}
 * 
 * @author Gabor Csikos
 * 
 */
public class MainWindowViewTest {

	private MainWindowView view;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		view = new MainWindowView();
	}

	@Test
	public void testInit() {
		// when

		view.init();

		// then
		assertEquals("Default exit operation is not set",
				view.getDefaultCloseOperation(), JFrame.EXIT_ON_CLOSE);
		Dimension dim = view.getSize();
		assertEquals("Heigt is not 100 is not set", dim.getHeight(), 100, 0.1);
		assertEquals("Width is not 100 is not set", dim.getWidth(), 400, 0.1);
	}

}
