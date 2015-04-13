/**
 * 
 */
package com.weebly.gaborcsikos.backend.structural.proxy;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

/**
 * model for Proxy
 * 
 * @author Gabor Csikos
 * 
 */
public class ProxyModel extends DesignPatternModel {

	private String extendendClass;
	private String extendendInstance;
	private String overridenMethod;
	private ProxyTemplate template;

	/**
	 * Default constructor
	 */
	public ProxyModel() {

	}
	public ProxyModel(final String packageName, final String className,
			final String extendendClass, final String extendendInstance,
			final String overridenMethod) {
		super(packageName, className);
		this.extendendInstance = extendendInstance;
		this.extendendClass = extendendClass;
		this.overridenMethod = overridenMethod;
	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel#getGeneratedPattern()
	 */
	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		template = new ProxyTemplate(super.getBasicTemplate().getPackageName(),
				super.getBasicTemplate().getClassName(), extendendClass,
				extendendInstance, overridenMethod);
		result.append(template.buildClass());
		return result.toString();
	}
	public String getExtendendClass() {
		return extendendClass;
	}
	public void setExtendendClass(final String extendendClass) {
		this.extendendClass = extendendClass;
	}

	public String getExtendendInstance() {
		return extendendInstance;
	}

	public void setExtendendInstance(final String extendendInstance) {
		this.extendendInstance = extendendInstance;
	}
	public String getOverridenMethod() {
		return overridenMethod;
	}
	public void setOverridenMethod(final String overridenMethod) {
		this.overridenMethod = overridenMethod;
	}

}
