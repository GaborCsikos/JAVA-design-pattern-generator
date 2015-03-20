/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLONE_METHOD_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.prototype.PrototypeModel;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * Unit tests of prototype creation
 * 
 * @author Gabor Csikos
 * 
 */
public class PrototypeServiceTest {
	private PatternGeneratorService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new PatternGeneratorServiceImpl();
	}

	@Test(expected = FieldVariableIsEmptyException.class)
	public void testFieldsAreEmpty() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		PrototypeModel prototype = new PrototypeModel(PACKAGE_NAME, CLASS_NAME);
		prototype.setImplementsClonable(false);
		prototype.setCloneMethodName(null);
		service.generatePattern(prototype);
	}

	@Test
	public void testImlementsClonable() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		PrototypeModel prototype = new PrototypeModel(PACKAGE_NAME, CLASS_NAME);
		prototype.setImplementsClonable(true);
		String expected = makeImplementsClonable();
		String result = service.generatePattern(prototype);
		TestHelperUtility.printInfo(result);
		assertEquals("Implements Clonable prototype is different", expected,
				result);
	}
	@Test
	public void testOwnClone() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		PrototypeModel prototype = new PrototypeModel(PACKAGE_NAME, CLASS_NAME);
		prototype.setImplementsClonable(false);
		prototype.setCloneMethodName(CLONE_METHOD_NAME);
		String expected = makeOwnClone();
		String result = service.generatePattern(prototype);
		TestHelperUtility.printInfo(result);
		assertEquals("Own clone prototype is different", expected, result);
	}

	private String makeImplementsClonable() {
		StringBuilder sb = new StringBuilder();
		TestHelperUtility.IMPELENTSPART = " implements Cloneable";
		sb.append(TestHelperUtility.getBasicStucture());
		sb.append(INDENT).append("@Override").append(NEW_LINE);
		sb.append(INDENT)
				.append("protected Object clone() throws CloneNotSupportedException {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return super.clone();")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}

	private String makeOwnClone() {
		StringBuilder sb = new StringBuilder();
		sb.append(TestHelperUtility.getBasicStucture());
		sb.append(INDENT).append("@Override").append(NEW_LINE);
		sb.append(INDENT).append("protected ")
.append(CLASS_NAME)
				.append("clone() throws CloneNotSupportedException {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT)
				.append("throw new CloneNotSupportedException();")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		sb.append(INDENT).append("public ").append(CLASS_NAME).append("  ")
				.append(CLONE_METHOD_NAME).append("() {")
.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return new ")
.append(CLASS_NAME)
				.append("();").append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}
}
