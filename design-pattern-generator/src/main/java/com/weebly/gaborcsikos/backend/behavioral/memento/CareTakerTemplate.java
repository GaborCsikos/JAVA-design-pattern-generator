package com.weebly.gaborcsikos.backend.behavioral.memento;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.utility.GeneralUtility;

/**
 * Template for Caretaker in Memento
 * 
 * @author Gabor Csikos
 * 
 */
public class CareTakerTemplate extends MementoTemplate {

	private final String mementoName;

	public CareTakerTemplate(final String packageName, final String className,
			final String stateType, final String stateName,
			final String mementoName) {
		super(packageName, className, stateType, stateName);
		this.mementoName = mementoName;
	}

	@Override
	public String buildClass() throws CanNotCreateClassException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBasicStucture());
		sb.append(GeneralUtility.getSimpleArrayList(mementoName, "savedStates"));
		sb.append(NEW_LINE);
		sb.append(addMemento());
		sb.append(NEW_LINE);
		sb.append(getMemento());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private String addMemento() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void add").append(mementoName)
				.append("(final ").append(mementoName).append(" memento) {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("savedStates.add(memento);")
				.append(NEW_LINE);
		sb.append(GeneralUtility.getSimpleEnd());
		return sb.toString();
	}

	private String getMemento() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(mementoName).append(" ")
				.append("getMemento(final int index) {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return savedStates.get(index);")
				.append(NEW_LINE);
		sb.append(GeneralUtility.getSimpleEnd());
		return sb.toString();
	}

}
