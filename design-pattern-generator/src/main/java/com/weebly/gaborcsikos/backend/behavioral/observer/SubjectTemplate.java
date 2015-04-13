package com.weebly.gaborcsikos.backend.behavioral.observer;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.TRIPLE_INDENT;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;

/**
 * Template for subject
 * 
 * @author Gabor Csikos
 * 
 */
public class SubjectTemplate extends ObserverTemplate {

	private String observerName;
	private boolean arrayList;

	public SubjectTemplate(final String packageName, final String className,
			final String observerName, final boolean arrayList) {
		super(packageName, className);
		this.observerName = observerName;
		this.arrayList = arrayList;
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBasicStucture());
		sb.append(getListField());
		sb.append(getAttach());
		sb.append(getDetach());
		sb.append(getChange());
		sb.append(super.getEndStructure());
		return sb.toString();
	}
	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(final String observerName) {
		this.observerName = observerName;
	}

	public boolean isArrayList() {
		return arrayList;
	}

	public void setArrayList(final boolean arrayList) {
		this.arrayList = arrayList;
	}
	private String getListField() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("List<").append(observerName)
				.append("> observers = new ");
		if (arrayList) {
			sb.append("ArrayList<");
		} else {
			sb.append("LinkedList<");
		}
		sb.append(observerName).append(">();").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getDetach() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void remove").append(observerName)
				.append("(final ")
				.append(observerName).append(" observer) {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("this.observers.remove(observer);")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getAttach() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void add").append(observerName)
				.append("(final ").append(observerName).append(" observer) {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("this.observers.add(observer);")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getChange() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void change(){ ")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("for (").append(observerName)
				.append(" observer : observers) {").append(NEW_LINE);
		sb.append(TRIPLE_INDENT).append("observer.update();").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("}").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}
}
