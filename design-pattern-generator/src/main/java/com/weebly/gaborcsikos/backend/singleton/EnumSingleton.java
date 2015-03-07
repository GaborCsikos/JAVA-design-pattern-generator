/**
 * 
 */
package com.weebly.gaborcsikos.backend.singleton;

import static com.weebly.gaborcsikos.backend.api.IndentHelper.DOUBLE_NEW_LINE;

import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.api.IndentHelper;

/**
 * @author Gabor Csikos
 *
 */
public class EnumSingleton extends SingletonTemplate {

	public EnumSingleton(final String className, final String packageName,
			final String instanceName) {
		super(className, packageName, instanceName);
		this.instanceName = instanceName;
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		checkInstanceName();
		StringBuilder sb = new StringBuilder();
		super.setType(ClassType.ENUM);
		sb.append(super.getBasicStucture());
		sb.append(IndentHelper.INDENT).append(instanceName.toUpperCase())
				.append(";").append(DOUBLE_NEW_LINE);
		sb.append(IndentHelper.INDENT).append(super.getClassName())
				.append("() {").append(DOUBLE_NEW_LINE);
		sb.append(IndentHelper.INDENT).append("}");
		sb.append(DOUBLE_NEW_LINE).append("}");
		return sb.toString();
	}
}
