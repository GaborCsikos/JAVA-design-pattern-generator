/**
 * 
 */
package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.ITERATOR_CLASS;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.utility.GeneralUtility.OVERRIDE;
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
import com.weebly.gaborcsikos.backend.iterator.IteratorModel;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * Unit test of iterator pattern
 * 
 * @author Gabor Csikos
 * 
 */
public class IteratorServiceTest {

	private PatternGeneratorService service;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new PatternGeneratorServiceImpl();
	}

	@Test
	public void testIteratorWithUnsupportedRemove()
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		IteratorModel model = new IteratorModel(PACKAGE_NAME, CLASS_NAME,
				ITERATOR_CLASS, false);
		String expected = makeIterator(false);
		String result = service.generatePattern(model);
		TestHelperUtility.printInfo(result);
		assertEquals("Iterator pattern with unsupported remove is different",
				expected, result);
	}

	private String makeIterator(final boolean removeUnsupported) {
		StringBuilder sb = new StringBuilder();
		String implementsPart = " implements Iterator" + "<" + ITERATOR_CLASS
				+ ">";
		TestHelperUtility.IMPELENTSPART = implementsPart;
		sb.append(TestHelperUtility.getBasicStucture());
		sb.append(getFields());
		sb.append(getConstructor());
		sb.append(getHasNext());
		sb.append(getNext());
		sb.append(getRemove(removeUnsupported));
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}

	@Test
	public void testIteratorWithSupportedRemove()
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		IteratorModel model = new IteratorModel(PACKAGE_NAME, CLASS_NAME,
				ITERATOR_CLASS, true);
		String expected = makeIterator(true);
		String result = service.generatePattern(model);
		TestHelperUtility.printInfo(result);
		assertEquals("Iterator pattern with supported remove is different",
				expected, result);
	}

	private String getRemove(final boolean removeSupported) {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public void remove() {").append(NEW_LINE);
		if (removeSupported) {
			sb.append(DOUBLE_INDENT).append("//TODO implement remove")
					.append(NEW_LINE);
		} else {
			sb.append(DOUBLE_INDENT)
					.append("throw new UnsupportedOperationException();")
					.append(NEW_LINE);
		}
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getNext() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public ").append(ITERATOR_CLASS)
				.append(" next() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return null;").append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getHasNext() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public boolean hasNext() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return index < size;")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getConstructor() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(CLASS_NAME)
				.append("() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("this.index = 0;").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("//TODO add size").append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getFields() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("private int size;").append(NEW_LINE);
		sb.append(INDENT).append("private int index;").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}
}
