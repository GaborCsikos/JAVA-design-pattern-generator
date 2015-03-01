/**
 * 
 */
package com.weebly.gaborcsikos.backend.singleton;

import org.apache.commons.lang3.StringUtils;

import com.sun.istack.internal.NotNull;
import com.weebly.gaborcsikos.backend.api.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.api.IndentHelper;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;

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
			sb.append(IndentHelper.INDENT).append("private ");
		} else {
			sb.append(IndentHelper.INDENT).append("protected ");
		}
		sb.append(getClassName()).append("() {\n\n")
				.append(IndentHelper.INDENT).append("}\n\n");
		return sb.toString();
	}
}
