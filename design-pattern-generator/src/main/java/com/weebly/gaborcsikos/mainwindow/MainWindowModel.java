/**
 * 
 */
package com.weebly.gaborcsikos.mainwindow;

import com.weebly.gaborcsikos.designpattern.DesignPatterns;

/**
 * Model for Main window
 * 
 * @author Gabor Csikos
 * 
 */
public class MainWindowModel {

	private final DesignPatterns patterns;

	/**
	 * Default Constructor
	 */
	public MainWindowModel() {
		patterns = new DesignPatterns();
	}

	public DesignPatterns getPatterns() {
		return patterns;
	}
	
}
