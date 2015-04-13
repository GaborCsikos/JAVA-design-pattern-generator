/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.builder;

import static com.weebly.gaborcsikos.backend.utility.GeneralUtility.getUppercaseMethodName;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.utility.FieldMakerUtility;

/**
 * Template for Builder
 * 
 * @author Gabor Csikos
 * 
 */
public class BuilderTemplate extends BasicTemplate {
	
	private final boolean containsBuildMethod;
	private List<FieldWithType> fields = new ArrayList<FieldWithType>();
	
	public BuilderTemplate(final String packageName, final String className,
			final boolean containsBuildMethod, final List<FieldWithType> fields) {
		super(packageName, className);
		this.containsBuildMethod = containsBuildMethod;
		this.fields = fields;
	}

	protected String getFields() {
		return FieldMakerUtility.getFormattedFields(fields);
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBasicStucture());
		sb.append(getFields());
		sb.append(NEW_LINE);
		sb.append(getBuilderMethods());
		if (containsBuildMethod) {
			sb.append(NEW_LINE);
			sb.append(getBuildOption());
		}
		sb.append(super.getEndStructure());
		return sb.toString();
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
	private String getBuilderMethods() {
		StringBuilder sb = new StringBuilder();
		for (FieldWithType field : fields) {
			sb.append(INDENT).append("public ").append(super.getClassName())
					.append(" set")
					.append(getUppercaseMethodName(field
							.getName()))
					.append("(final ").append(field.getType()).append(" ")
					.append(field.getName()).append(") {").append(NEW_LINE);
			sb.append(DOUBLE_INDENT).append("this.").append(field.getName())
					.append(" = ").append(field.getName()).append(";")
					.append(NEW_LINE);
			sb.append(DOUBLE_INDENT).append("return this;").append(NEW_LINE);
			sb.append(INDENT).append("}")
					.append(DOUBLE_NEW_LINE);
		}

		return sb.toString();
	}

	private String getBuildOption() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public ").append(super.getClassName())
				.append(" build() {").append(NEW_LINE);
		sb.append(DOUBLE_INDENT).append("return new ")
				.append(super.getClassName()).append("();").append(NEW_LINE);
		sb.append(INDENT).append("}").append(NEW_LINE);
		return sb.toString();
	}
}
