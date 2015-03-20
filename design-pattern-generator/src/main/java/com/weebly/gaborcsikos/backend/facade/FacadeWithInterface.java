/**
 * 
 */
package com.weebly.gaborcsikos.backend.facade;

import java.util.List;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.utility.IndentHelperUtility;

/**
 * @author Gabor Csikos
 *
 */
public class FacadeWithInterface extends FacadeTemplate {

	private final String newClassName = super.getClassName() + "Impl";

	public FacadeWithInterface(final String packageName,
			final String className, final List<FieldWithType> fieldsToAdd) {
		super(packageName, className);
		addFields(fieldsToAdd);
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		String implement = " implements " + super.getClassName();
		super.setImplementsOrExtendsPart(implement);
		super.setClassName(newClassName);
		sb.append(super.getBasicStucture());
		sb.append(getFields());
		sb.append(IndentHelperUtility.NEW_LINE);
		sb.append(getConstructor());
		sb.append(super.getEndStructure());
		return sb.toString();
	}
}
