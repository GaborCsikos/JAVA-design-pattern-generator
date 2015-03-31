/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

/**
 * Field representation
 * 
 * @author Gabor Csikos
 * 
 */
public class FieldWithType {

	private static final String MODIFIER = "private ";
	private static final String FINAL_PARAMETER = "final ";
	private static final String THIS = "this.";
	private String type;
	private String name;
	
	public FieldWithType(final String type, final String name) {
		this.type = type;
		this.name = name;
	}

	public String getFormattedField() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(MODIFIER).append(type).append(" ")
				.append(name).append(";")
					.append(NEW_LINE);
		return sb.toString();
	}


	public String getFieldForParameter() {
		StringBuilder sb = new StringBuilder();
		sb.append(FINAL_PARAMETER).append(type).append(" ").append(name)
				.append(", ");
		return sb.toString();
	}

	public String getAssigmentForConstructor() {
		StringBuilder sb = new StringBuilder();
		sb.append(DOUBLE_INDENT).append(THIS)
				.append(name).append(" = ").append(name).append(";")
				.append(NEW_LINE);
		return sb.toString();
	}
	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getStringForDialog() {
		return type + " " + name;
	}

	public String getStringForFactoryDialog() {
		return type + "-->" + name;
	}
}
