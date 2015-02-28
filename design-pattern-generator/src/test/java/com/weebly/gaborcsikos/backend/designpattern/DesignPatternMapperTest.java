/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.FACTORY;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.SINGLETON;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link DesignPatternMapper }
 * 
 * @author Gabor Csikos
 * 
 */
public class DesignPatternMapperTest {

	private static final String TEST_PATTERN_NAME = SINGLETON.getName();
	private static final String TEST_PATTERN_NAME_2 = FACTORY.getName();
	private DesignPatternMapper mapper;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		mapper = new DesignPatternMapper();
	}

	@Test
	public void testMapToStrings() {
		// given
		DesignPatterns patterns = mock(DesignPatterns.class);
		List<DesignPattern> patternsMocked = new ArrayList<DesignPattern>();
		DesignPattern firstMockedPattern = mock(DesignPattern.class);
		when(firstMockedPattern.getName()).thenReturn(TEST_PATTERN_NAME);
		patternsMocked.add(firstMockedPattern);
		DesignPattern secondMockedPattern = mock(DesignPattern.class);
		when(secondMockedPattern.getName()).thenReturn(TEST_PATTERN_NAME_2);
		patternsMocked.add(secondMockedPattern);
		when(patterns.getPatterns()).thenReturn(patternsMocked);

		// when
		List<String> result = mapper.mapToStrings(patterns);

		// then
		assertNotNull(result);
		assertEquals("Size of result is not good", result.size(), 2);
		assertEquals("method gives back bad pattern ", result.get(0),
				TEST_PATTERN_NAME);
		assertEquals("method gives back bad pattern ", result.get(1),
				TEST_PATTERN_NAME_2);
	}
}
