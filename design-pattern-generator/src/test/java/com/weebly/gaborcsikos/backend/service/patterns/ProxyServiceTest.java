/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.utility.FieldMakerUtility.getFormattedField;
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
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.structural.proxy.ProxyModel;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * Unit test of proxy creation
 * 
 * @author Gabor Csikos
 * 
 */
public class ProxyServiceTest {

	private PatternGeneratorService service;
	private static final String extendendClass = "SecondClass";
	private static final String extendendIsntance = " extendedInstance";
	private static final String overridenMethod = "overridenMethod";
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
		ProxyModel model = new ProxyModel(PACKAGE_NAME, CLASS_NAME,
				extendendClass, extendendIsntance, overridenMethod);
		String expected = makeModel();
		String result = service.generatePattern(model);
		TestHelperUtility.printInfo(result);
		assertEquals("Proxy pattern is different", expected,
				result);
	}

	private String makeModel() {
		StringBuilder sb = new StringBuilder();
		String extendsPart = " extends " + extendendClass;
		TestHelperUtility.IMPELENTSPART = extendsPart;
		sb.append(TestHelperUtility.getBasicStucture());
		sb.append(getFormattedField(new FieldWithType(extendendClass,
				extendendIsntance)));
		sb.append(NEW_LINE);
		sb.append(makeConstructor());
		sb.append(NEW_LINE);
		sb.append(makeMethod());
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}

	private String makeConstructor() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(CLASS_NAME)
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("super();").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	private String makeMethod() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public void ").append(overridenMethod)
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("if (").append(extendendIsntance)
				.append(" == ").append("null").append(") {").append(NEW_LINE);
		sb.append(TRIPLE_INDENT).append(extendendIsntance).append(" = new ")
				.append(extendendClass).append("();").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("}").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append(extendendIsntance).append(".")
				.append(overridenMethod).append("()").append(";")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}
}
