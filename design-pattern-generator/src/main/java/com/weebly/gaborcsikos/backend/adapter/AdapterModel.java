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
	private String methodType;
	private String methodName;
	private String targetMethodName;
	
	public AdapterModel(final String packaName, final String className) {
		super(packaName, className);
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
				target);
		result.append(template.buildClass());
		return result.toString();
	}

	public FieldWithType getTarget() {
		return target;
	}

	public void setTarget(final FieldWithType target) {
		this.target = target;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(final String methodType) {
		this.methodType = methodType;
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

}
