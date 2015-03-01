/**
 * 
 */
package com.weebly.gaborcsikos.backend.singleton;

import static com.weebly.gaborcsikos.backend.api.IndentHelper.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.INDENT;

import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.FieldVariableIsEmptyException;

/**
 * @author Gabor Csikos
 *
 */
public class SingletonStatic extends SingletonTemplate {

	private final boolean isPrivate;

	public SingletonStatic(final String className, final String packageName,
			final String instanceName, final boolean isPrivate) {
		super(className, packageName, instanceName);
		this.instanceName = instanceName;
		this.isPrivate = isPrivate;
	}
	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		checkInstanceName();
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBasicStucture());
		sb.append(INDENT).append("private static final").append(getClassName())
				.append(" ").append(instanceName.toUpperCase())
				.append(" = new ").append(getClassName()).append("();\n\n");
		sb.append(createConstructor(isPrivate));
		sb.append(INDENT).append("public static ").append(getClassName())
				.append(" get").append(instanceName.toUpperCase())
				.append("() {\n");
		sb.append(DOUBLE_INDENT).append("return ")
				.append(instanceName.toUpperCase())
				.append(";\n");
		sb.append(INDENT).append("}\n");
		sb.append(super.getEndStructure());
		return sb.toString();
	}
}
