/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import java.util.List;

import com.weebly.gaborcsikos.backend.api.DesignPatternService;
import com.weebly.gaborcsikos.backend.designpattern.SimplePatternFactory;

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
	public List<String> loadCreationalPatterns() {
		return patternFactory.generateCreationalPatterns();
	}

	@Override
	public List<String> loadPatternTypes() {
		return patternFactory.generatePatternTypes();
	}

	@Override
	public List<String> loadBehavioralPatterns() {
		return patternFactory.generateBehavioralPatterns();
	}

	@Override
	public List<String> loadStructuralPatterns() {
		return patternFactory.generateStructuralPatterns();
	}

}
