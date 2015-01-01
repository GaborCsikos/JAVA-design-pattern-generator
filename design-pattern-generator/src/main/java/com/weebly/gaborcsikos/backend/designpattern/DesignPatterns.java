/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Class is responsible for holding {@link DesignPattern}s
 * 
 * @author Gabor Csikos
 * 
 */
public class DesignPatterns {

	private List<DesignPattern> patterns;

	/**
	 * Default Constructor
	 */
	public DesignPatterns() {
		patterns = new ArrayList<DesignPattern>();
	}

	public List<DesignPattern> getPatterns() {
		return patterns;
	}

	public void setPatterns(final List<DesignPattern> patterns) {
		this.patterns = patterns;
	}
}
