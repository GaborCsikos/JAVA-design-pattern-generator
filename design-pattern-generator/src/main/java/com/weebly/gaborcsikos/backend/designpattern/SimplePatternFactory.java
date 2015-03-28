/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.ADAPTER;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.BUILDER;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.FACADE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.ITERATOR;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.OBSERVER;
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
		patternList.add(BUILDER.getName());
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
		patternList.add(ITERATOR.getName());
		patternList.add(OBSERVER.getName());
		return patternList;
	}

	public List<String> generateStructuralPatterns() {
		final List<String> patternList = new ArrayList<String>();
		patternList.add(FACADE.getName());
		patternList.add(ADAPTER.getName());
		return patternList;
	}

}
