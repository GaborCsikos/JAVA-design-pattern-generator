/**
 * 
 */
package com.weebly.gaborcsikos.backend.adapter;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.utility.ContructorMakerUtility;
import com.weebly.gaborcsikos.backend.utility.FieldMakerUtility;
import com.weebly.gaborcsikos.backend.utility.IndentHelperUtility;

/**
 * Template for Adapter
 * 
 * @author Gabor Csikos
 * 
 */
public class AdapterTemplate extends BasicTemplate {

	private final List<FieldWithType> fields = new ArrayList<FieldWithType>();

	public AdapterTemplate(final String packageName, final String className,
			final FieldWithType field) {
		super(packageName, className);
		fields.add(field);
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBasicStucture()); // TODO extend
		sb.append(getFields());
		sb.append(IndentHelperUtility.NEW_LINE);
		sb.append(getConstructor());
		sb.append(IndentHelperUtility.NEW_LINE);
		sb.append(getAdaptedMethod());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private String getAdaptedMethod() {
		StringBuilder sb = new StringBuilder();
		// TODO Adaper
		return sb.toString();
	}

	private String getConstructor() {
		return ContructorMakerUtility.getFormttedConsructorFromFields(
				super.getClassName(), fields);
	}

	private String getFields() {
		return FieldMakerUtility.getFormattedFields(fields);
	}
}
