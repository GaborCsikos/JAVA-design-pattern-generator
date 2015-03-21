/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.FACADE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.PROTOTYPE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.SINGLETON;

import java.util.NoSuchElementException;

import javax.swing.JFrame;

import com.weebly.gaborcsikos.backend.adapter.AdapterController;
import com.weebly.gaborcsikos.backend.adapter.AdapterModel;
import com.weebly.gaborcsikos.backend.api.PatternEnum;
import com.weebly.gaborcsikos.backend.facade.FacadeController;
import com.weebly.gaborcsikos.backend.facade.FacadeModel;
import com.weebly.gaborcsikos.backend.prototype.PrototypeController;
import com.weebly.gaborcsikos.backend.prototype.PrototypeModel;
import com.weebly.gaborcsikos.backend.singleton.SingletonController;
import com.weebly.gaborcsikos.backend.singleton.SingletonModel;
import com.weebly.gaborcsikos.frontend.patterns.AdapterDialog;
import com.weebly.gaborcsikos.frontend.patterns.FacadeDialog;
import com.weebly.gaborcsikos.frontend.patterns.PrototypeDialog;
import com.weebly.gaborcsikos.frontend.patterns.SingletonDialog;

/**
 * Opener for Design Patterns
 * 
 * @author Gabor Csikos
 * 
 */
public class DesignPatternOpener {

	public void open(final String patternStr, final JFrame frame) {
		if (SINGLETON.getName().equals(patternStr)) {
			SingletonDialog dialog = new SingletonDialog(frame);
			SingletonModel model = new SingletonModel();
			SingletonController controller = new SingletonController(model,
					dialog);
			controller.init();
		} else if (PROTOTYPE.getName().equals(patternStr)) {
			PrototypeDialog dialog = new PrototypeDialog(frame);
			PrototypeModel model = new PrototypeModel();
			PrototypeController controller = new PrototypeController(model,
					dialog);
			controller.init();
		} else if (FACADE.getName().equals(patternStr)) {
			FacadeDialog dialog = new FacadeDialog(frame);
			FacadeModel model = new FacadeModel();
			FacadeController controller = new FacadeController(model, dialog);
			controller.init();
		} else if (PatternEnum.ADAPTER.getName().equals(patternStr)) {
			AdapterDialog dialog = new AdapterDialog(frame);
			AdapterModel model = new AdapterModel();
			AdapterController controller = new AdapterController(model,
					dialog);
			controller.init();
		} else {
			throw new NoSuchElementException();
		}
	}

}
