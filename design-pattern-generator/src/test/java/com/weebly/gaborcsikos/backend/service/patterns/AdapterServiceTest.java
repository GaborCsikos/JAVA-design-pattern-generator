/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.EXTENDS_CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.METHOD_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.METHOD_NAME_TWO;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.STRING_TYPE;
import static com.weebly.gaborcsikos.backend.utility.GeneralUtility.OVERRIDE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.structural.adapter.AdapterModel;
import com.weebly.gaborcsikos.backend.testutil.TestFields;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;
import com.weebly.gaborcsikos.backend.utility.IndentHelperUtility;

/**
 * Unit test of adapter creation
 * 
 * @author Gabor Csikos
 * 
 */
public class AdapterServiceTest {

	private PatternGeneratorService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new PatternGeneratorServiceImpl();
	}


	@Test
	public void testAdaper() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		AdapterModel adapter = new AdapterModel(PACKAGE_NAME, CLASS_NAME,
				EXTENDS_CLASS_NAME, METHOD_NAME, METHOD_NAME_TWO,
 STRING_TYPE);
		adapter.setTarget(TestFields.testFields().get(0));
		adapter.setExtendedClass(EXTENDS_CLASS_NAME);
		String expected = makeAdapter();
		String result = service.generatePattern(adapter);
		TestHelperUtility.printInfo(result);
		assertEquals("Adapter pattern is different", expected,
				result);
	}

	private String makeAdapter() {
		StringBuilder sb = new StringBuilder();
		TestHelperUtility.IMPELENTSPART = " extends " + EXTENDS_CLASS_NAME;
		sb.append(TestHelperUtility.getBasicStucture());
		sb.append(TestHelperUtility.getField());
		sb.append(NEW_LINE);
		sb.append(TestHelperUtility.getConstructorWithParameter());
		sb.append(getAdaptedMethod());
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}

	private String getAdaptedMethod() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public ")
.append(STRING_TYPE).append(" ")
				.append(METHOD_NAME).append("() {").append(NEW_LINE);
		sb.append(IndentHelperUtility.DOUBLE_INDENT).append("return ")
				.append(TestFields.testFields().get(0).getName()).append(".")
				.append(METHOD_NAME_TWO)
.append("();").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}
}
