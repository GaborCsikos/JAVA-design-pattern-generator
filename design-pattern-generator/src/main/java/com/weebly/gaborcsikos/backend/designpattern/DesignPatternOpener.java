/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.SINGLETON;

import javax.swing.JFrame;

import com.weebly.gaborcsikos.frontend.patterns.SingletonDialog;

/**
 * Opener for Design Patterns;
 * 
 * @author Gabor Csikos
 * 
 */
public class DesignPatternOpener {

	public void open(final String patternStr, final JFrame frame) {
		if (SINGLETON.getName().equals(patternStr)) {
			SingletonDialog dialog = new SingletonDialog(frame);
		}
	}

}
