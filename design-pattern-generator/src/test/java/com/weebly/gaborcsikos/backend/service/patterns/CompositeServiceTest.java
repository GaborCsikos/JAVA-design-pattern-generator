/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.utility.GeneralUtility.OVERRIDE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.TRIPLE_INDENT;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.structural.composite.CompositeModel;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;
import com.weebly.gaborcsikos.backend.utility.GeneralUtility;

/**
 * Unit test of Composite creation
 * 
 * @author Gabor Csikos
 * 
 */
public class CompositeServiceTest {

	private PatternGeneratorService service;
	private static final String interfaceName = "interfaceName";
	private static final String interfaceMethodName = "method";
	private static final String overridenMethod = "anotherMethod";
	private static final String listName = "lists";
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
		CompositeModel model = new CompositeModel(PACKAGE_NAME, CLASS_NAME,
				interfaceName, interfaceMethodName, overridenMethod, listName);
		String expected = makeModel();
		String result = service.generatePattern(model);
		TestHelperUtility.printInfo(result);
		assertEquals("Conmposite pattern is different", expected,
				result);
	}

	private String makeModel() {
		StringBuilder sb = new StringBuilder();
		String implementsPart = " implements " + interfaceName;
		TestHelperUtility.IMPELENTSPART = implementsPart;
		sb.append(TestHelperUtility.getBasicStucture());
		sb.append(makeList());
		sb.append(NEW_LINE);
		sb.append(makeMehod());
		sb.append(NEW_LINE);
		sb.append(makeGetter());
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}

	private String makeList() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("private List<").append(interfaceName)
				.append("> ").append(listName).append(" = ")
				.append("new ArrayList<").append(interfaceName).append(">();")
				.append(NEW_LINE);
		return sb.toString();
	}

	private String makeMehod() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public void ").append(overridenMethod)
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("for (").append(interfaceName)
				.append(" element : ").append(listName).append(") {")
				.append(NEW_LINE);
		sb.append(TRIPLE_INDENT).append("element.").append(interfaceMethodName)
				.append("();").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("}").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	private String makeGetter() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("private List<").append(interfaceName)
				.append("> ").append("get")
				.append(GeneralUtility.getUppercaseMethodName(listName))
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return ").append(listName).append(";")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}
}
