package com.weebly.gaborcsikos.backend.singleton;

import static com.weebly.gaborcsikos.backend.api.IndentHelper.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.INDENT;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.TRIPLE_INDENT;

import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.FieldVariableIsEmptyException;

/**
 * 
 * @author Gabor Csikos
 * 
 */
public class SingletonDynamic extends SingletonTemplate {

	private final boolean isPrivate;
	public SingletonDynamic(final String className, final String packageName,
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
		sb.append(INDENT).append("private static ")
				.append(getClassName()).append(" ").append(instanceName)
				.append(";\n\n");
		sb.append(createConstructor(isPrivate));
		sb.append(INDENT).append("public static ")
				.append(getClassName()).append(" get")
				.append(createFirstUppercase()).append("() {\n");
		sb.append(DOUBLE_INDENT).append("if (").append(instanceName).append(" == null) {\n");
		sb.append(TRIPLE_INDENT).append("create").append(createFirstUppercase()).append("();\n");
		sb.append(DOUBLE_INDENT).append("}\n");
		sb.append(DOUBLE_INDENT).append("return ").append(instanceName)
				.append(";\n");
		sb.append(INDENT).append("}\n\n");
		sb.append(INDENT).append("private synchronized static void ").append("create").append(createFirstUppercase()).append("() {\n");
		sb.append(DOUBLE_INDENT).append("if (").append(instanceName)
				.append(" == null) {\n");
		sb.append(TRIPLE_INDENT).append(instanceName).append(" = new ").append(getClassName()).append("();\n");
		sb.append(DOUBLE_INDENT).append("}\n");
		sb.append(INDENT).append("}\n");
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private String createFirstUppercase() {
		String toUpperInstance = instanceName;
		return toUpperInstance.substring(0, 1).toUpperCase()
				+ toUpperInstance.substring(1);
	}
}
