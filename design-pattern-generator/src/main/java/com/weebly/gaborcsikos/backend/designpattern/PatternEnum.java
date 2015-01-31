/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

/**
 * @author Gabor Csikos
 *
 */
public enum PatternEnum {
	
	SINGLETON("Singleton"), FACTORY("FACTORY");
	
	private String name;

	PatternEnum(final String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
