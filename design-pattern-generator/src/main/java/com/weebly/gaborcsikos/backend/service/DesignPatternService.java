/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import com.weebly.gaborcsikos.backend.designpattern.DesignPatterns;

/**
 * Class is responsible for loading Design Patterns
 * 
 * @author Gabor Csikos
 * 
 */
public interface DesignPatternService {

	/**
	 * Load all design patterns
	 * 
	 * @return loaded {@link DesignPatterns}
	 */
	DesignPatterns loadAllDesignPattern();
	
}
