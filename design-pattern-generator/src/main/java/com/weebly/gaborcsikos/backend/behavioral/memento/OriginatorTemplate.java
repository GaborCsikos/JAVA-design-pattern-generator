package com.weebly.gaborcsikos.backend.behavioral.memento;

import static com.weebly.gaborcsikos.backend.utility.FieldMakerUtility.getFormattedField;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.utility.GeneralUtility;

/**
 * originator template for memento
 * 
 * @author Gabor Csikos
 * 
 */
public class OriginatorTemplate extends MementoTemplate {

	private final String mementoName;

	public OriginatorTemplate(final String packageName, final String className,
			final String stateType, final String stateName,
			final String mementoName) {
		super(packageName, className, stateType, stateName);
		this.mementoName = mementoName;
	}

	@Override
	public String buildClass() throws CanNotCreateClassException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBasicStucture());
		sb.append(getFormattedField(new FieldWithType(stateType, stateName)));
		sb.append(NEW_LINE);
		sb.append(set());
		sb.append(NEW_LINE);
		sb.append(save());
		sb.append(NEW_LINE);
		sb.append(restore());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private String set() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void set(final ").append(stateType)
				.append(" ").append(stateName).append(") {").append(NEW_LINE);
		sb.append(GeneralUtility.getSetting(stateName));
		sb.append(GeneralUtility.getSimpleEnd());
		return sb.toString();
	}

	private String save() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(mementoName).append(" ")
				.append("saveToMemento() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return new ").append(mementoName)
				.append("(").append(stateName).append(");").append(NEW_LINE);
		sb.append(GeneralUtility.getSimpleEnd());
		return sb.toString();
	}

	private String restore() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void restoreFromMemento(final ")
				.append(mementoName).append(" memento) {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append(stateName)
				.append(" = memento.getSavedState();").append(NEW_LINE);
		sb.append(GeneralUtility.getSimpleEnd());
		return sb.toString();
	}
}
