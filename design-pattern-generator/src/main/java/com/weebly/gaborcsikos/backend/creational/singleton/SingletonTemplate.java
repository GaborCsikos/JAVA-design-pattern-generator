/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.singleton;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;

import org.apache.commons.lang3.StringUtils;

import com.sun.istack.internal.NotNull;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.utility.IndentHelperUtility;

/**
 * @author Gabor Csikos
 *
 */
public abstract class SingletonTemplate extends BasicTemplate {

	@NotNull
	protected String instanceName;

	public SingletonTemplate(final String className, final String packageName,
			final String instanceName) {
		super(className, packageName);
		this.instanceName = instanceName;
	}

	protected void checkInstanceName() throws FieldVariableIsEmptyException {
		if (StringUtils.isEmpty(instanceName)) {
			throw new FieldVariableIsEmptyException();
		}
	}

	protected String createConstructor(final boolean isPrivate) {
		StringBuilder sb = new StringBuilder();
		if (isPrivate) {
			sb.append(IndentHelperUtility.INDENT).append("private ");
		} else {
			sb.append(IndentHelperUtility.INDENT).append("protected ");
		}
		sb.append(getClassName()).append("() {").append(DOUBLE_NEW_LINE)
				.append(IndentHelperUtility.INDENT).append("}")
				.append(DOUBLE_NEW_LINE);
		return sb.toString();
	}
}
