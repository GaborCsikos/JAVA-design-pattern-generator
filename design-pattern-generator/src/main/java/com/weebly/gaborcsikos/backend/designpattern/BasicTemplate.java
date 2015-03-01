/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import org.apache.commons.lang3.StringUtils;

import com.sun.istack.internal.NotNull;
import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.FieldVariableIsEmptyException;

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
		return getBasicStucture().append("\n}").toString();
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
		sb.append(packageName + ";\n\n").append(
				"public " + type.getName() + " "
				+ className + " {\n\n");
		return sb;
	}

	public String getEndStructure() {
		return "\n}";
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
}
