/**
 * 
 */
package com.weebly.gaborcsikos.backend.testutil;

/**
 * Helper class for tests
 * 
 * @author Gabor Csikos
 * 
 */
public final class TestHelper {

	public static final String CLASS_NAME = "ClassName";
	public static final String PACKAGE_NAME = "com.weebly.gaborcsikos";

	private TestHelper() {

	}

	public static void printInfo(final String info) {
		System.out.println(info);
	}

	public static void printInfo(final StringBuilder info) {
		System.out.println(info.toString());
	}
}
