/**
 * 
 */
package com.weebly.gaborcsikos.backend.mainwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for Main window
 * 
 * @author Gabor Csikos
 * 
 */
public class MainWindowModel {

	private List<String> patterns;

	/**
	 * Default Constructor
	 */
	public MainWindowModel() {
		patterns = new ArrayList<String>();
	}

	public List<String> getPatterns() {
		return patterns;
	}

	public void setPatterns(final List<String> patterns) {
		this.patterns = patterns;
	}
	
}
