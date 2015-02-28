/**
 * 
 */
package com.weebly.gaborcsikos.backend.singleton;

import com.weebly.gaborcsikos.backend.api.PatternEnum;
import com.weebly.gaborcsikos.backend.designpattern.DesignPattern;

/**
 * Singleton DesignPattern
 * 
 * @author Gabor Csikos
 * 
 */
public class Singleton extends DesignPattern {

	private boolean staticallyLoaded;
	private boolean dynamicallyLoaded;
	private boolean constructorProtected;

	public void initSingleton(final String className,
			final boolean staticallyLoaded, final boolean dynamicallyLoaded,
			final boolean constructorProtected) {
		super.setName(PatternEnum.SINGLETON.getName());
		this.staticallyLoaded = staticallyLoaded;
		this.dynamicallyLoaded = dynamicallyLoaded;
		this.constructorProtected = constructorProtected;
	}

	public String getSingleton() {
		StringBuilder result = new StringBuilder();
		return result.toString();
	}

	public boolean isStaticallyLoaded() {
		return staticallyLoaded;
	}

	public void setStaticallyLoaded(final boolean staticallyLoaded) {
		this.staticallyLoaded = staticallyLoaded;
	}

	public boolean isDynamicallyLoaded() {
		return dynamicallyLoaded;
	}

	public void setDynamicallyLoaded(final boolean dynamicallyLoaded) {
		this.dynamicallyLoaded = dynamicallyLoaded;
	}

	public boolean isConstructorProtected() {
		return constructorProtected;
	}

	public void setConstructorProtected(final boolean constructorProtected) {
		this.constructorProtected = constructorProtected;
	}
}
