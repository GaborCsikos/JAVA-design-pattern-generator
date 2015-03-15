/**
 * 
 */
package com.weebly.gaborcsikos.backend.singleton;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;

import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.utility.IndentHelperUtility;

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
		sb.append(IndentHelperUtility.INDENT).append(instanceName.toUpperCase())
				.append(";").append(DOUBLE_NEW_LINE);
		sb.append(IndentHelperUtility.INDENT).append(super.getClassName())
				.append("() {").append(DOUBLE_NEW_LINE);
		sb.append(IndentHelperUtility.INDENT).append("}");
		sb.append(DOUBLE_NEW_LINE).append("}");
		return sb.toString();
	}
}
