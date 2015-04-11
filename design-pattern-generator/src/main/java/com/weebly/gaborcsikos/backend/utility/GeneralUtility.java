/**
 * 
 */
package com.weebly.gaborcsikos.backend.utility;

/**
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
}
