/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.facade.FacadeModel;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.testutil.TestFields;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;
import com.weebly.gaborcsikos.backend.utility.IndentHelperUtility;

/**
 * @author Gabor Csikos
 *
 */
public class FacadeServiceTest {
	private PatternGeneratorService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new PatternGeneratorServiceImpl();
	}

	@Test(expected = FieldVariableIsEmptyException.class)
	public void testNormalFacadeNofIelds() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		FacadeModel facade = new FacadeModel(PACKAGE_NAME, CLASS_NAME);
		service.generatePattern(facade);
	}

	@Test
	public void testNormalFacade() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		FacadeModel facade = new FacadeModel(PACKAGE_NAME, CLASS_NAME);
		facade.addAllFields(TestFields.testFields());
		String expected = createNormalFacade();
		String result = service.generatePattern(facade);
		TestHelperUtility.printInfo(result);
		assertEquals("Normal Facade is  different", expected, result);
	}

	@Test
	public void testImpelentsFacade() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		FacadeModel facade = new FacadeModel(PACKAGE_NAME, CLASS_NAME);
		facade.setWithInterface(true);
		facade.addAllFields(TestFields.testFields());
		String expected = createFacadeWithInterface();
		String result = service.generatePattern(facade);
		TestHelperUtility.printInfo(result);
		assertEquals("Implemented Facade is  different", expected, result);
	}

	@Test
	public void testInterface() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		FacadeModel facade = new FacadeModel(PACKAGE_NAME, CLASS_NAME);
		facade.setWithInterface(true);
		facade.addAllFields(TestFields.testFields());
		String expected = createFacadeWithInterface();
		String expectedFacade = creatExpectedFacade();
		String result = service.generatePattern(facade);
		String resultFacade = service.generatePattern(facade);
		TestHelperUtility.printInfo(result);
		TestHelperUtility.printInfo(resultFacade);
		assertEquals("Implemented Facade is  different", expected, result);
		assertEquals("InterFace is different", expectedFacade, resultFacade);
	}

	private String creatExpectedFacade() {
		StringBuilder sb = new StringBuilder();
		TestHelperUtility.IMPELENTSPART = "";
		sb.append(TestHelperUtility.getBasicStucture(ClassType.INTERFACE));
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}

	private String createFacadeWithInterface() {
		StringBuilder sb = new StringBuilder();
		String implement = " implements " + CLASS_NAME;
		String newClassName = CLASS_NAME + "Impl";
		TestHelperUtility.IMPELENTSPART = implement;
		sb.append(TestHelperUtility.getBasicStucture(newClassName));
		sb.append(TestHelperUtility.getFields());
		sb.append(IndentHelperUtility.NEW_LINE);
		sb.append(TestHelperUtility.getConstructor(newClassName));
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}

	private String createNormalFacade() {
		StringBuilder sb = new StringBuilder();
		TestHelperUtility.IMPELENTSPART = "";
		sb.append(TestHelperUtility.getBasicStucture());
		sb.append(TestHelperUtility.getFields());
		sb.append(IndentHelperUtility.NEW_LINE);
		sb.append(TestHelperUtility.getConstructor());
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}

}
