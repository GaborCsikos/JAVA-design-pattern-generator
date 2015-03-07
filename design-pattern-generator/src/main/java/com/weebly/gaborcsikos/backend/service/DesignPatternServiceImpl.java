/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import com.weebly.gaborcsikos.backend.api.DesignPatternService;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatterns;
import com.weebly.gaborcsikos.backend.factory.SimplePatternFactory;

/**
 * Service Implementation for design patterns.
 * 
 * @author Gabor Csikos
 * 
 */
public class DesignPatternServiceImpl implements DesignPatternService {

	private final SimplePatternFactory patternFactory;

	/**
	 * Default Constructor
	 */
	public DesignPatternServiceImpl() {
		patternFactory = new SimplePatternFactory();
	}

	public DesignPatternServiceImpl(final SimplePatternFactory patternFactory) {
		this.patternFactory = patternFactory;
	}

	@Override
	public DesignPatterns loadAllDesignPattern() {
		return patternFactory.generetPatterns();
	}

}
