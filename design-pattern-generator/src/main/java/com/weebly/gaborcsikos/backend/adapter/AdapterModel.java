/**
 * 
 */
package com.weebly.gaborcsikos.backend.adapter;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;

/**
 * Model for Adapter Design pattern
 * 
 * @author Gabor Csikos
 * 
 */
public class AdapterModel extends DesignPatternModel {

	private AdapterTemplate template;

	private FieldWithType target;
	private String extendedClass;
	private String methodName;
	private String targetMethodName;
	
	public AdapterModel(final String packaName, final String className) {
		super(packaName, className);
	}

	public AdapterModel(final String packaName, final String className,
			final String extendedClass, final String methodName,
			final String targetMethodName) {
		super(packaName, className);
		this.extendedClass = extendedClass;
		this.methodName = methodName;
		this.targetMethodName = targetMethodName;
	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel#getGeneratedPattern()
	 */
	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		template = new AdapterTemplate(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				target, extendedClass, methodName, targetMethodName);
		result.append(template.buildClass());
		return result.toString();
	}

	public FieldWithType getTarget() {
		return target;
	}

	public void setTarget(final FieldWithType target) {
		this.target = target;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(final String methodName) {
		this.methodName = methodName;
	}

	public String getTargetMethodName() {
		return targetMethodName;
	}

	public void setTargetMethodName(final String targetMethodName) {
		this.targetMethodName = targetMethodName;
	}

	public String getExtendedClass() {
		return extendedClass;
	}

	public void setExtendedClass(final String extendedClass) {
		this.extendedClass = extendedClass;
	}

}
