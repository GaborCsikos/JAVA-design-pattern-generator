/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.FINAL_PARAMETER;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.MODIFIER;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.STRING_TYPE;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.THIS;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.VARIABLE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * Unit test of {@link FieldWithType}
 * 
 * @author Gabor Csikos
 * 
 */
public class FieldWithTypeTest {

	private FieldWithType field;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		field = new FieldWithType(STRING_TYPE, VARIABLE);
	}

	@Test
	public void testFormattedField() {
		String expected = getExpectedFormattedField();
		String actual = field.getFormattedField();
		TestHelperUtility.printInfo(actual);
		Assert.assertEquals("Formatted fields are not the same", expected,
				actual);
	}

	@Test
	public void getFieldForParameter() {
		String expected = getExpectedFieldForParameter();
		String actual = field.getFieldForParameter();
		TestHelperUtility.printInfo(actual);
		Assert.assertEquals("Formatted fields are not the same", expected,
				actual);
	}

	@Test
	public void getAssigmentForConstructor() {
		String expected = getExpectedAssigmentForConstructor();
		String actual = field.getAssigmentForConstructor();
		TestHelperUtility.printInfo(actual);
		Assert.assertEquals("Formatted fields are not the same", expected,
				actual);
	}

	private String getExpectedAssigmentForConstructor() {
		StringBuilder sb = new StringBuilder();
		sb.append(DOUBLE_INDENT).append(THIS)
				.append(VARIABLE).append(" = ").append(VARIABLE).append(";")
				.append(NEW_LINE);
		return sb.toString();
	}

	private String getExpectedFieldForParameter() {
		StringBuilder sb = new StringBuilder();
		sb.append(FINAL_PARAMETER).append(STRING_TYPE).append(" ")
				.append(VARIABLE).append(", ");
		return sb.toString();
	}

	private String getExpectedFormattedField() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(MODIFIER).append(STRING_TYPE).append(" ")
				.append(VARIABLE).append(";").append(NEW_LINE);
		return sb.toString();
	}

}
