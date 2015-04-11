/**
 * 
 */
package com.weebly.gaborcsikos.backend.adapter;

import static com.weebly.gaborcsikos.backend.utility.GeneralUtility.OVERRIDE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

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

	private final FieldWithType target;
	private final String extendedClassMethodName;
	private final String targetMethodName;
	private final String extendedClass;
	private final String targetReturnType;

	public AdapterTemplate(final String packageName, final String className,
			final FieldWithType target, final String extendedClass,
			final String extendedClassMethodName,
 final String targetMethodName,
			final String targetReturnType) {
		super(packageName, className);
		this.target = target;
		this.extendedClass = extendedClass;
		this.extendedClassMethodName = extendedClassMethodName;
		this.targetMethodName = targetMethodName;
		this.targetReturnType = targetReturnType;
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		String extendClass = new String(" extends ");
		extendClass += extendedClass;
		super.setImplementsOrExtendsPart(extendClass);
		sb.append(super.getBasicStucture());
		sb.append(getFields());
		sb.append(NEW_LINE);
		sb.append(getConstructor());
		sb.append(getAdaptedMethod());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private String getAdaptedMethod() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append(OVERRIDE).append(NEW_LINE);
		sb.append(INDENT).append("public ").append(targetReturnType)
				.append(" ").append(extendedClassMethodName).append("() {").append(NEW_LINE);
		sb.append(IndentHelperUtility.DOUBLE_INDENT).append("return ")
				.append(target.getName()).append(".").append(targetMethodName)
				.append("();").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}

	private String getConstructor() {
		List<FieldWithType> fields = addFieldToList();
		return ContructorMakerUtility.getFormttedConsructorFromFields(
				super.getClassName(), fields);
	}

	private String getFields() {
		List<FieldWithType> fields = addFieldToList();
		return FieldMakerUtility.getFormattedFields(fields);
	}

	private List<FieldWithType> addFieldToList() {
		List<FieldWithType> fields = new ArrayList<FieldWithType>();
		fields.add(target);
		return fields;
	}
}
