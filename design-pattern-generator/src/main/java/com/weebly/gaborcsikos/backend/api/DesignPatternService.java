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

	List<String> loadCreationalPatterns();

	List<String> loadPatternTypes();

	List<String> loadBehavioralPatterns();

	List<String> loadStructuralPatterns();
	
}
