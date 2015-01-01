/**
 * 
 */
package com.weebly.gaborcsikos.backend.factory;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.designpattern.DesignPattern;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatterns;

/**
 * Factory to generate Dummy data
 * 
 * @author Gabor Csikos
 * 
 */
public class SimplePatternFactory {

	// TODO re-factor method violates SRP
	public DesignPatterns generetPatterns() {
		final DesignPatterns patterns = new DesignPatterns();
		final List<DesignPattern> patternList = new ArrayList<DesignPattern>();
		final DesignPattern singleton = new DesignPattern();
		singleton.setName("Singleton");
		patternList.add(singleton);
		patterns.setPatterns(patternList);
		return patterns;
	}

}
