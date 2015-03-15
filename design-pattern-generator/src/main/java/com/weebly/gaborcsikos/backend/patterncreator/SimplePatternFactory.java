/**
 * 
 */
package com.weebly.gaborcsikos.backend.patterncreator;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.FACADE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.PROTOTYPE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.SINGLETON;
import static com.weebly.gaborcsikos.backend.api.PatternTypeEnum.BEHAVIORAL;
import static com.weebly.gaborcsikos.backend.api.PatternTypeEnum.CREATIONAL;
import static com.weebly.gaborcsikos.backend.api.PatternTypeEnum.STRUCTURAL;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory to generate Dummy data
 * 
 * @author Gabor Csikos
 * 
 */
public class SimplePatternFactory {
	public List<String> generateCreationalPatterns() {
		final List<String> patternList = new ArrayList<String>();
		patternList.add(SINGLETON.getName());
		patternList.add(PROTOTYPE.getName());
		return patternList;
	}

	public List<String> generatePatternTypes() {
		final List<String> patternList = new ArrayList<String>();
		patternList.add(CREATIONAL.getName());
		patternList.add(BEHAVIORAL.getName());
		patternList.add(STRUCTURAL.getName());
		return patternList;
	}

	public List<String> generateBehavioralPatterns() {
		final List<String> patternList = new ArrayList<String>();
		return patternList;
	}

	public List<String> generateStructuralPatterns() {
		final List<String> patternList = new ArrayList<String>();
		patternList.add(FACADE.getName());
		return patternList;
	}

}
