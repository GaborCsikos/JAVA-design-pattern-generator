/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.singleton.SingletonModel;

/**
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
	public String generateSingleton(final SingletonModel singleton)
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		return singleton.getSingleton();
	}

	@Override
	public void generateSingletonToFile(final File file,
			final SingletonModel singleton)
			throws CanNotCreateClassException, FieldVariableIsEmptyException, IOException {
		String stringToWrite = singleton.getSingleton();
		FileUtils.writeStringToFile(file, stringToWrite);
	}

}
