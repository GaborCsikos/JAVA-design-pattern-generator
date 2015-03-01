/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.singleton.Singleton;

/**
 * @author Gabor Csikos
 *
 */
public class PatternGeneratorServiceImpl implements PatternGeneratorService {

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.api.PatternGeneratorService#generateClass(com.weebly.gaborcsikos.backend.designpattern.BasicTemplate)
	 */
	public String generateClass(final BasicTemplate template)
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		if (template != null) {
			return template.buildClass();
		} else {
			throw new CanNotCreateClassException();
		}
	}

	public String generateSingleton(final Singleton singleton)
			throws CanNotCreateClassException, FieldVariableIsEmptyException {
		return singleton.getSingleton();
	}

}
