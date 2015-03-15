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

	private List<String> creationalPatterns = new ArrayList<String>();
	private List<String> structuralPatterns = new ArrayList<String>();
	private List<String> behavioralPatterns = new ArrayList<String>();
	private List<String> patterntypes = new ArrayList<String>();

	/**
	 * Default Constructor
	 */
	public MainWindowModel() {
	}

	public List<String> getCreationalPatterns() {
		return creationalPatterns;
	}

	public void setCreationalPatterns(final List<String> creationalPatterns) {
		this.creationalPatterns = creationalPatterns;
	}

	public List<String> getStructuralPatterns() {
		return structuralPatterns;
	}

	public void setStructuralPatterns(final List<String> structuralPatterns) {
		this.structuralPatterns = structuralPatterns;
	}

	public List<String> getBehavioralPatterns() {
		return behavioralPatterns;
	}

	public void setBehavioralPatterns(final List<String> behavioralPatterns) {
		this.behavioralPatterns = behavioralPatterns;
	}

	public List<String> getPatterntypes() {
		return patterntypes;
	}

	public void setPatterntypes(final List<String> patterntypes) {
		this.patterntypes = patterntypes;
	}
	
}
