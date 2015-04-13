/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.factory;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.DOUBLE_INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.TRIPLE_INDENT;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.designpattern.FieldWithType;
import com.weebly.gaborcsikos.backend.utility.FieldMakerUtility;

/**
 * Implementation of factory template
 * 
 * @author Gabor Csikos
 * 
 */
public class FactoryTemplateImpl extends FactoryTemplate {

	private List<FieldWithType> fields = new ArrayList<FieldWithType>();
	
	public FactoryTemplateImpl(final String packageName,
			final String className, final String getMehtodType,
			final String classToReturn, final List<FieldWithType> fields) {
		super(packageName, className, getMehtodType, classToReturn);
		this.fields = fields;
	}

	@Override
	public String buildClass() throws CanNotCreateClassException,
			FieldVariableIsEmptyException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBasicStucture());
		sb.append(getCommonPart());
		sb.append(getFactoryStructure());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private String getFactoryStructure() {
		StringBuilder sb = new StringBuilder();
		sb.append("(String criteria) {").append(NEW_LINE);
		boolean first = true;
		if (fields.size() == 1) {
			sb.append(DOUBLE_INDENT).append("if (\"")
					.append(fields.get(0).getType())
					.append("\".equals(criteria)) {").append(NEW_LINE);
			sb.append(TRIPLE_INDENT).append("return new ")
					.append(fields.get(0).getName()).append("();")
					.append(NEW_LINE);
			sb.append(DOUBLE_INDENT).append("}").append(NEW_LINE);
			sb.append(INDENT).append("}").append(NEW_LINE);
		} else {
			for (FieldWithType field : fields) {
				if (first) {
					sb.append(DOUBLE_INDENT).append("if (\"")
							.append(field.getType())
							.append("\".equals(criteria)) {").append(NEW_LINE);
					sb.append(TRIPLE_INDENT).append("return new ")
							.append(field.getName()).append("();")
							.append(NEW_LINE);
					first = false;
				} else {
					sb.append(DOUBLE_INDENT).append("} else if (\"")
							.append(field.getType())
							.append("\".equals(criteria)) {").append(NEW_LINE);
					sb.append(TRIPLE_INDENT).append("return new ")
							.append(field.getName()).append("();")
							.append(NEW_LINE);
				}

			}
			sb.append(DOUBLE_INDENT).append("}").append(NEW_LINE);
			sb.append(INDENT).append("}").append(NEW_LINE);
		}

		return sb.toString();
	}

	protected String getFields() {
		return FieldMakerUtility.getFormattedFields(fields);
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
