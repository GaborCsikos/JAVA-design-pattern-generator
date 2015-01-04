/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.service.DesignPatternService;
import com.weebly.gaborcsikos.backend.service.DesignPatternServiceImpl;

/**
 * @author Gabor Csikos
 *
 */
public class DesignPatternMapper {

	private final DesignPatternService service;

	/**
	 * Default Constructor
	 */
	public DesignPatternMapper() {
		service = new DesignPatternServiceImpl();
	}

	public DesignPatternMapper(DesignPatternService service) {
		service = new DesignPatternServiceImpl();
		this.service = service;
	}

	public List<String> mapToStrings(final DesignPatterns patterns) {
		final List<String> stringPatterns = new ArrayList<String>();
		for (final DesignPattern pattern : patterns.getPatterns()) {
			stringPatterns.add(pattern.getName());
		}
		return stringPatterns;
	}
	
	public DesignPattern getDesignPatternFromName(final String name) {
		return service.getDesignPatternByName(name);
	}
}
