/**
 * 
 */
package com.weebly.gaborcsikos.backend.api;

import java.io.File;
import java.io.IOException;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.designpattern.DesignPattern;

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

	String generatePattern(DesignPattern pattern)
			throws CanNotCreateClassException, FieldVariableIsEmptyException;


	void generatePatternToFile(File file, DesignPattern pattern)
			throws CanNotCreateClassException, FieldVariableIsEmptyException,
			IOException;

}
