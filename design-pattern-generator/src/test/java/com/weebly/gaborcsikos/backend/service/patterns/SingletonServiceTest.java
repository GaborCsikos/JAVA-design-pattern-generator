/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.api.IndentHelper.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.INDENT;
import static com.weebly.gaborcsikos.backend.api.IndentHelper.NEW_LINE;
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

import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.IndentHelper;
import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.singleton.SingletonModel;
import com.weebly.gaborcsikos.backend.testutil.TestHelper;

/**
 * @author Gabor Csikos
 *
 */
public class SingletonServiceTest {
	private PatternGeneratorService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new PatternGeneratorServiceImpl();
	}

	@Test
	public void testEnumSingleton() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		SingletonModel singleton = new SingletonModel(PACKAGE_NAME, CLASS_NAME);
		singleton.setEnumType(true);
		singleton.setInstanceName(INSTANCE);
		String expected = createSingleton();
		String result = service.generatePattern(singleton);
		TestHelper.printInfo(result);
		assertEquals("Enum Singleton is different", expected, result);
	}

	@Test(expected = FieldVariableIsEmptyException.class)
	public void testFieldsAreEmpty() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		SingletonModel singleton = new SingletonModel(PACKAGE_NAME, CLASS_NAME);
		singleton.setEnumType(true);
		service.generatePattern(singleton);
	}

	@Test
	public void testDynamicallyLoadedSingleton()
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		SingletonModel singleton = new SingletonModel(PACKAGE_NAME, CLASS_NAME);
		singleton.setLazyLoaded(true);
		singleton.setConstructorPrivate(true);
		singleton.setInstanceName(INSTANCE);
		String expected = createDynamicSingleton();
		String result = service.generatePattern(singleton);
		TestHelper.printInfo(result);
		assertEquals("Dynamically loaded Singleton is different", expected,
				result);
	}

	@Test
	public void testStaticallyLoadedSingleton()
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		SingletonModel singleton = new SingletonModel(PACKAGE_NAME, CLASS_NAME);
		singleton.setEagerLoaded(true);
		singleton.setConstructorPrivate(true);
		singleton.setInstanceName(INSTANCE);
		String expected = createStaticSingleton();
		String result = service.generatePattern(singleton);
		TestHelper.printInfo(result);
		assertEquals("Dynamically loaded Singleton is different", expected,
				result);
	}

	private String createStaticSingleton() {
		StringBuilder sb = new StringBuilder();
		sb.append(getBasicStucture());
		sb.append(INDENT).append("private static final").append(CLASS_NAME)
				.append(" ").append(INSTANCE.toUpperCase()).append(" = new ")
				.append(CLASS_NAME).append("();").append(DOUBLE_NEW_LINE);
		sb.append(createConstructor(true));
		sb.append(INDENT).append("public static ").append(CLASS_NAME)
				.append(" get").append(INSTANCE.toUpperCase()).append("() {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return ")
				.append(INSTANCE.toUpperCase()).append(";").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		sb.append(getEndStructure());
		return sb.toString();
	}

	private String createDynamicSingleton() {
		StringBuilder sb = new StringBuilder();
		sb.append(getBasicStucture());
		sb.append(INDENT).append("private static ").append(CLASS_NAME)
				.append(" ").append(INSTANCE).append(";")
				.append(DOUBLE_NEW_LINE);
		sb.append(createConstructor(true));
		sb.append(INDENT).append("public static ").append(CLASS_NAME)
				.append(" get").append(INTANCE_FIRTS_UPPER).append("() {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("if (").append(INSTANCE)
				.append(" == null) {").append(NEW_LINE);
		sb.append(TRIPLE_INDENT).append("create").append("Instance")
				.append("();").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("}").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return ").append(INSTANCE).append(";")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		sb.append(INDENT).append("private synchronized static void ")
				.append("create").append(INTANCE_FIRTS_UPPER).append("() {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("if (").append(INSTANCE)
				.append(" == null) {").append(NEW_LINE);
		sb.append(TRIPLE_INDENT).append(INSTANCE).append(" = new ")
				.append(CLASS_NAME).append("();").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("}").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		sb.append(getEndStructure());
		return sb.toString();
	}

	private String createSingleton() {
		StringBuilder sb = new StringBuilder("package ");
		sb.append(TestHelper.PACKAGE_NAME + ";")
				.append(DOUBLE_NEW_LINE)
				.append("public " + ClassType.ENUM.getName() + " "
						+ TestHelper.CLASS_NAME + " {").append(DOUBLE_NEW_LINE);
		sb.append(IndentHelper.INDENT)
				.append(TestHelper.INSTANCE.toUpperCase()).append(";")
				.append(DOUBLE_NEW_LINE);
		sb.append(IndentHelper.INDENT).append(TestHelper.CLASS_NAME)
				.append("() {").append(DOUBLE_NEW_LINE);
		sb.append(IndentHelper.INDENT).append("}");
		sb.append(DOUBLE_NEW_LINE).append("}");
		return sb.toString();
	}

	private String createConstructor(final boolean isPrivate) {
		StringBuilder sb = new StringBuilder();
		if (isPrivate) {
			sb.append(IndentHelper.INDENT).append("private ");
		} else {
			sb.append(IndentHelper.INDENT).append("protected ");
		}
		sb.append(CLASS_NAME).append("() {").append(DOUBLE_NEW_LINE)
				.append(IndentHelper.INDENT).append("}")
				.append(DOUBLE_NEW_LINE);
		return sb.toString();
	}
}
