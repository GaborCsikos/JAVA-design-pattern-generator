/**
 * 
 */
package com.weebly.gaborcsikos.backend.prototype;

import static com.weebly.gaborcsikos.backend.api.IndentHelper.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.INDENT;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.NEW_LINE;

import org.apache.commons.lang3.StringUtils;

import com.sun.istack.internal.NotNull;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;

/**
 * @author Gabor Csikos
 *
 */
public class PrototypeOwnClone extends PrototypeTemplate {

	@NotNull
	private final String cloneMethodName;

	/**
	 * 
	 * @param className
	 *            the className
	 * @param packageName
	 *            the package name
	 */
	public PrototypeOwnClone(final String className, final String packageName,
			final String cloneMethodName) {
		super(className, packageName);
		this.cloneMethodName=cloneMethodName;
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		checkInstanceName();
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBasicStucture());
		sb.append(INDENT).append("@Override").append(NEW_LINE);
		sb.append(INDENT).append("protected ").append(super.getClassName())
				.append("clone() throws CloneNotSupportedException {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT)
				.append("throw new CloneNotSupportedException();")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		sb.append(INDENT).append("public ").append(super.getClassName())
				.append("  ").append(cloneMethodName).append(" {")
				.append(DOUBLE_NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private void checkInstanceName() throws FieldVariableIsEmptyException {
		if (StringUtils.isEmpty(cloneMethodName)) {
			throw new FieldVariableIsEmptyException();
		}
	}
}
