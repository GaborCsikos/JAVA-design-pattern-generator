/**
 * 
 */
package com.weebly.gaborcsikos.backend.testutil;

import static com.weebly.gaborcsikos.backend.api.ClassType.CLASS;

import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.utility.ContructorMakerUtility;
import com.weebly.gaborcsikos.backend.utility.FieldMakerUtility;

/**
 * Helper class for tests
 * 
 * @author Gabor Csikos
 * 
 */
public final class TestHelperUtility {

	public static final String CLASS_NAME = "ClassName";
	public static final String FACTORY_NAME = "ClassNameFactory";
	public static final String EXTENDS_CLASS_NAME = "AnotherClassName";
	public static final String PACKAGE_NAME = "com.weebly.gaborcsikos";
	public static final String INSTANCE = "instance";
	public static final String CLONE_METHOD_NAME = "makeClone";
	public static final String METHOD_NAME = "method";
	public static final String METHOD_NAME_TWO = "targetMethod";
	public static final String INTANCE_FIRTS_UPPER = "Instance";

	public static final String STRING_TYPE = "String";
	public static final String VARIABLE = "stringVariable";
	public static final String MODIFIER = "private ";
	public static final String FINAL_PARAMETER = "final ";
	public static final String THIS = "this.";
	public static final String OBSERVER = "Observer";
	public static String IMPELENTSPART = "";
	public static final String ITERATOR_CLASS = "Character";
	private TestHelperUtility() {

	}
	public static String getEndStructure() {
		return "\n}";
	}

	public static String getFields() {
		return FieldMakerUtility.getFormattedFields(TestFields.testFields());
	}

	public static String getField() {
		return FieldMakerUtility.getFormattedField(TestFields.testFields()
				.get(0));
	}

	public static String getConstructorWithParameters() {
		return ContructorMakerUtility.getFormttedConsructorFromFields(
				CLASS_NAME, TestFields.testFields());
	}

	public static String getConstructorWithParameter() {
		return ContructorMakerUtility.getFormttedConsructorFromField(
				CLASS_NAME, TestFields.testFields().get(0));
	}
	public static String getConstructor(final String className) {
		return ContructorMakerUtility.getFormttedConsructorFromFields(
				className, TestFields.testFields());
	}

	public static String getBasicStucture() {
		StringBuilder sb = new StringBuilder("package ");
		sb.append(PACKAGE_NAME + ";\n\n").append(
"public " + CLASS.getName() + " " + CLASS_NAME)
				.append(IMPELENTSPART).append(" {\n\n");
		return sb.toString();
	}

	public static String getBasicStucture(final ClassType tpye) {
		StringBuilder sb = new StringBuilder("package ");
		sb.append(PACKAGE_NAME + ";\n\n")
				.append("public " + tpye.getName() + " " + CLASS_NAME)
				.append(IMPELENTSPART).append(" {\n\n");
		return sb.toString();
	}

	public static String getBasicStucture(final ClassType tpye,
			final String className) {
		StringBuilder sb = new StringBuilder("package ");
		sb.append(PACKAGE_NAME + ";\n\n")
				.append("public " + tpye.getName() + " " + className)
				.append(IMPELENTSPART).append(" {\n\n");
		return sb.toString();
	}

	public static String getBasicStucture(final String className) {
		StringBuilder sb = new StringBuilder("package ");
		sb.append(PACKAGE_NAME + ";\n\n").append(
"public " + CLASS.getName() + " " + className)
				.append(IMPELENTSPART).append(" {\n\n");
		return sb.toString();
	}
	
	public static void printInfo(final String info) {
		System.out.println(info);
	}

	public static void printInfo(final StringBuilder info) {
		System.out.println(info.toString());
	}

}
