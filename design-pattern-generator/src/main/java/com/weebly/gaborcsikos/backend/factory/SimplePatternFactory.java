/**
 * 
 */
package com.weebly.gaborcsikos.backend.factory;

import static com.weebly.gaborcsikos.backend.designpattern.PatternEnum.SINGLETON;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.designpattern.DesignPattern;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatterns;
import com.weebly.gaborcsikos.backend.singleton.Singleton;

/**
 * Factory to generate Dummy data
 * 
 * @author Gabor Csikos
 * 
 */
public class SimplePatternFactory {

	public DesignPatterns generetPatterns() {
		final DesignPatterns patterns = new DesignPatterns();
		final List<DesignPattern> patternList = new ArrayList<DesignPattern>();
		final DesignPattern singleton = new Singleton();
		singleton.setName(SINGLETON.getName());
		patternList.add(singleton);
		patterns.setPatterns(patternList);
		return patterns;
	}

}
