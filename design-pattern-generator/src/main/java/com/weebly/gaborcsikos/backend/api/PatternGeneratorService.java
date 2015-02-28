/**
 * 
 */
package com.weebly.gaborcsikos.backend.api;

import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;

/**
 * Class for generating patterns
 * 
 * @author Gabor Csikos
 * 
 */
public interface PatternGeneratorService {

	/**
	 * 
	 * @param template
	 *            to generate
	 * @return class that can be generated
	 * @throws CanNotCreateClassException
	 *             if class name or package name is Empty or null
	 */
	public String generateClass(BasicTemplate template)
			throws CanNotCreateClassException;
}
