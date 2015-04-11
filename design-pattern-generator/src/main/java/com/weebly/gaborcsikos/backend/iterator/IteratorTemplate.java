/**
 * 
 */
package com.weebly.gaborcsikos.backend.iterator;

import static com.weebly.gaborcsikos.backend.utility.GeneralUtility.OVERRIDE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;

/**
 * Template for Iterator
 * @author Gabor Csikos
 *
 */
public class IteratorTemplate extends BasicTemplate {

	private final boolean removeSupported;
	private final String classToIterate;
	
	public IteratorTemplate(final String packageName, final String className,final String classToIterate,final boolean removeSupported){
		super(packageName, className);
		this.classToIterate = classToIterate;
		this.removeSupported = removeSupported;
	}
	
	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		String implementsPart = " implements Iterator" + "<" + classToIterate
				+ ">";
		super.setImplementsOrExtendsPart(implementsPart);
		sb.append(super.getBasicStucture());
		sb.append(getFields());
		sb.append(getConstructor());
		sb.append(getHasNext());
		sb.append(getNext());
		sb.append(getRemove());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private String getRemove() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public void remove() {").append(NEW_LINE);
		if (removeSupported) {
			sb.append(DOUBLE_INDENT).append("//TODO implement remove")
					.append(NEW_LINE);
		} else {
			sb.append(DOUBLE_INDENT)
					.append("throw new UnsupportedOperationException();")
					.append(NEW_LINE);
		}
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getNext() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public ").append(classToIterate)
				.append(" next() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return null;")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getHasNext() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public boolean hasNext() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return index < size;")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getConstructor() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(super.getClassName())
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("this.index = 0;").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("//TODO add size").append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getFields() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("private int size;").append(NEW_LINE);
		sb.append(INDENT).append("private int index;").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}
}
