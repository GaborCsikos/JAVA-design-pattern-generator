/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.builder;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.api.PatternEnum;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;

/**
 * model for Builder
 * 
 * @author Gabor Csikos
 * 
 */
public class BuilderModel extends DesignPatternModel {

	private boolean containsBuildMethod = false;
	private final List<FieldWithType> fields = new ArrayList<FieldWithType>();
	private BuilderTemplate template;

	/**
	 * Default constructor
	 */
	public BuilderModel() {

	}


	public BuilderModel(final String packaName, final String className) {
		super(packaName, className);
	}

	public void initBuilder(final boolean containsBuildMethod) {
		super.setName(PatternEnum.BUILDER.getName());
		this.containsBuildMethod = containsBuildMethod;
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel#getGeneratedPattern()
	 */
	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();

		if (fields.isEmpty()) {
			throw new FieldVariableIsEmptyException();
		}
		template = new BuilderTemplate(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				containsBuildMethod, fields);
		result.append(template.buildClass());
		return result.toString();
	}

	public void addAllFields(final List<FieldWithType> fieldsToAdd) {
		fields.clear();
		fields.addAll(fieldsToAdd);
	}

	public void deleteItem(final int index) {
		fields.remove(index);
	}

	public void addField(final FieldWithType field) {
		fields.add(field);
	}

	public boolean isContainsBuildMethod() {
		return containsBuildMethod;
	}

	public void setContainsBuildMethod(final boolean containsBuildMethod) {
		this.containsBuildMethod = containsBuildMethod;
	}
}
