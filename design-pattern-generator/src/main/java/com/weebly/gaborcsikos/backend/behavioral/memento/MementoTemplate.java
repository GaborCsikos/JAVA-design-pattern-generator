package com.weebly.gaborcsikos.backend.behavioral.memento;

import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;

/**
 * Basic Memento template
 * 
 * @author Gabor Csikos
 * 
 */
public abstract class MementoTemplate extends BasicTemplate {

	protected final String stateType;
	protected final String stateName;

	public MementoTemplate(final String packageName, final String className,
			final String stateType, final String stateName) {
		super(packageName, className);
		this.stateType = stateType;
		this.stateName = stateName;
	}
}
