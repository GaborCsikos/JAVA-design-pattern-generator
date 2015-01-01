/**
 * 
 */
package com.weebly.gaborcsikos.backend.mainwindow;

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

	/**
	 * Default Constructor
	 */
	public MainWindowController(){
		view = new MainWindowView();
		model = new MainWindowModel();
		service = new DesignPatternServiceImpl();
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
	}

	public void runApplication() {
		initView();
		initModel();
	}

	private void initModel() {
		model.setPatterns(service.loadAllDesignPattern());
	}

	private void initView() {
		view.init();

	}
}
