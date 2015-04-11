/**
 * 
 */
package com.weebly.gaborcsikos.backend.composite;

import static com.weebly.gaborcsikos.backend.utility.GeneralUtility.OVERRIDE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.TRIPLE_INDENT;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.utility.GeneralUtility;

/**
 * Template For Composite
 * 
 * @author Gabor Csikos
 * 
 */
public class CompositeTemplate extends BasicTemplate {

	private final String interfaceName;
	private final String interfaceMethodName;
	private final String overrridenMethod;
	private final String listName;

	public CompositeTemplate(final String packageName, final String className,
			final String interfaceName, final String interfaceMethodName,
			final String overrridenMethod, final String listName) {
		super(packageName, className);
		this.interfaceName = interfaceName;
		this.interfaceMethodName = interfaceMethodName;
		this.overrridenMethod = overrridenMethod;
		this.listName = listName;
	}
	@Override
	public String buildClass() throws CanNotCreateClassException {
		StringBuilder sb = new StringBuilder();
		String implementsPart = " implements " + interfaceName;
		super.setImplementsOrExtendsPart(implementsPart);
		sb.append(super.getBasicStucture());
		sb.append(makeList());
		sb.append(NEW_LINE);
		sb.append(makeMehod());
		sb.append(NEW_LINE);
		sb.append(makeGetter());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	// TODO add unit tests
	private String makeList() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("private List<").append(interfaceName)
				.append("> ")
				.append(listName).append(" = ").append("new ArrayList<")
				.append(interfaceName).append(">();").append(NEW_LINE);
		return sb.toString();
	}

	private String makeMehod() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE); // TODO add to
																// Utility
		sb.append(INDENT).append("public void ").append(overrridenMethod)
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("for (").append(interfaceName)
				.append(" element : ").append(listName).append(") {")
				.append(NEW_LINE);
		sb.append(TRIPLE_INDENT).append("element.").append(interfaceMethodName)
				.append("();").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("}").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	private String makeGetter() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("private List<").append(interfaceName)
		//TODO make getter and setter in utility
				.append("> ").append("get")
				.append(GeneralUtility.getUppercaseMethodName(listName))
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return ").append(listName).append(";")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

}
