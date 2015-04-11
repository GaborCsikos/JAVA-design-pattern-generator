/**
 * 
 */
package com.weebly.gaborcsikos.backend.structural.facade;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.utility.ContructorMakerUtility;
import com.weebly.gaborcsikos.backend.utility.FieldMakerUtility;

/**
 * Tepmlate for facade common info
 * 
 * @author Gabor Csikos
 * 
 */
public abstract class FacadeTemplate extends BasicTemplate {

	private final List<FieldWithType> fields = new ArrayList<FieldWithType>();

	public FacadeTemplate(final String packageName, final String className) {
		super(packageName, className);
	}

	protected String getFields() {
		return FieldMakerUtility.getFormattedFields(fields);
	}

	protected String getConstructor() {
		return ContructorMakerUtility.getFormttedConsructorFromFields(
				super.getClassName(), fields);
	}

	public void addField(final String type, final String name) {
		FieldWithType field = new FieldWithType(type, name);
		fields.add(field);
	}

	public void addFields(final List<FieldWithType> fieldsToAdd) {
		fields.addAll(fieldsToAdd);
	}

	public boolean fieldsEmpty() {
		return fields.isEmpty();
	}
}
