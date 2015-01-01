/**
 * 
 */
package com.weebly.gaborcsikos.backend.mainwindow;

import com.weebly.gaborcsikos.backend.designpattern.DesignPatterns;

/**
 * Model for Main window
 * 
 * @author Gabor Csikos
 * 
 */
public class MainWindowModel {

	private DesignPatterns patterns;

	/**
	 * Default Constructor
	 */
	public MainWindowModel() {
		patterns = new DesignPatterns();
	}

	public DesignPatterns getPatterns() {
		return patterns;
	}

	public void setPatterns(final DesignPatterns patterns) {
		this.patterns = patterns;
	}
	
}
