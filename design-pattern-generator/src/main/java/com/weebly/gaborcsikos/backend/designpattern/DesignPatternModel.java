/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;

/**
 * Representation of a Design pattern
 * 
 * @author Gabor Csikos
 * 
 */
public abstract class DesignPatternModel {

	private String name;
	private BasicTemplate basicTemplate;

	/**
	 * Default Constructor
	 */
	public DesignPatternModel() {
		basicTemplate = new BasicTemplate();
	}

	public DesignPatternModel(final String packageName, final String className) {
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

	public abstract String getGeneratedPattern()
			throws CanNotCreateClassException, FieldVariableIsEmptyException;
}
