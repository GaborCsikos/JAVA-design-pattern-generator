/**
 * 
 */
package com.weebly.gaborcsikos.backend.structural.composite;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

/**
 * model for Composite
 * 
 * @author Gabor Csikos
 * 
 */
public class CompositeModel extends DesignPatternModel {
	private String interfaceName;
	private String interfaceMethodName;
	private String overrridenMethod;
	private String listName;
	private CompositeTemplate template;
	/**
	 * Default constructor
	 */
	public CompositeModel() {

	}

	public CompositeModel(final String packageName, final String className,
			final String interfaceName, final String interfaceMethodName,
			final String overrridenMethod, final String listName) {
		super(packageName, className);
		this.interfaceName = interfaceName;
		this.interfaceMethodName = interfaceMethodName;
		this.overrridenMethod = overrridenMethod;
		this.listName = listName;
	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel#getGeneratedPattern()
	 */
	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		template = new CompositeTemplate(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				interfaceName, interfaceMethodName, overrridenMethod, listName);
		result.append(template.buildClass());
		return result.toString();
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(final String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getInterfaceMethodName() {
		return interfaceMethodName;
	}

	public void setInterfaceMethodName(final String interfaceMethodName) {
		this.interfaceMethodName = interfaceMethodName;
	}

	public String getOverrridenMethod() {
		return overrridenMethod;
	}

	public void setOverrridenMethod(final String overrridenMethod) {
		this.overrridenMethod = overrridenMethod;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(final String listName) {
		this.listName = listName;
	}

}
