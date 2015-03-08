/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import static com.weebly.gaborcsikos.backend.api.IndentHelper.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.NEW_LINE;
import static com.weebly.gaborcsikos.backend.testutil.TestHelper.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelper.PACKAGE_NAME;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.testutil.TestHelper;

/**
 * Unit tests of {@link PatternGeneratorServiceImpl}
 * 
 * @author Gabor Csikos
 * 
 */
public class PatternGeneratorServiceImplTest {

	private PatternGeneratorService service;
	private BasicTemplate template;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new PatternGeneratorServiceImpl();
	}

	@Test
	public void testBasicTemplate() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		template = new BasicTemplate(PACKAGE_NAME, CLASS_NAME);
		String expected = generateExceptedClass();
		String result = service.generateClass(template);
		assertEquals("Generated class is different", expected, result);
	}

	@Test(expected = CanNotCreateClassException.class)
	public void testNullFields() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		template = new BasicTemplate(null, null);
		service.generateClass(template);
	}

	@Test(expected = CanNotCreateClassException.class)
	public void testEmptyFields() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		template = new BasicTemplate("", "");
		service.generateClass(template);
	}

	@Test(expected = CanNotCreateClassException.class)
	public void testNullTemplate() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		service.generateClass(null);
	}


	private String generateExceptedClass() {
		StringBuilder sb = new StringBuilder("package ");
		sb.append(TestHelper.PACKAGE_NAME + ";").append(DOUBLE_NEW_LINE)
				.append("public class " + TestHelper.CLASS_NAME + " {")
				.append(DOUBLE_NEW_LINE).append(NEW_LINE).append("}");
		return sb.toString();
	}
}
