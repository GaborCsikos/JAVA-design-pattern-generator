/**
 * 
 */
package com.weebly.gaborcsikos.backend.singleton;

import com.weebly.gaborcsikos.backend.api.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.FieldVariableIsEmptyException;
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
	private boolean constructorPrivate;
	private boolean enumType;
	private String instanceName;
	private SingletonTemplate template;

	/**
	 * Default class
	 */
	public Singleton() {

	}

	public Singleton(final String packaName, final String className) {
		super(packaName, className);
	}

	public void initSingleton(final boolean staticallyLoaded,
			final boolean dynamicallyLoaded,
			final boolean constructorProtected) {
		super.setName(PatternEnum.SINGLETON.getName());
		this.staticallyLoaded = staticallyLoaded;
		this.dynamicallyLoaded = dynamicallyLoaded;
		this.constructorPrivate = constructorProtected;
	}

	public String getSingleton() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		if (enumType) {
			createEnumSingleton();
		} else if (staticallyLoaded) {
			createStaticallyLoaded();
		} else if (dynamicallyLoaded) {
			createDynamicallyLoaded();
		}
		result.append(template.buildClass());
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

	public boolean isConstructorPrivate() {
		return constructorPrivate;
	}

	public void setConstructorPrivate(final boolean constructorPrivate) {
		this.constructorPrivate = constructorPrivate;
	}

	public boolean isEnumType() {
		return enumType;
	}

	public void setEnumType(final boolean enumType) {
		this.enumType = enumType;
	}

	public SingletonTemplate getTemplate() {
		return template;
	}

	public void setTemplate(final SingletonTemplate template) {
		this.template = template;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(final String instanceName) {
		this.instanceName = instanceName;
	}

	private void createEnumSingleton() {
		template = new EnumSingleton(super.getBasicTemplate().getPackageName(),
				super.getBasicTemplate().getClassName(), instanceName);
	}

	private void createDynamicallyLoaded() {
		template = new SingletonDynamic(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				instanceName, constructorPrivate);
	}

	private void createStaticallyLoaded() {
		template = new SingletonStatic(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				instanceName, constructorPrivate);
	}

}

