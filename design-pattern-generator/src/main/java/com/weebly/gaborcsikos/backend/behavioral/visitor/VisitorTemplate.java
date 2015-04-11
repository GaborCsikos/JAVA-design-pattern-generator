/**
 * 
 */
package com.weebly.gaborcsikos.backend.behavioral.visitor;

import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.INDENT;
import static com.weebly.gaborcsikos.backend.utility.IndentHelperUtility.NEW_LINE;

import com.weebly.gaborcsikos.backend.api.ClassType;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.designpattern.BasicTemplate;

/**
 * @author Gabor Csikos
 *
 */
public class VisitorTemplate extends BasicTemplate {

	private final String classTypeToVisit;
	private final String classNameToVisit;

	public VisitorTemplate(final String packageName, final String className,
			final String classTypeToVisit, final String classNameToVisit) {
		super(packageName, className);
		this.classTypeToVisit = classTypeToVisit;
		this.classNameToVisit = classNameToVisit;
	}

	// TODO add unit tests
	@Override
	public String buildClass() throws CanNotCreateClassException {
		StringBuilder sb = new StringBuilder();
		super.setType(ClassType.INTERFACE);
		sb.append(super.getBasicStucture());
		sb.append(getVisitmethod());
		sb.append(super.getEndStructure());
		return sb.toString();
	}

	private String getVisitmethod() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDENT).append("void visit(").append(classTypeToVisit)
				.append(" ").append(classNameToVisit).append(");")
				.append(NEW_LINE);
		return sb.toString();
	}
}
