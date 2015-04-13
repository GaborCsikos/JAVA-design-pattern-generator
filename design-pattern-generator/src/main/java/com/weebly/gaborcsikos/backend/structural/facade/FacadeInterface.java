/**
 * 
 */
package com.weebly.gaborcsikos.backend.structural.facade;

import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;

/**
 * Facade implementation template
 * 
 * @author Gabor Csikos
 * 
 */
public class FacadeInterface extends FacadeTemplate {

	public FacadeInterface(final String className, final String packageName) {
		super(className, packageName);
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		super.setType(ClassType.INTERFACE);
		sb.append(super.getBasicStucture());
		sb.append(super.getEndStructure());
		return sb.toString();
	}
}
