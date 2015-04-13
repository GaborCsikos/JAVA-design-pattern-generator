/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

/**
 * Implementation of {@link PatternGeneratorService}
 * 
 * @author Gabor Csikos
 * 
 */
public class PatternGeneratorServiceImpl implements PatternGeneratorService {

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.api.PatternGeneratorService#generateClass(com.weebly.gaborcsikos.backend.designpattern.BasicTemplate)
	 */
	@Override
	public String generateClass(final BasicTemplate template)
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		if (template != null) {
				return template.buildClass();
		} else {
			throw new CanNotCreateClassException();
		}
	}

	@Override
	public String generatePattern(final DesignPatternModel pattern)
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		return pattern.getGeneratedPattern();
	}

	@Override
	public void generatePatternToFile(final File file,
			final DesignPatternModel pattern)
			throws CanNotCreateClassException, FieldVariableIsEmptyException, IOException {
		String stringToWrite = pattern.getGeneratedPattern();
		FileUtils.writeStringToFile(file, stringToWrite);
	}


}
