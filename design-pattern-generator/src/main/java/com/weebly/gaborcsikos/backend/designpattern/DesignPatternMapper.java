/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.service.DesignPatternService;

/**
 * @author Gabor Csikos
 *
 */
public class DesignPatternMapper {

	/**
	 * Default Constructor
	 */
	public DesignPatternMapper() {
	}

	public DesignPatternMapper(final DesignPatternService service) {
	}

	public List<String> mapToStrings(final DesignPatterns patterns) {
		final List<String> stringPatterns = new ArrayList<String>();
		for (final DesignPattern pattern : patterns.getPatterns()) {
			stringPatterns.add(pattern.getName());
		}
		return stringPatterns;
	}
	
}
