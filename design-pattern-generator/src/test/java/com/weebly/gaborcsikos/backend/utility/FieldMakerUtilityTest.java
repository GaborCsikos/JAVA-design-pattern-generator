/**
 * 
 */
package com.weebly.gaborcsikos.backend.utility;

import static com.weebly.gaborcsikos.backend.testutil.TestFields.testFields;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * Unit test of {@link FieldMakerUtility}
 * 
 * @author Gabor Csikos
 * 
 */
public class FieldMakerUtilityTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() {
		String expected = getExpectedFields();
		String result = FieldMakerUtility.getFormattedFields(testFields());
		TestHelperUtility.printInfo(expected);
		Assert.assertEquals("Generated fields are different", result,
				expected);
	}

	private String getExpectedFields() {
		StringBuilder sb = new StringBuilder();
		for (FieldWithType field : testFields()) {
			sb.append(field.getFormattedField());
		}
		return sb.toString();
	}

}
