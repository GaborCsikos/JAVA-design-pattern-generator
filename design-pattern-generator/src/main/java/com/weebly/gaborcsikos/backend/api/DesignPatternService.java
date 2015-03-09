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
	 * Load all design patterns
	 * 
	 * @return Design patterns for View
	 */
	List<String> loadAllDesignPattern();
	
}
