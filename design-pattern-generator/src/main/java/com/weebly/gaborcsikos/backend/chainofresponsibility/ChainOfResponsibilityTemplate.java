/**
 * 
 */
package com.weebly.gaborcsikos.backend.chainofresponsibility;

import static com.weebly.gaborcsikos.backend.api.ClassType.ABSTRACT_CLASS;
import static com.weebly.gaborcsikos.backend.utility.GeneralUtility.getUppercaseMethodName;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;

/**
 * Template for chain of responsible design pattern
 * 
 * @author Gabor Csikos
 * 
 */
public class ChainOfResponsibilityTemplate extends BasicTemplate {

	private String nextName;
	private String actionName;

	public ChainOfResponsibilityTemplate(final String packageName,
			final String className, final String nextName,
			final String actionName) {
		super(packageName, className);
		this.nextName = nextName;
		this.actionName = actionName;
	}
	@Override
	public String buildClass() throws CanNotCreateClassException {
		StringBuilder sb = new StringBuilder();
		super.setType(ABSTRACT_CLASS);
		sb.append(super.getBasicStucture());
		sb.append(setField());
		sb.append(NEW_LINE);
		sb.append(setAction());
		sb.append(NEW_LINE);
		sb.append(nextMethod());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	// TODO add unit tests
	private String nextMethod() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void set")
				.append(getUppercaseMethodName(nextName))
				.append("(").append(super.getClassName()).append(" ")
				.append(nextName).append(") {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("this.").append(nextName).append(" = ")
				.append(nextName).append(";").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	private String setAction() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public abstract void ").append(actionName)
				.append("();")
				.append(NEW_LINE);
		return sb.toString();
	}

	private String setField() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("protected ").append(super.getClassName())
				.append(" ").append(nextName).append(";").append(NEW_LINE);
		return sb.toString();
	}

	public String getNextName() {
		return nextName;
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

}
