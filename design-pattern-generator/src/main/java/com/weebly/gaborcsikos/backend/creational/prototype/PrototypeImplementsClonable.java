/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.prototype;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.utility.GeneralUtility;

/**
 * Prototype implementation
 * 
 * @author Gabor Csikos
 * 
 */
public class PrototypeImplementsClonable extends PrototypeTemplate {

	public PrototypeImplementsClonable(final String className,
			final String packageName) {
		super(className, packageName);
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		super.setImplementsOrExtendsPart(" implements Cloneable");
		sb.append(super.getBasicStucture());
		sb.append(INDENT).append(GeneralUtility.OVERRIDE).append(NEW_LINE);
		sb.append(INDENT)
				.append("protected Object clone() throws CloneNotSupportedException {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return super.clone();")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		sb.append(super.getEndStructure());
		return sb.toString();
	}
}
