/**
 * 
 */
package com.weebly.gaborcsikos.backend.behavioral.visitor;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

/**
 * @author Gabor Csikos
 *
 */
public class VisitorModel extends DesignPatternModel {
	private String classTypeToVisit;
	private String classNameToVisit;
	private VisitorTemplate template;
	public VisitorModel(final String packageName, final String className,
			final String classTypeToVisit, final String classNameToVisit) {
		super(packageName, className);
		this.setClassTypeToVisit(classTypeToVisit);
		this.setClassNameToVisit(classNameToVisit);
	}

	/**
	 * Default constructor
	 */
	public VisitorModel() {

	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel#getGeneratedPattern()
	 */
	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		template = new VisitorTemplate(super.getBasicTemplate().getPackageName(),
				super.getBasicTemplate().getClassName(), classTypeToVisit,classNameToVisit);
		result.append(template.buildClass());
		return result.toString();
	}

	public String getClassTypeToVisit() {
		return classTypeToVisit;
	}

	public void setClassTypeToVisit(final String classTypeToVisit) {
		this.classTypeToVisit = classTypeToVisit;
	}

	public String getClassNameToVisit() {
		return classNameToVisit;
	}

	public void setClassNameToVisit(final String classNameToVisit) {
		this.classNameToVisit = classNameToVisit;
	}

}
