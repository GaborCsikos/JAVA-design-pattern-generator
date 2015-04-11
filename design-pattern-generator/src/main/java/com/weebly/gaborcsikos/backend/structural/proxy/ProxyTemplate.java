/**
 * 
 */
package com.weebly.gaborcsikos.backend.structural.proxy;

import static com.weebly.gaborcsikos.backend.utility.GeneralUtility.OVERRIDE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.TRIPLE_INDENT;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;

/**
 * @author Gabor Csikos
 *
 */
public class ProxyTemplate extends BasicTemplate {

	private final String extendendClass;
	private final String extendendIsntance;
	private final String overridenMethod;

	public ProxyTemplate(final String packageName, final String className,
			final String extendendClass, final String extendendIsntance,
			final String overridenMethod) {
		super(packageName, className);
		this.extendendIsntance = extendendIsntance;
		this.extendendClass = extendendClass;
		this.overridenMethod = overridenMethod;
	}
	@Override
	public String buildClass() throws CanNotCreateClassException {
		StringBuilder sb = new StringBuilder();
		String extendsPart = " extends " + extendendClass;
		super.setImplementsOrExtendsPart(extendsPart);
		sb.append(super.getBasicStucture());
		sb.append(makeField());
		sb.append(NEW_LINE);
		sb.append(makeConstructor());
		sb.append(NEW_LINE);
		sb.append(makeMethod());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	// TODO add unit tests
	private String makeField() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("private ").append(extendendClass).append(" ")
				.append(extendendIsntance).append(";")
.append(NEW_LINE);
		return sb.toString();
	}

	private String makeConstructor() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(super.getClassName())
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("super();").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	private String makeMethod() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public void ").append(overridenMethod)
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("if (").append(extendendIsntance)
				.append(" == ").append("null").append(") {").append(NEW_LINE);
		sb.append(TRIPLE_INDENT).append(extendendIsntance).append(" = new ")
				.append(extendendClass).append("();").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("}").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append(extendendIsntance).append(".")
				.append(overridenMethod).append("()").append(";")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}
}
