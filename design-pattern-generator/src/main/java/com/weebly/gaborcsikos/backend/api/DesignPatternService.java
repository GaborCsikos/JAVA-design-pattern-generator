/**
 * 
 */
package com.weebly.gaborcsikos.backend.api;

import java.util.List;

/**
 * Class is responsible for loading Design Patterns
 * 
 * @author Gabor Csikos
 * 
 */
public interface DesignPatternService {
	/**
	 * 
	 * @return loaded creational patterns
	 */
	List<String> loadCreationalPatterns();

	/**
	 * 
	 * @return loaded pattern types
	 */
	List<String> loadPatternTypes();

	/**
	 * 
	 * @return loaded behavioral patterns
	 */
	List<String> loadBehavioralPatterns();

	/**
	 * 
	 * @return loaded structural patterns
	 */
	List<String> loadStructuralPatterns();
	
}
