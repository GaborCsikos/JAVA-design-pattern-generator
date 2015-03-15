/**
 * 
 */
package com.weebly.gaborcsikos.backend.utility;

import static com.weebly.gaborcsikos.backend.testutil.TestFields.testFields;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * Unit test of {@link ContructorMakerUtility}
 * 
 * @author Gabor Csikos
 * 
 */
public class ContructorMakerUtilityTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String expected = getExpectedConstructor();
		String result = ContructorMakerUtility.getFormttedConsructorFromFields(
				CLASS_NAME, testFields());
		TestHelperUtility.printInfo(expected);
		Assert.assertEquals("Generated constructor is different",result,expected);
	}

	private String getExpectedConstructor() {
			StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(CLASS_NAME).append("(")
				.append(parametersFormatted(testFields())).append(") {")
				.append(NEW_LINE);
		sb.append(fieldsAssigned(testFields()));
			sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
			return sb.toString();
	}

	private String fieldsAssigned(final List<FieldWithType> fields) {
		StringBuilder sb = new StringBuilder();
		for (FieldWithType field : fields) {
			sb.append(field.getAssigmentForConstructor());
		}
		return sb.toString();
	}

	private String parametersFormatted(final List<FieldWithType> fields) {
		StringBuilder sb = new StringBuilder();
		for (FieldWithType field : fields) {
			sb.append(field.getFieldForParameter());
		}
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}
}
