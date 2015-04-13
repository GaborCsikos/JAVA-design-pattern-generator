/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.utility.GeneralUtility.getUppercaseMethodName;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.behavioral.chainofresponsibility.ChainOfResponsibilityModel;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * Unit test of COR creation
 * 
 * @author Gabor Csikos
 * 
 */
public class ChainOfResServiceTest {

	private PatternGeneratorService service;
	private static final String nextName = "next";
	private static final String actionName = "action";
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
		ChainOfResponsibilityModel cor = new ChainOfResponsibilityModel(
				PACKAGE_NAME, CLASS_NAME, nextName, actionName);
		String expected = makeCor();
		String result = service.generatePattern(cor);
		TestHelperUtility.printInfo(result);
		assertEquals("COR pattern is different", expected,
				result);
	}

	private String makeCor() {
		StringBuilder sb = new StringBuilder();
		TestHelperUtility.IMPELENTSPART = "";
		sb.append(TestHelperUtility.getBasicStucture(ClassType.ABSTRACT_CLASS));
		sb.append(setField());
		sb.append(NEW_LINE);
		sb.append(setAction());
		sb.append(NEW_LINE);
		sb.append(nextMethod());
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}
	private String nextMethod() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void set")
				.append(getUppercaseMethodName(nextName))
				.append("(").append(CLASS_NAME).append(" ")
				.append(nextName).append(") {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("this.").append(nextName).append(" = ")
				.append(nextName).append(";").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	private String setAction() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public abstract void ").append(actionName)
				.append("();")
				.append(NEW_LINE);
		return sb.toString();
	}

	private String setField() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("protected ").append(CLASS_NAME)
				.append(" ").append(nextName).append(";").append(NEW_LINE);
		return sb.toString();
	}
}
