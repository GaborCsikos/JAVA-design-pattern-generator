/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.weebly.gaborcsikos.backend.designpattern.DesignPattern;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatterns;
import com.weebly.gaborcsikos.backend.factory.SimplePatternFactory;

/**
 * Unit tests for {@link DesignPatternServiceImpl}
 * 
 * @author Gabor Csikos
 * 
 */
public class DesignPatternServiceImplTest {
	private DesignPatternService service;

	@Mock
	private SimplePatternFactory factory;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		service = new DesignPatternServiceImpl(factory);
	}

	@Test
	public void test() {
		// given
		DesignPattern firstPattern = mock(DesignPattern.class);
		DesignPattern secondPattern = mock(DesignPattern.class);
		DesignPatterns patternsMocked = mock(DesignPatterns.class);
		String firstPatternName = "Singleton";
		String secondPatternName = "Factory";
		when(firstPattern.getName()).thenReturn(firstPatternName);
		when(secondPattern.getName()).thenReturn(secondPatternName);

		when(factory.generetPatterns()).thenReturn(patternsMocked);
		List<DesignPattern> listOfPatterns = new ArrayList<DesignPattern>();

		listOfPatterns.add(firstPattern);
		listOfPatterns.add(secondPattern);
		when(patternsMocked.getPatterns()).thenReturn(listOfPatterns);

		// when
		DesignPatterns patterns = service.loadAllDesignPattern();


		// then
		assertEquals(2, patterns.getPatterns().size());
		assertEquals(firstPatternName, patterns.getPatterns().get(0)
				.getName());
		assertEquals(secondPatternName, patterns.getPatterns().get(1)
				.getName());
	}

}
