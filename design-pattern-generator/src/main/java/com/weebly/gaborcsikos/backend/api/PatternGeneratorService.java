/**
 * 
 */
package com.weebly.gaborcsikos.backend.api;

import java.io.File;
import java.io.IOException;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

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
	 * @param pattern
	 *            to generate
	 * @return generated pattern as String
	 * @throws CanNotCreateClassException
	 *             if class name or package name is Empty or null
	 * @throws FieldVariableIsEmptyException
	 */
	String generatePattern(DesignPatternModel pattern)
			throws CanNotCreateClassException, FieldVariableIsEmptyException;

	/**
	 * 
	 * @param file
	 *            to create
	 * @param pattern
	 *            to generate
	 * @throws CanNotCreateClassException
	 * @throws FieldVariableIsEmptyException
	 *             if class name or package name is Empty or null
	 * @throws IOException
	 */
	void generatePatternToFile(File file, DesignPatternModel pattern)
			throws CanNotCreateClassException, FieldVariableIsEmptyException,
			IOException;

}
