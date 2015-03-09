/**
 * 
 */
package com.weebly.gaborcsikos.backend.patterncreator;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.PROTOTYPE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.SINGLETON;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory to generate Dummy data
 * 
 * @author Gabor Csikos
 * 
 */
public class SimplePatternFactory {
	public List<String> generetPatterns() {
		final List<String> patternList = new ArrayList<String>();
		patternList.add(SINGLETON.getName());
		patternList.add(PROTOTYPE.getName());
		return patternList;
	}

}
