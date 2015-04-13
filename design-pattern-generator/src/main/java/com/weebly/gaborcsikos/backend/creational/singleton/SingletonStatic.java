/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.singleton;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;

/**
 * Singleton implementation
 * 
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
				.append(" = new ").append(getClassName()).append("();")
				.append(DOUBLE_NEW_LINE);
		sb.append(createConstructor(isPrivate));
		sb.append(INDENT).append("public static ").append(getClassName())
				.append(" get").append(instanceName.toUpperCase())
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return ")
				.append(instanceName.toUpperCase()).append(";")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		sb.append(super.getEndStructure());
		return sb.toString();
	}
}
