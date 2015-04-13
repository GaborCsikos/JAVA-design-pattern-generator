/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.behavioral.visitor.VisitorModel;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * Unit test of visitor creation
 * 
 * @author Gabor Csikos
 * 
 */
public class VisitorServiceTest {

	private PatternGeneratorService service;
	private static final String classTypeToVisit = "Object";
	private static final String classNameToVisit = "leaf";
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
		VisitorModel model = new VisitorModel(PACKAGE_NAME, CLASS_NAME,
				classTypeToVisit, classNameToVisit);
		String expected = makeModel();
		String result = service.generatePattern(model);
		TestHelperUtility.printInfo(result);
		assertEquals("Visitor pattern is different", expected,
				result);
	}

	private String makeModel() {

		StringBuilder sb = new StringBuilder();
		sb.append(TestHelperUtility.getBasicStucture(ClassType.INTERFACE));
		sb.append(getVisitmethod());
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}

	private String getVisitmethod() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("void visit(").append(classTypeToVisit)
				.append(" ").append(classNameToVisit).append(");")
				.append(NEW_LINE);
		return sb.toString();
	}
}
