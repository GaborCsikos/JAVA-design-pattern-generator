/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import org.apache.commons.lang3.StringUtils;

import com.sun.istack.internal.NotNull;
import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;

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
	protected String className;

	public BasicTemplate() {
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
	}

	public void setTemplateData(final String packageName, final String className) {
		this.packageName = packageName;
		this.className = className;
	}
	public String getFullClass() throws CanNotCreateClassException {
		return getBasicStucture().append("\n}").toString();
	}

	private StringBuilder getBasicStucture() throws CanNotCreateClassException {
		checkIfFieldsAreEmpty();
		StringBuilder sb = new StringBuilder("package ");
		sb.append(packageName + ";\n\n").append(
				"public class "
				+ className + " {\n\n");
		return sb;
	}

	private void checkIfFieldsAreEmpty() throws CanNotCreateClassException {
		if (StringUtils.isEmpty(packageName) || StringUtils.isEmpty(className)) {
			throw new CanNotCreateClassException();
		}
	}
}
