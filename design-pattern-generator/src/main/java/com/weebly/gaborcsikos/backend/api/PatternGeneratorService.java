/**
 * 
 */
package com.weebly.gaborcsikos.backend.api;

import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.singleton.Singleton;

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
	 * @throws FieldVariableIsEmptyException
	 */
	String generateClass(BasicTemplate template)
			throws CanNotCreateClassException, FieldVariableIsEmptyException;

	/**
	 * 
	 * @param singleton
	 *            the Singleton to generate
	 * @return generated Singleton
	 * @throws CanNotCreateClassException
	 * @throws FieldVariableIsEmptyException
	 */
	String generateSingleton(Singleton singleton)
			throws CanNotCreateClassException, FieldVariableIsEmptyException;
}
