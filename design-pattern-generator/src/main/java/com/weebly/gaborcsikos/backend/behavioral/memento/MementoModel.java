/**
 * 
 */
package com.weebly.gaborcsikos.backend.behavioral.memento;

import static com.weebly.gaborcsikos.backend.behavioral.memento.MementoPrintState.PRINT_CARETAKE;
import static com.weebly.gaborcsikos.backend.behavioral.memento.MementoPrintState.PRINT_MEMENTO;
import static com.weebly.gaborcsikos.backend.behavioral.memento.MementoPrintState.PRINT_ORIGINATOR;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

/**
 * Model for Memento
 * 
 * @author Gabor Csikos
 * 
 */
public class MementoModel extends DesignPatternModel {

	private String stateType;
	private String stateName;
	private String mementoName;

	private MementoPrintState state;
	private MementoTemplate template;
	public MementoModel(final String packageName, final String className,
			final String stateType, final String stateName) {
		super(packageName, className);
		this.stateType = stateType;
		this.stateName = stateName;
		this.mementoName = className;
		this.state = MementoPrintState.PRINT_MEMENTO;
	}

	/**
	 * Default constructor
	 */
	public MementoModel() {

	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel#getGeneratedPattern()
	 */
	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		if (state == PRINT_MEMENTO) {
			template = new MementoTemplateImpl(super.getBasicTemplate()
					.getPackageName(), super.getBasicTemplate().getClassName(),
					stateType, stateName);
		} else if (state == PRINT_ORIGINATOR) {
			template = new OriginatorTemplate(super.getBasicTemplate()
					.getPackageName(), super.getBasicTemplate().getClassName(),
					stateType, stateName, mementoName);
		} else if (state == PRINT_CARETAKE) {
			template = new CareTakerTemplate(super.getBasicTemplate()
					.getPackageName(), super.getBasicTemplate().getClassName(),
					stateType, stateName, mementoName);
		}

		result.append(template.buildClass());
		return result.toString();
	}

	public String getStateType() {
		return stateType;
	}

	public void setStateType(final String stateType) {
		this.stateType = stateType;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(final String stateName) {
		this.stateName = stateName;
	}

	public MementoPrintState getState() {
		return state;
	}

	public void setState(final MementoPrintState state) {
		this.state = state;
	}

	public String getMementoName() {
		return mementoName;
	}

	public void setMementoName(final String mementoName) {
		this.mementoName = mementoName;
	}
}
