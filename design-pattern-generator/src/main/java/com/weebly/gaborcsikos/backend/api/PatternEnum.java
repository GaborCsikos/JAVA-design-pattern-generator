/**
 * 
 */
package com.weebly.gaborcsikos.backend.api;

/**
 * @author Gabor Csikos
 *
 */
public enum PatternEnum {
	
	SINGLETON("Singleton"), PROTOTYPE("Prototype"), FACADE("Facade"), ADAPTER(
			"Adapter");
	
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
