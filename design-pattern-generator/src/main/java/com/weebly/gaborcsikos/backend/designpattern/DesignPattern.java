/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

/**
 * Representation of a Design pattern
 * 
 * @author Gabor Csikos
 * 
 */
public abstract class DesignPattern {

	private String name;
	private String className;

	/**
	 * Default Constructor
	 */
	public DesignPattern() {

	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
