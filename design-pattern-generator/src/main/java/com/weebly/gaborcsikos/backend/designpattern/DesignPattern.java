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
	private BasicTemplate basicTemplate;

	/**
	 * Default Constructor
	 */
	public DesignPattern() {
		basicTemplate = new BasicTemplate();
	}

	public DesignPattern(final String packageName, final String className) {
		basicTemplate = new BasicTemplate(packageName, className);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public BasicTemplate getBasicTemplate() {
		return basicTemplate;
	}

	public void setBasicTemplate(final BasicTemplate basicTemplate) {
		this.basicTemplate = basicTemplate;
	}

}
