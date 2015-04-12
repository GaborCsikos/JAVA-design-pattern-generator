/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.ADAPTER;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.BUILDER;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.CHAIN_OF_RESPONSIBILITY;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.COMPOSITE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.FACADE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.FACTORY;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.ITERATOR;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.MEMENTO;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.OBSERVER;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.PROTOTYPE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.PROXY;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.SINGLETON;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.VISITOR;
import static com.weebly.gaborcsikos.backend.api.PatternTypeEnum.BEHAVIORAL;
import static com.weebly.gaborcsikos.backend.api.PatternTypeEnum.CREATIONAL;
import static com.weebly.gaborcsikos.backend.api.PatternTypeEnum.STRUCTURAL;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory to generate patterns for specific types
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
		patternList.add(FACTORY.getName());
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
		patternList.add(CHAIN_OF_RESPONSIBILITY.getName());
		patternList.add(VISITOR.getName());
		patternList.add(MEMENTO.getName());
		return patternList;
	}

	public List<String> generateStructuralPatterns() {
		final List<String> patternList = new ArrayList<String>();
		patternList.add(FACADE.getName());
		patternList.add(ADAPTER.getName());
		patternList.add(COMPOSITE.getName());
		patternList.add(PROXY.getName());
		return patternList;
	}

}
