/**
 * 
 */
package com.weebly.gaborcsikos.backend.api;

/**
 * @author Gabor Csikos
 *
 */
public final class IndentHelper {

	public static final String INDENT = "   ";
	public static final String DOUBLE_INDENT = INDENT + INDENT;
	public static final String TRIPLE_INDENT = DOUBLE_INDENT + INDENT;

	public static final String NEW_LINE = System.lineSeparator();
	public static final String DOUBLE_NEW_LINE = NEW_LINE
			+ System.lineSeparator();
}
