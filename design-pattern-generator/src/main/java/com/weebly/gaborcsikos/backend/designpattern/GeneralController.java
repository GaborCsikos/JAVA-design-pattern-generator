/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.apache.commons.lang3.StringUtils;

import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.frontend.patterns.ClassGenerateDialog;

/**
 * Generate Controller class
 * 
 * @author Gabor Csikos
 * 
 */
public abstract class GeneralController {

	private final ClassGenerateDialog dialog;
	private final DesignPatternModel model;
	private final PatternGeneratorService service = new PatternGeneratorServiceImpl();

	public GeneralController(final DesignPatternModel model,
			final ClassGenerateDialog dialog) {
		this.dialog = dialog;
		this.model = model;
	}

	public abstract void setData();

	public abstract void init();

	public void initFields() {
		model.getBasicTemplate().setClassName(dialog.getClassName());
		model.getBasicTemplate().setPackageName(dialog.getPackageName());
		setData();
	}
	protected void printEvent(final ActionEvent e) {
		System.out.println("action happened:" + e.getActionCommand() + " from:"
				+ e.getSource());
	}
	public boolean mandatoryFieldsAreEmpty() {
		if (StringUtils.isEmpty(dialog.getClassName())) {
			dialog.openMessageDialog("Class name can't be empty");
			return true;
		} else if (StringUtils.isEmpty(dialog.getPackageName())) {
			dialog.openMessageDialog("package name can't be empty");
			return true;
		}
		return false;
	}
	
	public boolean fileOpenApproved(){
		int returnVal = dialog.getFileChooser().showOpenDialog(dialog);
		return returnVal == JFileChooser.APPROVE_OPTION;

	}

	public void showPath() {
		System.out.println("OPENED:"
				+ dialog.getFileChooser().getSelectedFile().getAbsolutePath());
	}

	public void setClassAndPackage() {
		String className = dialog.getClassName();
		String packageName = dialog.getPackageName();
		model.getBasicTemplate().setClassName(className);
		model.getBasicTemplate().setPackageName(packageName);
	}

	public boolean classNameIsNullOrEmpty() {
		return StringUtils.isEmpty(model.getBasicTemplate().getClassName());
	}

	public void generateFile() {
		generateFile("");
	}
	
	public void generateFile(final String extension) {
		String path = getPath(dialog.getFileChooser()
.getSelectedFile()
				.getAbsolutePath(), extension);
		System.out.println("FilePath:" + path);
		File file = new File(path);
		try {
			service.generatePatternToFile(file, model);
		} catch (CanNotCreateClassException e1) {
			dialog.openMessageDialog("Class and package name can't be empty");
			e1.printStackTrace();
		} catch (FieldVariableIsEmptyException e1) {
			dialog.openMessageDialog("instance name can't be empty");
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private String getPath(final String simplePath, final String extension) {
		StringBuilder sb = new StringBuilder(simplePath);
		sb.append(File.separator);
		sb.append(dialog.getClassName()).append(extension);
		sb.append(".java");
		return sb.toString();
	}

}
