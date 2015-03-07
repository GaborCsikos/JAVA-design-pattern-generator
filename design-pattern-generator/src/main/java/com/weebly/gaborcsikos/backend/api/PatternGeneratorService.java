/**
 * 
 */
package com.weebly.gaborcsikos.backend.api;

import java.io.File;
import java.io.IOException;

import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.singleton.SingletonModel;

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
	String generateSingleton(SingletonModel singleton)
			throws CanNotCreateClassException, FieldVariableIsEmptyException;

	/**
	 * @param File
	 *            the file
	 * @param singleton
	 *            the Singleton to generate
	 * @return generated Singleton
	 * @throws CanNotCreateClassException
	 * @throws FieldVariableIsEmptyException
	 * @throws IOException
	 */
	void generateSingletonToFile(File file, SingletonModel singleton)
			throws CanNotCreateClassException, FieldVariableIsEmptyException,
			IOException;
}
