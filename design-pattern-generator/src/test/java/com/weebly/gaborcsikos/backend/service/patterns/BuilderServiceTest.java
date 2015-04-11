/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestFields.testFields;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.getBasicStucture;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.getEndStructure;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.getFields;
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
import com.weebly.gaborcsikos.backend.creational.builder.BuilderModel;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * @author Gabor Csikos
 *
 */
public class BuilderServiceTest {
	private PatternGeneratorService service;

	@Before
	public void setUp() throws Exception {
		service = new PatternGeneratorServiceImpl();
	}

	@Test
	public void testMultipleFieldWithBuild() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		BuilderModel model = new BuilderModel(PACKAGE_NAME, CLASS_NAME);
		TestHelperUtility.IMPELENTSPART = "";
		model.initBuilder(true);
		model.addAllFields(testFields());
		String expected = createBuilder(true);
		String result = service.generatePattern(model);
		TestHelperUtility.printInfo(result);
		assertEquals("Builder is  different", expected, result);
	}

	private String createBuilder(final boolean containsBuildMethod) {
		StringBuilder sb = new StringBuilder();
		sb.append(getBasicStucture());
		sb.append(getFields());
		sb.append(NEW_LINE);
		sb.append(getBuilderMethods());
		if (containsBuildMethod) {
			sb.append(NEW_LINE);
			sb.append(getBuildOption());
		}
		sb.append(getEndStructure());
		return sb.toString();
	}

	private String getBuilderMethods() {
		StringBuilder sb = new StringBuilder();
		for (FieldWithType field : testFields()) {
			sb.append(INDENT).append("public ").append(CLASS_NAME)
					.append(" set")
					.append(getUppercaseMethodName(field.getName()))
					.append("(final ").append(field.getType()).append(" ")
					.append(field.getName()).append(") {").append(NEW_LINE);
			sb.append(DOUBLE_INDENT).append("this.").append(field.getName())
					.append(" = ").append(field.getName()).append(";")
					.append(NEW_LINE);
			sb.append(DOUBLE_INDENT).append("return this;").append(NEW_LINE);
			sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		}

		return sb.toString();
	}

	private String getUppercaseMethodName(final String name) {
		return Character.toString(name.charAt(0)).toUpperCase()
				+ name.substring(1);
	}

	private String getBuildOption() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(CLASS_NAME)
				.append(" build() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return new ")
.append(CLASS_NAME)
				.append("();").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}
}
