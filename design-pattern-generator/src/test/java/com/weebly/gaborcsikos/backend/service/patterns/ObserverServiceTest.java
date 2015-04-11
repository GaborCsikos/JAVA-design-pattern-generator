package com.weebly.gaborcsikos.backend.service.patterns;

import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.CLASS_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.OBSERVER;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.PACKAGE_NAME;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.getBasicStucture;
import static com.weebly.gaborcsikos.backend.testutil.TestHelperUtility.getEndStructure;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.TRIPLE_INDENT;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.behavioral.observer.ObserverModel;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.backend.testutil.TestHelperUtility;

/**
 * 
 * @author Gabor Csikos
 * 
 */
public class ObserverServiceTest {
	private PatternGeneratorService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new PatternGeneratorServiceImpl();
	}

	@Test
	public void testObserver() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		ObserverModel model = new ObserverModel(PACKAGE_NAME, CLASS_NAME,
				OBSERVER, true);
		String expectedSubject = creatSubject(model.isArrayList());
		String expectedObserver = createObserver();
		String resultSubject = service.generatePattern(model);
		String resultObserver = service.generatePattern(model);
		TestHelperUtility.printInfo(resultObserver);
		TestHelperUtility.printInfo(resultSubject);
		assertEquals("Observer is different", expectedObserver, resultObserver);
		assertEquals("Subject is  different", expectedSubject,
				resultSubject);
	}

	private String creatSubject(final boolean arrayList) {
		StringBuilder sb = new StringBuilder();
		sb.append(getBasicStucture());
		sb.append(getListField(arrayList));
		sb.append(getAttach());
		sb.append(getDetach());
		sb.append(getChange());
		sb.append(getEndStructure());
		return sb.toString();
	}

	private String getListField(final boolean arrayList) {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("List<").append(OBSERVER)
				.append("> observers = new ");
		if (arrayList) {
			sb.append("ArrayList<");
		} else {
			sb.append("LinkedList<");
		}
		sb.append(OBSERVER).append(">();").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getDetach() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void remove").append(OBSERVER)
				.append("(final ").append(OBSERVER).append(" observer) {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("this.observers.remove(observer);")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getAttach() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void add").append(OBSERVER)
				.append("(final ").append(OBSERVER).append(" observer) {")
				.append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("this.observers.add(observer);")
				.append(NEW_LINE);
		sb.append(INDENT).append("}").append(DOUBLE_NEW_LINE);
		return sb.toString();
	}

	private String getChange() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public void change(){ ").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("for (").append(OBSERVER)
				.append(" observer : observers) {").append(NEW_LINE);
		sb.append(TRIPLE_INDENT).append("observer.update();").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("}").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	private String createObserver() {
		StringBuilder sb = new StringBuilder();
		sb.append(TestHelperUtility.getBasicStucture(ClassType.INTERFACE,
				OBSERVER));
		sb.append(INDENT).append("void update();").append(NEW_LINE);
		sb.append(TestHelperUtility.getEndStructure());
		return sb.toString();
	}

}
