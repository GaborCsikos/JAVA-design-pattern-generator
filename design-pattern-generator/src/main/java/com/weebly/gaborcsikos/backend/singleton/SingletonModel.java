/**
 * 
 */
package com.weebly.gaborcsikos.backend.singleton;

import com.weebly.gaborcsikos.backend.api.PatternEnum;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

/**
 * Singleton DesignPattern
 * 
 * @author Gabor Csikos
 * 
 */
public class SingletonModel extends DesignPatternModel {

	private boolean eagerLoaded;
	private boolean lazyLoaded;
	private boolean constructorPrivate;
	private boolean enumType;
	private String instanceName;
	private SingletonTemplate template;

	/**
	 * Default class
	 */
	public SingletonModel() {

	}

	public SingletonModel(final String packaName, final String className) {
		super(packaName, className);
	}

	public void initSingleton(final boolean staticallyLoaded,
			final boolean dynamicallyLoaded,
			final boolean constructorProtected) {
		super.setName(PatternEnum.SINGLETON.getName());
		this.eagerLoaded = staticallyLoaded;
		this.lazyLoaded = dynamicallyLoaded;
		this.constructorPrivate = constructorProtected;
	}

	public boolean isEagerLoaded() {
		return eagerLoaded;
	}

	public void setEagerLoaded(final boolean eagerLoaded) {
		this.eagerLoaded = eagerLoaded;
	}

	public boolean isLazyLoaded() {
		return lazyLoaded;
	}

	public void setLazyLoaded(final boolean lazyLoaded) {
		this.lazyLoaded = lazyLoaded;
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

	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		if (enumType) {
			createEnumSingleton();
		} else if (eagerLoaded) {
			createStaticallyLoaded();
		} else if (lazyLoaded) {
			createDynamicallyLoaded();
		}
		result.append(template.buildClass());
		return result.toString();
	}

}

