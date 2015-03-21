/**
 * 
 */
package com.weebly.gaborcsikos.backend.iterator;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel;

/**
 * @author Gabor Csikos
 *
 */
public class IteratorModel extends DesignPatternModel {

	private IteratorTemplate template;
	private boolean removeSupported;
	private String classToIterate;

	public IteratorModel() {

	}

	public IteratorModel(final String packaName, final String className,final String classToIterate,final boolean removeSupported) {
		super(packaName, className);
		this.setClassToIterate(classToIterate);
		this.setRemoveSupported(removeSupported);
	}

	/* (non-Javadoc)
	 * @see com.weebly.gaborcsikos.backend.designpattern.DesignPatternModel#getGeneratedPattern()
	 */
	@Override
	public String getGeneratedPattern() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder result = new StringBuilder();
		template = new IteratorTemplate(super.getBasicTemplate()
				.getPackageName(), super.getBasicTemplate().getClassName(),
				classToIterate, removeSupported);
		result.append(template.buildClass());
		return result.toString();
	}

	public boolean isRemoveSupported() {
		return removeSupported;
	}

	public void setRemoveSupported(final boolean removeSupported) {
		this.removeSupported = removeSupported;
	}

	public String getClassToIterate() {
		return classToIterate;
	}

	public void setClassToIterate(final String classToIterate) {
		this.classToIterate = classToIterate;
	}

}
