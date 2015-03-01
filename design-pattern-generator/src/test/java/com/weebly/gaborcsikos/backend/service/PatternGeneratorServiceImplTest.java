/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import static com.weebly.gaborcsikos.backend.api.IndentHelper.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.INDENT;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.TRIPLE_INDENT;
import static com.weebly.gaborcsikos.backend.testutil.TestHelper.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelper.INSTANCE;
import static com.weebly.gaborcsikos.backend.testutil.TestHelper.INTANCE_FIRTS_UPPER;
import static com.weebly.gaborcsikos.backend.testutil.TestHelper.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelper.getBasicStucture;
import static com.weebly.gaborcsikos.backend.testutil.TestHelper.getEndStructure;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.api.IndentHelper;
import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.singleton.Singleton;
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

	// SINGLETON
	@Test
	public void testEnumSingleton() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		Singleton singleton = new Singleton(PACKAGE_NAME, CLASS_NAME);
		singleton.setEnumType(true);
		singleton.setInstanceName(INSTANCE);
		String expected = createSingleton();
		String result = service.generateSingleton(singleton);
		TestHelper.printInfo(result);
		assertEquals("Enum Singleton is different", expected, result);
	}
	
	@Test(expected = FieldVariableIsEmptyException.class)
	public void testFieldsAreEmpty() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		Singleton singleton = new Singleton(PACKAGE_NAME, CLASS_NAME);
		singleton.setEnumType(true);
		service.generateSingleton(singleton);
	}

	@Test
	public void testDynamicallyLoadedSingleton()
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		Singleton singleton = new Singleton(PACKAGE_NAME, CLASS_NAME);
		singleton.setDynamicallyLoaded(true);
		singleton.setConstructorPrivate(true);
		singleton.setInstanceName(INSTANCE);
		String expected = createDynamicSingleton();
		String result = service.generateSingleton(singleton);
		TestHelper.printInfo(result);
		assertEquals("Dynamically loaded Singleton is different", expected,
				result);
	}
	
	@Test
	public void testStaticallyLoadedSingleton()
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		Singleton singleton = new Singleton(PACKAGE_NAME, CLASS_NAME);
		singleton.setStaticallyLoaded(true);
		singleton.setConstructorPrivate(true);
		singleton.setInstanceName(INSTANCE);
		String expected = createStaticSingleton();
		String result = service.generateSingleton(singleton);
		TestHelper.printInfo(result);
		assertEquals("Dynamically loaded Singleton is different", expected,
				result);
	}

	private String createStaticSingleton() {
		StringBuilder sb = new StringBuilder();
		sb.append(getBasicStucture());
		sb.append(INDENT).append("private static final").append(CLASS_NAME)
				.append(" ").append(INSTANCE.toUpperCase()).append(" = new ")
				.append(CLASS_NAME).append("();\n\n");
		sb.append(createConstructor(true));
		sb.append(INDENT).append("public static ").append(CLASS_NAME)
				.append(" get").append(INSTANCE.toUpperCase())
				.append("() {\n");
		sb.append(DOUBLE_INDENT).append("return ")
				.append(INSTANCE.toUpperCase()).append(";\n");
		sb.append(INDENT).append("}\n");
		sb.append(getEndStructure());
		return sb.toString();
	}

	private String createDynamicSingleton() {
		StringBuilder sb = new StringBuilder();
		sb.append(getBasicStucture());
		sb.append(INDENT).append("private static ").append(CLASS_NAME)
				.append(" ").append(INSTANCE).append(";\n\n");
		sb.append(createConstructor(true));
		sb.append(INDENT).append("public static ").append(CLASS_NAME)
				.append(" get").append(INTANCE_FIRTS_UPPER).append("() {\n");
		sb.append(DOUBLE_INDENT).append("if (").append(INSTANCE)
				.append(" == null) {\n");
		sb.append(TRIPLE_INDENT).append("create")
.append("Instance")
				.append("();\n");
		sb.append(DOUBLE_INDENT).append("}\n");
		sb.append(DOUBLE_INDENT).append("return ").append(INSTANCE)
				.append(";\n");
		sb.append(INDENT).append("}\n\n");
		sb.append(INDENT).append("private synchronized static void ")
				.append("create").append(INTANCE_FIRTS_UPPER)
				.append("() {\n");
		sb.append(DOUBLE_INDENT).append("if (").append(INSTANCE)
				.append(" == null) {\n");
		sb.append(TRIPLE_INDENT).append(INSTANCE).append(" = new ")
				.append(CLASS_NAME).append("();\n");
		sb.append(DOUBLE_INDENT).append("}\n");
		sb.append(INDENT).append("}\n");
		sb.append(getEndStructure());
		return sb.toString();
	}

	private String createSingleton() {
		StringBuilder sb = new StringBuilder("package ");
		sb.append(TestHelper.PACKAGE_NAME + ";\n\n").append(
				"public " + ClassType.ENUM.getName() + " "
						+ TestHelper.CLASS_NAME + " {\n\n");
		sb.append(IndentHelper.INDENT).append(TestHelper.INSTANCE.toUpperCase())
				.append(";\n\n");
		sb.append(IndentHelper.INDENT).append(TestHelper.CLASS_NAME)
				.append("() {\n\n");
		sb.append(IndentHelper.INDENT).append("}");
		sb.append("\n\n}");
		return sb.toString();
	}

	private String generateExceptedClass() {
		StringBuilder sb = new StringBuilder("package ");
		sb.append(TestHelper.PACKAGE_NAME + ";\n\n")
				.append("public class " + TestHelper.CLASS_NAME + " {\n\n")
				.append("\n}");
		return sb.toString();
	}

	private String createConstructor(final boolean isPrivate) {
		StringBuilder sb = new StringBuilder();
		if (isPrivate) {
			sb.append(IndentHelper.INDENT).append("private ");
		} else {
			sb.append(IndentHelper.INDENT).append("protected ");
		}
		sb.append(CLASS_NAME).append("() {\n\n")
				.append(IndentHelper.INDENT).append("}\n\n");
		return sb.toString();
	}
}
