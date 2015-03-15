/**
 * 
 */
package com.weebly.gaborcsikos.backend.facade;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.FACADE;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;

/**
 * model for Prototype
 * 
 * @author Gabor Csikos
 * 
 */
public class FacadeModel extends DesignPatternModel {

	private boolean withInterface = false;
	private boolean needToCreateInterface = false;
	private FacadeTemplate template;
	private final List<FieldWithType> fields = new ArrayList<FieldWithType>();
	public boolean isWithInterface() {
		return withInterface;
	}

	public void setWithInterface(final boolean withInterface) {
		this.withInterface = withInterface;
	}

	public List<FieldWithType> getFields() {
		return fields;
	}


	/**
	 * Default constructor
	 */
	public FacadeModel() {

	}

	public FacadeModel(final String packaName, final String className) {
		super(packaName, className);
	}

	public void initFacade(final boolean withInterface) {
		super.setName(FACADE.getName());
		this.withInterface = withInterface;
	}


	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();

		if (!needToCreateInterface) {
			if (fields.isEmpty()) {
				throw new FieldVariableIsEmptyException();
			}
			if (withInterface) {
				createFacadeWithInterface();
				needToCreateInterface = true;
			} else {
				createNormalFacade();
				needToCreateInterface = false;
			}
		} else {
			createInterFace();
			needToCreateInterface = false;
		}

		result.append(template.buildClass());
		return result.toString();
	}

	private void createInterFace() {
		template = new FacadeInterface(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName());
	}

	private void createNormalFacade() {
		template = new FacadeNormal(super.getBasicTemplate().getPackageName(),
				super.getBasicTemplate().getClassName(), fields);

	}

	private void createFacadeWithInterface() {
		template = new FacadeWithInterface(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				fields);

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
