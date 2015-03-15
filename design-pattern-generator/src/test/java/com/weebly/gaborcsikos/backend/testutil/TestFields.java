/**
 * 
 */
package com.weebly.gaborcsikos.backend.testutil;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;

/**
 * @author Gabor Csikos
 *
 */
public final class TestFields {

	public static final String FIELD_TYPE = "String ";
	public static final String FIELD_ONE_NAME = "stringFieldOne";
	public static final String FIELD_TWO_NAME = "stringFieldTwo";

	private TestFields() {

	}

	public static final List<FieldWithType> testFields() {
		List<FieldWithType> fields = new ArrayList<FieldWithType>();
		FieldWithType fieldOne = new FieldWithType(FIELD_TYPE, FIELD_ONE_NAME);
		FieldWithType fieldTwo = new FieldWithType(FIELD_TYPE, FIELD_TWO_NAME);
		fields.add(fieldOne);
		fields.add(fieldTwo);
		return fields;
	}
}
