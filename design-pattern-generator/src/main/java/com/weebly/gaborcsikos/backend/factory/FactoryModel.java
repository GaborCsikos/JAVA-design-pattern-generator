/**
 * 
 */
package com.weebly.gaborcsikos.backend.factory;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;

/**
 * @author Gabor Csikos
 *
 */
public class FactoryModel extends DesignPatternModel {
	private String objectType;
	private String objectToReturn;
	private boolean simpleFactoryUsed;
	private List<FieldWithType> fields = new ArrayList<FieldWithType>();
	private FactoryTemplate template;

	/**
	 * Default constructor
	 */
	public FactoryModel() {

	}

	public FactoryModel(final String packageName, final String className,
			final String objectType, final String objectToReturn,
			final boolean simpleFactoryUsed, final List<FieldWithType> fields) {
		super(packageName, className);
		this.fields = fields;
		this.objectType = objectType;
		this.objectToReturn = objectToReturn;
		this.simpleFactoryUsed = simpleFactoryUsed;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(final String objectType) {
		this.objectType = objectType;
	}

	public String getObjectToReturn() {
		return objectToReturn;
	}

	public void setObjectToReturn(final String objectToReturn) {
		this.objectToReturn = objectToReturn;
	}

	public boolean isSimpleFactoryUsed() {
		return simpleFactoryUsed;
	}

	public void setSimpleFactoryUsed(final boolean simpleFactoryUsed) {
		this.simpleFactoryUsed = simpleFactoryUsed;
	}

	public List<FieldWithType> getFields() {
		return fields;
	}

	public void setFields(final List<FieldWithType> fields) {
		this.fields = fields;
	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel#getGeneratedPattern()
	 */
	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();

		if (simpleFactoryUsed) {
			createSimpleFactory();
		} else {
			if (fields.isEmpty()) {
				throw new FieldVariableIsEmptyException();
			}
			createFactory();
		}
		result.append(template.buildClass());
		return result.toString();
	}

	private void createFactory() {
		template = new FactoryTemplateImpl(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				objectType, objectToReturn, fields);
	}

	private void createSimpleFactory() {
		template = new SimpleFactoryTemplate(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				objectType, objectToReturn);
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
}
