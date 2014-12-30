/**
 * 
 */
package com.weebly.gaborcsikos.mainwindow;

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

	/**
	 * Default Constructor
	 */
	public MainWindowController(){
		view = new MainWindowView();
		model = new MainWindowModel();
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
	}

	public void runApplication() {
		initView();
		initModel();
	}

	private void initModel() {


	}

	private void initView() {
		view.init();

	}
}
