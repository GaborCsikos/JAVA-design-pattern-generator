/**
 * 
 */
package com.weebly.gaborcsikos.backend.utility;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

/**
 * General utility
 * 
 * @author Gabor Csikos
 * 
 */
public final class GeneralUtility {
	private GeneralUtility() {

	}

	public static String getUppercaseMethodName(final String name) {
		return Character.toString(name.charAt(0)).toUpperCase()
				+ name.substring(1);
	}

	public static final String OVERRIDE = "@Override";

	public static String getSetting(final String name) {
		StringBuilder sb = new StringBuilder();
		sb.append(DOUBLE_INDENT).append("this.").append(name).append(" = ")
				.append(name).append(";")
				.append(NEW_LINE);
		return sb.toString();
	}

	public static String getSimpleEnd() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	public static String getSimpleArrayList(final String listType,
			final String listName) {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("private List<").append(listType).append("> ")
				.append(listName).append(" = new ArrayList<").append(listType)
				.append(">();").append(NEW_LINE);
		return sb.toString();
	}
}
