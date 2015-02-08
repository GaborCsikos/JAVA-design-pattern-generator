/**
 * 
 */
package com.weebly.gaborcsikos.backend.singleton;

import com.weebly.gaborcsikos.frontend.patterns.SingletonDialog;

/**
 * Controller for Singleton
 * 
 * @author Gabor Csikos
 * 
 */
public class SingletonController {

	private final Singleton singleton;
	private final SingletonDialog dialog;
	
	public SingletonController(final Singleton singleton,final SingletonDialog dialog){
		this.singleton = singleton;
		this.dialog = dialog;
	}
	// TODO START DIALOG
}
