package com.weebly.gaborcsikos.backend.observer;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;

/**
 * 
 * @author Gabor Csikos
 * 
 */
public class ObserverInterfaceTemplate extends ObserverTemplate {

	public ObserverInterfaceTemplate(final String packageName,
			final String className) {
		super(packageName, className);
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		super.setType(ClassType.INTERFACE);
		sb.append(super.getBasicStucture());
		sb.append(INDENT).append("void update();").append(NEW_LINE);
		sb.append(super.getEndStructure());
		return sb.toString();
	}
}
