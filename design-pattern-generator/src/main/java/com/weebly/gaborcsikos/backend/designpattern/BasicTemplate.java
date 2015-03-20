/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import org.apache.commons.lang3.StringUtils;

import com.sun.istack.internal.NotNull;
import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;

/**
 * Basic template for a class
 * 
 * @author Gabor Csikos
 * 
 */
public class BasicTemplate {

	@NotNull
	private String packageName;
	@NotNull
	private String className;

	private String implementsPart = "";

	private ClassType type;

	public BasicTemplate() {
		type = ClassType.CLASS;
	}

	/**
	 * 
	 * @param packageName
	 *            the package name
	 * @param className
	 *            the class name
	 */
	public BasicTemplate(final String packageName, final String className) {
		this.packageName = packageName;
		this.className = className;
		type = ClassType.CLASS;
	}

	public void setTemplateData(final String packageName, final String className) {
		this.packageName = packageName;
		this.className = className;
		type = ClassType.CLASS;
	}

	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		return getBasicStucture().append(NEW_LINE).append("}").toString();
	}

	public ClassType getType() {
		return type;
	}

	public void setType(final ClassType type) {
		this.type = type;
	}

	public StringBuilder getBasicStucture() throws CanNotCreateClassException {
		checkIfFieldsAreEmpty();
		StringBuilder sb = new StringBuilder("package ");
		sb.append(packageName)
				.append(";")
				.append(DOUBLE_NEW_LINE)
				.append("public ").append(type.getName()).append(" ")
				.append(className).append(implementsPart).append(" {")
				.append(DOUBLE_NEW_LINE);
		return sb;
	}

	public String getEndStructure() {
		return NEW_LINE + "}";
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(final String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(final String className) {
		this.className = className;
	}
	private void checkIfFieldsAreEmpty() throws CanNotCreateClassException {
		if (StringUtils.isEmpty(packageName) || StringUtils.isEmpty(className)) {
			throw new CanNotCreateClassException();
		}
	}

	public String getImplementsPart() {
		return implementsPart;
	}

	public void setImplementsOrExtendsPart(final String implementsPart) {
		this.implementsPart = implementsPart;
	}
}
