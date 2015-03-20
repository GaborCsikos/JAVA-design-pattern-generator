/**
 * 
 */
package com.weebly.gaborcsikos.backend.utility;

import java.util.List;

import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;

/**
 * @author Gabor Csikos
 *
 */
public final class FieldMakerUtility {

	private FieldMakerUtility() {

	}

	public static String getFormattedFields(final List<FieldWithType> fields) {
		StringBuilder sb = new StringBuilder();
		for (FieldWithType field : fields) {
			sb.append(field.getFormattedField());
		}
		return sb.toString();
	}

	public static String getFormattedField(final FieldWithType field) {
		StringBuilder sb = new StringBuilder();
		sb.append(field.getFormattedField());
		return sb.toString();
	}
}
