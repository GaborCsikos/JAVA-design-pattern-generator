/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

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
	public DesignPatterns loadAllDesignPattern() {
		return patternFactory.generetPatterns();
	}

}
