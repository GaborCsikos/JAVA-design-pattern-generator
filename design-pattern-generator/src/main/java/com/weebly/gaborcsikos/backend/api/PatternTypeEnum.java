/**
 * 
 */
package com.weebly.gaborcsikos.backend.api;

/**
 * @author Gabor Csikos
 *
 */
public enum PatternTypeEnum {

	CREATIONAL("Creational"), BEHAVIORAL("Behavioral"), STRUCTURAL("Structural");

	private String name;

	PatternTypeEnum(final String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
