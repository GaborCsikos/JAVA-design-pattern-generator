/**
 * 
 */
package com.weebly.gaborcsikos.backend.service;

import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;

/**
 * @author Gabor Csikos
 *
 */
public class PatternGeneratorServiceImpl implements PatternGeneratorService {

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.api.PatternGeneratorService#generateClass(com.weebly.gaborcsikos.backend.designpattern.BasicTemplate)
	 */
	public String generateClass(final BasicTemplate template)
			throws CanNotCreateClassException {
		if (template != null) {
			return template.getFullClass();
		} else {
			throw new CanNotCreateClassException();
		}
	}

}
