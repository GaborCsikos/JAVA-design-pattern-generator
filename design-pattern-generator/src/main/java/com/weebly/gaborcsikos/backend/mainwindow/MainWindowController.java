/**
 * 
 */
package com.weebly.gaborcsikos.backend.mainwindow;

import static com.weebly.gaborcsikos.backend.designpattern.PatternEnum.SINGLETON;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import com.weebly.gaborcsikos.backend.designpattern.DesignPattern;
import com.weebly.gaborcsikos.backend.designpattern.DesignPatternMapper;
import com.weebly.gaborcsikos.backend.service.DesignPatternService;
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
	private final DesignPatternMapper mapper;

	/**
	 * Default Constructor
	 */
	public MainWindowController(){
		view = new MainWindowView();
		model = new MainWindowModel();
		service = new DesignPatternServiceImpl();
		mapper = new DesignPatternMapper();
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
		mapper = new DesignPatternMapper();
	}

	public void runApplication() {
		initView();
		initModel();
		addComboboxElementsToView();

	}

	private void addActionListeners() {
		view.addSelectPatternListener(new SelectPatternListener());
	}

	private void addComboboxElementsToView() {
		view.addElementsToCombobox(mapper.mapToStrings(model.getPatterns()));
	}

	private void initModel() {
		model.setPatterns(service.loadAllDesignPattern());
	}

	private void initView() {
		view.init();
		addActionListeners();
	}

	class SelectPatternListener implements ActionListener {

		public void actionPerformed(final ActionEvent e) {
			System.out.println("action happened:" + e.getActionCommand()
					+ " from:" + e.getSource());
			String patternStr = view.getSelectedPattern();
			DesignPattern pattern = getSelectedPatternFormstr(patternStr);
			if (pattern != null) {
				openPattern(patternStr, pattern);
			} else {
				throw new NoSuchElementException("Design pattern doesn't exist");
			}
		}

		private void openPattern(final String patternStr,
				final DesignPattern pattern) {
			if (SINGLETON.getName().equals(patternStr)) {
				view.openSingletonDialog();
			}

		}

		private DesignPattern getSelectedPatternFormstr(final String patternStr) {
			for (DesignPattern pattern : model.getPatterns().getPatterns()) {
				if (patternStr.equals(pattern.getName())) {
					return pattern;
				}
			}
			return null;
		}

	}

}
