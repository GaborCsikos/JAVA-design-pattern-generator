/**
 * 
 */
package com.weebly.gaborcsikos.backend.behavioral.memento;

import static com.weebly.gaborcsikos.backend.utility.FieldMakerUtility.getFormattedField;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;

/**
 * @author Gabor Csikos
 *
 */
public class MementoTemplateImpl extends MementoTemplate {

	public MementoTemplateImpl(final String packageName, final String className,
			final String stateType, final String stateName) {
		super(packageName, className, stateType, stateName);
	}

	@Override
	public String buildClass() throws CanNotCreateClassException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBasicStucture());
		sb.append(getFormattedField(new FieldWithType(stateType, stateName)));
		sb.append(NEW_LINE);
		sb.append(saveSate());
		sb.append(NEW_LINE);
		sb.append(getSaveState());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private String saveSate() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(super.getClassName())
				.append("(final ").append(stateType).append(" ")
				.append("stateToSave) {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append(stateName).append(" = stateToSave;")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	private String getSaveState() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(stateType).append(" ")
				.append("getSaved").append(stateName).append("() {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return state;")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	// TODO add unit tests
}
