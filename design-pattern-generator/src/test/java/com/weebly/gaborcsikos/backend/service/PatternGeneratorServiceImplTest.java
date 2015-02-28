/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
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
	public void testBasicTemplate() throws CanNotCreateClassException {
		template = new BasicTemplate(TestHelper.PACKAGE_NAME,
				TestHelper.CLASS_NAME);
		String expected = generateExceptedClass();
		String result = service.generateClass(template);
		TestHelper.printInfo(result);
		assertEquals("Generated class is different", expected, result);
	}

	@Test(expected = CanNotCreateClassException.class)
	public void testNullFields() throws CanNotCreateClassException {
		template = new BasicTemplate(null, null);
		service.generateClass(template);
	}

	@Test(expected = CanNotCreateClassException.class)
	public void testEmptyFields() throws CanNotCreateClassException {
		template = new BasicTemplate("", "");
		service.generateClass(template);
	}

	@Test(expected = CanNotCreateClassException.class)
	public void testNullTemplate() throws CanNotCreateClassException {
		service.generateClass(null);
	}

	private String generateExceptedClass() {
		StringBuilder sb = new StringBuilder("package ");
		sb.append(TestHelper.PACKAGE_NAME + ";\n\n")
				.append("public class " + TestHelper.CLASS_NAME + " {\n\n")
				.append("\n}");
		return sb.toString();
	}

}
