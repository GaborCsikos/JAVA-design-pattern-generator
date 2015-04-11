/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.prototype;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.PROTOTYPE;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

/**
 * model for Prototype
 * 
 * @author Gabor Csikos
 * 
 */
public class PrototypeModel extends DesignPatternModel {

	private boolean implementsClonable = true;
	public static final String CLONE_OWERRIDE = "clone";
	public void setImplementsClonable(final boolean implementsClonable) {
		this.implementsClonable = implementsClonable;
	}

	private PrototypeTemplate template;
	private String cloneMethodName;

	/**
	 * Default constructor
	 */
	public PrototypeModel() {

	}

	public PrototypeModel(final String packaName, final String className) {
		super(packaName, className);
	}

	public void initPrototype(final boolean implementsClonable) {
		super.setName(PROTOTYPE.getName());
		this.implementsClonable = implementsClonable;
	}

	public boolean isImplementsClonable() {
		return implementsClonable;
	}

	private void createOwnClone() {
		template = new PrototypeOwnClone(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				cloneMethodName);
	}

	private void createImplementsClonable() {
		template = new PrototypeImplementsClonable(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName());
	}

	public String getCloneMethodName() {
		return cloneMethodName;
	}

	public void setCloneMethodName(final String cloneMethodName) {
		this.cloneMethodName = cloneMethodName;
	}

	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		if (implementsClonable) {
			createImplementsClonable();
		} else {
			createOwnClone();
		}
		result.append(template.buildClass());
		return result.toString();
	}
}
