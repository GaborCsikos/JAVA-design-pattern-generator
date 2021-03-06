/**
 * 
 */
package com.weebly.gaborcsikos.backend.api;

/**
 * Type of classes and names
 * 
 * @author Gabor Csikos
 * 
 */
public enum ClassType {
	CLASS("class"), ENUM("enum"), INTERFACE("interface"), ABSTRACT_CLASS(
			"abstract class");

	private String name;

	ClassType(final String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
