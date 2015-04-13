/**
 * 
 */
package com.weebly.gaborcsikos.backend.designpattern;

import static com.weebly.gaborcsikos.backend.api.PatternEnum.ADAPTER;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.BUILDER;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.CHAIN_OF_RESPONSIBILITY;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.COMPOSITE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.FACADE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.FACTORY;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.ITERATOR;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.MEMENTO;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.OBSERVER;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.PROTOTYPE;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.PROXY;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.SINGLETON;
import static com.weebly.gaborcsikos.backend.api.PatternEnum.VISITOR;

import java.util.NoSuchElementException;

import javax.swing.JFrame;

import com.weebly.gaborcsikos.backend.behavioral.chainofresponsibility.ChainOfResponsibilityController;
import com.weebly.gaborcsikos.backend.behavioral.chainofresponsibility.ChainOfResponsibilityModel;
import com.weebly.gaborcsikos.backend.behavioral.iterator.IteratorController;
import com.weebly.gaborcsikos.backend.behavioral.iterator.IteratorModel;
import com.weebly.gaborcsikos.backend.behavioral.memento.MementoController;
import com.weebly.gaborcsikos.backend.behavioral.memento.MementoModel;
import com.weebly.gaborcsikos.backend.behavioral.observer.ObserverController;
import com.weebly.gaborcsikos.backend.behavioral.observer.ObserverModel;
import com.weebly.gaborcsikos.backend.behavioral.visitor.VisitorController;
import com.weebly.gaborcsikos.backend.behavioral.visitor.VisitorModel;
import com.weebly.gaborcsikos.backend.creational.builder.BuilderController;
import com.weebly.gaborcsikos.backend.creational.builder.BuilderModel;
import com.weebly.gaborcsikos.backend.creational.factory.FactoryController;
import com.weebly.gaborcsikos.backend.creational.factory.FactoryModel;
import com.weebly.gaborcsikos.backend.creational.prototype.PrototypeController;
import com.weebly.gaborcsikos.backend.creational.prototype.PrototypeModel;
import com.weebly.gaborcsikos.backend.creational.singleton.SingletonController;
import com.weebly.gaborcsikos.backend.creational.singleton.SingletonModel;
import com.weebly.gaborcsikos.backend.structural.adapter.AdapterController;
import com.weebly.gaborcsikos.backend.structural.adapter.AdapterModel;
import com.weebly.gaborcsikos.backend.structural.composite.CompositeController;
import com.weebly.gaborcsikos.backend.structural.composite.CompositeModel;
import com.weebly.gaborcsikos.backend.structural.facade.FacadeController;
import com.weebly.gaborcsikos.backend.structural.facade.FacadeModel;
import com.weebly.gaborcsikos.backend.structural.proxy.ProxyController;
import com.weebly.gaborcsikos.backend.structural.proxy.ProxyModel;
import com.weebly.gaborcsikos.frontend.patterns.AdapterDialog;
import com.weebly.gaborcsikos.frontend.patterns.BuilderDialog;
import com.weebly.gaborcsikos.frontend.patterns.ChainOfResponsibilityDialog;
import com.weebly.gaborcsikos.frontend.patterns.CompositeDialog;
import com.weebly.gaborcsikos.frontend.patterns.FacadeDialog;
import com.weebly.gaborcsikos.frontend.patterns.FactoryDialog;
import com.weebly.gaborcsikos.frontend.patterns.IteratorDialog;
import com.weebly.gaborcsikos.frontend.patterns.MementoDialog;
import com.weebly.gaborcsikos.frontend.patterns.ObserverDialog;
import com.weebly.gaborcsikos.frontend.patterns.PrototypeDialog;
import com.weebly.gaborcsikos.frontend.patterns.ProxyDialog;
import com.weebly.gaborcsikos.frontend.patterns.SingletonDialog;
import com.weebly.gaborcsikos.frontend.patterns.VisitorDialog;

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
		} else if (ADAPTER.getName().equals(patternStr)) {
			AdapterDialog dialog = new AdapterDialog(frame);
			AdapterModel model = new AdapterModel();
			AdapterController controller = new AdapterController(model,
					dialog);
			controller.init();
		} else if (ITERATOR.getName().equals(patternStr)) {
			IteratorDialog dialog = new IteratorDialog(frame);
			IteratorModel model = new IteratorModel();
			IteratorController controller = new IteratorController(model,
					dialog);
			controller.init();
		} else if (OBSERVER.getName().equals(patternStr)) {
			ObserverDialog dialog = new ObserverDialog(frame);
			ObserverModel model = new ObserverModel();
			ObserverController controller = new ObserverController(model,
					dialog);
			controller.init();
		} else if (BUILDER.getName().equals(patternStr)) {
			BuilderDialog dialog = new BuilderDialog(frame);
			BuilderModel model = new BuilderModel();
			BuilderController controller = new BuilderController(model,
					dialog);
			controller.init();
		} else if (FACTORY.getName().equals(patternStr)) {
			FactoryDialog dialog = new FactoryDialog(frame);
			FactoryModel model = new FactoryModel();
			FactoryController controller = new FactoryController(model, dialog);
			controller.init();
		} else if (CHAIN_OF_RESPONSIBILITY.getName().equals(
				patternStr)) {
			ChainOfResponsibilityDialog dialog = new ChainOfResponsibilityDialog(
					frame);
			ChainOfResponsibilityModel model = new ChainOfResponsibilityModel();
			ChainOfResponsibilityController controller = new ChainOfResponsibilityController(
					model, dialog);
			controller.init();
		} else if (COMPOSITE.getName().equals(patternStr)) {
			CompositeDialog dialog = new CompositeDialog(frame);
			CompositeModel model = new CompositeModel();
			CompositeController controller = new CompositeController(model,
					dialog);
			controller.init();
		} else if (PROXY.getName().equals(patternStr)) {
			ProxyDialog dialog = new ProxyDialog(frame);
			ProxyModel model = new ProxyModel();
			ProxyController controller = new ProxyController(model, dialog);
			controller.init();
		} else if (VISITOR.getName().equals(patternStr)) {
			VisitorDialog dialog = new VisitorDialog(frame);
			VisitorModel model = new VisitorModel();
			VisitorController controller = new VisitorController(model, dialog);
			controller.init();
		} else if (MEMENTO.getName().equals(patternStr)) {
			MementoDialog dialog = new MementoDialog(frame);
			MementoModel model = new MementoModel();
			MementoController controller = new MementoController(model, dialog);
			controller.init();
		} else {
			throw new NoSuchElementException();
		}
	}

}
