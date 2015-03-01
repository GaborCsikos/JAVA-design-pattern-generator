/**
 * 
 */
package com.weebly.gaborcsikos.backend.testutil;

import static com.weebly.gaborcsikos.backend.api.ClassType.CLASS;

/**
 * Helper class for tests
 * 
 * @author Gabor Csikos
 * 
 */
public final class TestHelper {

	public static final String CLASS_NAME = "ClassName";
	public static final String PACKAGE_NAME = "com.weebly.gaborcsikos";
	public static final String INSTANCE = "instance";
	public static final String INTANCE_FIRTS_UPPER = "Instance";

	private TestHelper() {

	}
	public static String getEndStructure() {
		return "\n}";
	}

	public static String getBasicStucture() {
		StringBuilder sb = new StringBuilder("package ");
		sb.append(PACKAGE_NAME + ";\n\n").append(
				"public " + CLASS.getName() + " " + CLASS_NAME
						+ " {\n\n");
		return sb.toString();
	}
	public static void printInfo(final String info) {
		System.out.println(info);
	}

	public static void printInfo(final StringBuilder info) {
		System.out.println(info.toString());
	}
}
