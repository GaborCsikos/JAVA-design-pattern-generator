/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.weebly.gaborcsikos.backend.service.DesignPatternService;

/**
 * Unit tests for {@link DesignPatternMapper }
 * 
 * @author Gabor Csikos
 * 
 */
public class DesignPatternMapperTest {

	private static final String TEST_PATTERN_NAME = "Singleton";
	private static final String TEST_PATTERN_NAME_2 = "Factory";
	private DesignPatternMapper mapper;

	@Mock
	private DesignPatternService service;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		mapper = new DesignPatternMapper(service);
	}

	@Test
	public void testGetPatternByName() {
		//given
		DesignPattern pattern = mock(DesignPattern.class);
		when(pattern.getName()).thenReturn(TEST_PATTERN_NAME);
		when(service.getDesignPatternByName(TEST_PATTERN_NAME)).thenReturn(
				pattern);

		//when
		DesignPattern result = mapper
				.getDesignPatternFromName(TEST_PATTERN_NAME);

		//then
		assertEquals("method gives back bad pattern ", result.getName(),
				TEST_PATTERN_NAME);
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
