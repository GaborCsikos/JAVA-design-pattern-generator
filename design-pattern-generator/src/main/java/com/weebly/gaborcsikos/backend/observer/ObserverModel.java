/**
 * 
 */
package com.weebly.gaborcsikos.backend.observer;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.OBSERVER;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

/**
 * @author Gabor Csikos
 *
 */
public class ObserverModel extends DesignPatternModel {
	private String observerName;
	private boolean arrayList;
	private ObserverTemplate template;
	private boolean needToCreateInterface = false;

	public ObserverModel() {

	}

	public ObserverModel(final String packaName, final String className,
			final String observerName, final boolean arrayList) {
		super(packaName, className);
		this.arrayList = arrayList;
		this.observerName = observerName;
	}

	public void initObserver(final boolean arrayList, final String observerName) {
		super.setName(OBSERVER.getName());
		this.arrayList = arrayList;
		this.observerName = observerName;
	}
	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel#getGeneratedPattern()
	 */
	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		if (!needToCreateInterface) {
			createSubject();
			needToCreateInterface = true;
		} else {
			createObserver();
			needToCreateInterface = false;
		}

		result.append(template.buildClass());
		return result.toString();
	}

	private void createSubject() {
		template =new SubjectTemplate(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				observerName, arrayList);
	}

	private void createObserver() {
		template = new ObserverInterfaceTemplate(super.getBasicTemplate()
				.getPackageName(), observerName);

	}

	public String getObserverName() {
		return observerName;
	}
	public void setObserverName(final String observerName) {
		this.observerName = observerName;
	}
	public boolean isArrayList() {
		return arrayList;
	}
	public void setArrayList(final boolean arrayList) {
		this.arrayList = arrayList;
	}

}
