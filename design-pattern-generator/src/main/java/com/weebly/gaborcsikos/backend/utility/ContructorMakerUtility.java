/**
 * 
 */
package com.weebly.gaborcsikos.backend.utility;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import java.util.List;

import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;


/**
 * Constructor maker with field
 * 
 * @author Gabor Csikos
 * 
 */
public final class ContructorMakerUtility {

	private ContructorMakerUtility() {

	}

	public static String getFormttedConsructorFromFields(
			final String className, final List<FieldWithType> fields) {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(className).append("(")
				.append(parametersFormatted(fields)).append(") {").append(NEW_LINE);
		sb.append(fieldsAssigned(fields));
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	public static String getFormttedConsructorFromField(final String className,
			final FieldWithType fields) {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(className).append("(")
				.append(parameterFormatted(fields)).append(") {")
				.append(NEW_LINE);
		sb.append(fieldAssigned(fields));
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}
	private static String fieldsAssigned(final List<FieldWithType> fields) {
		StringBuilder sb = new StringBuilder();
		for (FieldWithType field : fields) {
			sb.append(field.getAssigmentForConstructor());
		}
		return sb.toString();
	}

	private static String fieldAssigned(final FieldWithType field) {
		StringBuilder sb = new StringBuilder();
		sb.append(field.getAssigmentForConstructor());
		return sb.toString();
	}
	private static String parametersFormatted(
			final List<FieldWithType> fields) {
		StringBuilder sb = new StringBuilder();
		for (FieldWithType field : fields) {
			sb.append(field.getFieldForParameter());
		}
		if (sb.length() > 2) {
			sb.setLength(sb.length() - 2);
		}
		return sb.toString();
	}

	private static String parameterFormatted(final FieldWithType field) {
		StringBuilder sb = new StringBuilder();
		sb.append(field.getFieldForParameter());
		if (sb.length() > 2) {
			sb.setLength(sb.length() - 2);
		}
		return sb.toString();
	}
}
