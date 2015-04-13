/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestFields.testFields;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.FACTORY_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.OBSERVER;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.creational.factory.FactoryModel;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * @author Gabor Csikos
 *
 */
public class FactoryServiceTest {

	private PatternGeneratorService service;

	@Before
	public void setUp() throws Exception {
		service = new PatternGeneratorServiceImpl();
	}

	@Test
	public void testSimpleFactory() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		FactoryModel model = new FactoryModel(PACKAGE_NAME, FACTORY_NAME,
				CLASS_NAME, OBSERVER, true, testFields());
		TestHelperUtility.IMPELENTSPART = "Factory";
		String result = service.generatePattern(model);
		TestHelperUtility.printInfo(result);
		String expected = createSimpleFactory();
		assertEquals("Simple factory is  different", expected, result);
	}

	private String createSimpleFactory() {
		StringBuilder sb = new StringBuilder();
		sb.append(TestHelperUtility.getBasicStucture());
		sb.append(getCommonPart());
		sb.append(getSimpleFactoryStructure());
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}
	private String getCommonPart() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public static ").append(CLASS_NAME)
				.append(" ").append("get").append(CLASS_NAME);
		return sb.toString();
	}

	private String getSimpleFactoryStructure() {
		StringBuilder sb = new StringBuilder();
		sb.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return new ").append(OBSERVER)
				.append("();").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

}
