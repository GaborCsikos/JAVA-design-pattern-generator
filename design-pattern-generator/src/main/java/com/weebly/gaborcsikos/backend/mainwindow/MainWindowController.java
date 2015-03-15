/**
 * 
 */
package com.weebly.gaborcsikos.backend.mainwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import com.weebly.gaborcsikos.backend.api.DesignPatternService;
import com.weebly.gaborcsikos.backend.api.PatternTypeEnum;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternOpener;
import com.weebly.gaborcsikos.backend.service.DesignPatternServiceImpl;
import com.weebly.gaborcsikos.frontend.mainwindow.MainWindowView;

/**
 * Class is a controller between {@link MainWindowView} and
 * {@link MainWindowModel}
 * 
 * @author Gabor Csikos
 * 
 */
public class MainWindowController {

	private final MainWindowView view;
	private final MainWindowModel model;
	private final DesignPatternService service;
	private final DesignPatternOpener opener;

	/**
	 * Default Constructor
	 */
	public MainWindowController(){
		view = new MainWindowView();
		model = new MainWindowModel();
		service = new DesignPatternServiceImpl();
		opener = new DesignPatternOpener();
	}

	/**
	 * 
	 * @param view
	 *            the {@link MainWindowView}
	 * @param model
	 *            the {@link MainWindowModel}
	 */
	public MainWindowController(final MainWindowView view,
			final MainWindowModel model) {
		this.view = view;
		this.model = model;
		service = new DesignPatternServiceImpl();
		opener = new DesignPatternOpener();
	}

	public void runApplication() {
		initView();
		initModel();
		addComboboxElementsToView();

	}

	private void addActionListeners() {
		view.addSelectPatternListener(new SelectPatternListener());
		view.addSelectPatternTypeListener(new SelectPatternTypeListener());
	}

	private void addComboboxElementsToView() {
		view.addElementsToCombobox(model.getCreationalPatterns());
		view.addPatternTypes(model.getPatterntypes());
	}

	private void initModel() {
		model.setPatterntypes(service.loadPatternTypes());
		model.setCreationalPatterns(service.loadCreationalPatterns());
		model.setBehavioralPatterns(service.loadBehavioralPatterns());
		model.setStructuralPatterns(service.loadStructuralPatterns());
	}

	private void initView() {
		view.init();
		addActionListeners();
	}

	class SelectPatternTypeListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			System.out.println("action happened:" + e.getActionCommand()
					+ " from:" + e.getSource());
			String patternStr = view.getSelectedPatternType();
			if (PatternTypeEnum.CREATIONAL.getName().equals(patternStr)) {
				view.setPatterns(model.getCreationalPatterns());
			} else if (PatternTypeEnum.BEHAVIORAL.getName().equals(patternStr)) {
				view.setPatterns(model.getBehavioralPatterns());
			} else if (PatternTypeEnum.STRUCTURAL.getName().equals(patternStr)) {
				view.setPatterns(model.getStructuralPatterns());
			}
		}

	}

	class SelectPatternListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			System.out.println("action happened:" + e.getActionCommand()
					+ " from:" + e.getSource());
			String patternStr = view.getSelectedPattern();
			if (patternStr != null) {
				opener.open(patternStr, view);
			} else {
				throw new NoSuchElementException("Design pattern doesn't exist");
			}
		}

	}

}
