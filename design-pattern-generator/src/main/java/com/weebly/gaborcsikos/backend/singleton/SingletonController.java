/**
 * 
 */
package com.weebly.gaborcsikos.backend.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import com.weebly.gaborcsikos.backend.api.PatternGeneratorService;
import com.weebly.gaborcsikos.backend.api.exceptions.CanNotCreateClassException;
import com.weebly.gaborcsikos.backend.api.exceptions.FieldVariableIsEmptyException;
import com.weebly.gaborcsikos.backend.service.PatternGeneratorServiceImpl;
import com.weebly.gaborcsikos.frontend.patterns.SingletonDialog;

/**
 * Controller for Singleton
 * 
 * @author Gabor Csikos
 * 
 */
public class SingletonController {

	private final SingletonModel singleton;
	private final SingletonDialog dialog;
	private final PatternGeneratorService service = new PatternGeneratorServiceImpl();
	private File file;
	
	public SingletonController(final SingletonModel model,
			final SingletonDialog dialog) {
		this.singleton = model;
		this.dialog = dialog;
	}

	public void init() {
		addActionListeners();
		initFields();
	}

	private void initFields() {
		singleton.getBasicTemplate().setClassName(dialog.getClassName());
		singleton.getBasicTemplate().setPackageName(dialog.getPackageName());
		singleton.setConstructorPrivate(true);
		singleton.setEnumType(false);
		singleton.setEagerLoaded(true);
		singleton.setLazyLoaded(false);
		singleton.setInstanceName(dialog.getInstanceName());
	}

	private void addActionListeners() {
		dialog.addGeneratePatternListener(new GeneratePatternListener());
		dialog.addEnumListener(new EnumSetterListener());
		dialog.addConstructorListener(new ConstructorSetterListener());
		dialog.addEagerLoadingListener(new EagerLoadingListener());
		dialog.addlazyLoadingListener(new LazyLoadingListener());
		dialog.addInstanceListener(new InstanceSetterListener());
	}

	private void printEvent(final ActionEvent e) {
		System.out.println("action happened:" + e.getActionCommand() + " from:"
				+ e.getSource());
	}

	private void setLoadingType() {
		singleton.setEagerLoaded(dialog.isEagerLoading());
		singleton.setLazyLoaded(dialog.isLazyLoading());
	}

	class GeneratePatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			int returnVal = dialog.getFileChooser().showOpenDialog(dialog);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("OPENED:"
						+ dialog.getFileChooser().getSelectedFile()
								.getAbsolutePath());
				String className = dialog.getClassName();
				String packageName = dialog.getPackageName();
				singleton.getBasicTemplate().setClassName(className);
				singleton.getBasicTemplate().setPackageName(packageName);
				if (className != null) {
					String path = getPath(dialog.getFileChooser()
							.getSelectedFile().getAbsolutePath());
					System.out.println("FilePath:" + path);
					try {
						file = new File(path);
						service.generatePatternToFile(file, singleton);
					} catch (CanNotCreateClassException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FieldVariableIsEmptyException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					// TODO add dialog
				}

			}
		}

		private String getPath(final String simplePath) {
			StringBuilder sb = new StringBuilder(simplePath);
			sb.append(File.separator);
			sb.append(dialog.getClassName());
			sb.append(".java");
			return sb.toString();
		}
	}

	class EnumSetterListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			singleton.setEnumType(dialog.isEnumType());
			dialog.setOptions(dialog.isEnumType());
		}
	}

	class ConstructorSetterListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			singleton.setConstructorPrivate(dialog.isPrivateConstructor());
		}
	}

	class EagerLoadingListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setLoadingType();
		}
	}

	class LazyLoadingListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			setLoadingType();
		}
	}

	class InstanceSetterListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			printEvent(e);
			singleton.setInstanceName(dialog.getInstanceName());
		}
	}
}
