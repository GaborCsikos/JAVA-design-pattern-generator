/**
 * 
 */
package com.weebly.gaborcsikos.backend.behavioral.chainofresponsibility;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

/**
 * Model for Chain of Responsible Design pattern
 * 
 * @author Gabor Csikos
 * 
 */
public class ChainOfResponsibilityModel extends DesignPatternModel {
	private String nextName;
	private String actionName;
	private ChainOfResponsibilityTemplate template;

	/**
	 * Default constructor
	 */
	public ChainOfResponsibilityModel() {

	}

	public ChainOfResponsibilityModel(final String packageName,
			final String className, final String nextName,
			final String actionName) {
		super(packageName, className);
		this.nextName = nextName;
		this.actionName = actionName;
	}

	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		template = new ChainOfResponsibilityTemplate(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				nextName, actionName);
		result.append(template.buildClass());
		return result.toString();
	}

	public void setNextName(final String nextName) {
		this.nextName = nextName;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(final String actionName) {
		this.actionName = actionName;
	}

	public String getNextName() {
		return nextName;
	}
}
