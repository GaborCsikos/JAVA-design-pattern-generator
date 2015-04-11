/**
 * 
 */
package com.weebly.gaborcsikos.backend.creational.factory;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;

import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;

/**
 * @author Gabor Csikos
 *
 */
public abstract class FactoryTemplate extends BasicTemplate {

	protected final String objectType;
	protected final String objectToReturn;


	public FactoryTemplate(final String packageName, final String className,
			final String objectType,
 final String objectToReturn) {
		super(packageName, className);
		this.objectType = objectType;
		this.objectToReturn = objectToReturn;
	}


	public String getObjectType() {
		return objectType;
	}

	public String getObjectToReturn() {
		return objectToReturn;
	}

	protected String getCommonPart() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("public static ").append(objectType)
				.append(" ").append("get").append(objectType);
		return sb.toString();
	}




}
