/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestFields.testFields;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.FACTORY_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.factory.FactoryModel;
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
				CLASS_NAME, TestHelperUtility.OBSERVER, true, testFields());
		TestHelperUtility.IMPELENTSPART = "";
		String expected = createFactory(true);
		String result = service.generatePattern(model);
		TestHelperUtility.printInfo(result);
		// assertEquals("Builder is  different", expected, result);
		// TODO TEST
	}

	private String createFactory(final boolean b) {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	@Test
	public void testFactory() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		FactoryModel model = new FactoryModel(PACKAGE_NAME, FACTORY_NAME,
				CLASS_NAME, TestHelperUtility.OBSERVER, false, testFields());
		TestHelperUtility.IMPELENTSPART = "";
		String expected = createFactory(true);
		String result = service.generatePattern(model);
		TestHelperUtility.printInfo(result);
		// assertEquals("Builder is  different", expected, result);
	}
}
