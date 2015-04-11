/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.factory;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;

/**
 * @author Gabor Csikos
 *
 */
public class SimpleFactoryTemplate extends FactoryTemplate {


	public SimpleFactoryTemplate(final String packageName,
			final String className, final String getMehtodType,
			final String classToReturn) {
		super(packageName, className, getMehtodType, classToReturn);
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBasicStucture());
		sb.append(getCommonPart());
			sb.append(getSimpleFactoryStructure());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private String getSimpleFactoryStructure() {
		StringBuilder sb = new StringBuilder();
		sb.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return new ").append(objectToReturn)
				.append("();").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE); // TODO make utility
		return sb.toString();
	}
}
