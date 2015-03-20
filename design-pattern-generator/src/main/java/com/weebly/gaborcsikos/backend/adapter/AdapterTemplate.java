/**
 * 
 */
package com.weebly.gaborcsikos.backend.adapter;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.OVERRIDE;

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
	private final String methodName;
	private final String targetMethodName;
	private final String extendedClass;

	public AdapterTemplate(final String packageName, final String className,
			final FieldWithType target, final String extendedClass,
			final String methodName,
			final String targetMethodName) {
		super(packageName, className);
		this.target = target;
		this.extendedClass = extendedClass;
		this.methodName = methodName;
		this.targetMethodName = targetMethodName;
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
		sb.append(INDENT).append("public ").append(target.getType())
				.append(" ").append(methodName).append("() {").append(NEW_LINE);
		sb.append(IndentHelperUtility.DOUBLE_INDENT).append("return ")
				.append(target.getName()).append(".").append(targetMethodName)
				.append("();");
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
