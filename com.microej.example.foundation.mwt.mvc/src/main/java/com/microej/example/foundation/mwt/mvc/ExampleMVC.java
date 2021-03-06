/**
 * Java
 *
 * Copyright 2009-2012 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package com.microej.example.foundation.mwt.mvc;

import java.io.IOException;

import com.microej.example.foundation.mwt.mvc.controller.PercentageController;
import com.microej.example.foundation.mwt.mvc.model.PercentageModel;
import com.microej.example.foundation.mwt.mvc.view.BarWidget;
import com.microej.example.foundation.mwt.mvc.view.CompositeView;
import com.microej.example.foundation.mwt.mvc.view.PieWidget;
import com.microej.example.foundation.mwt.mvc.view.TextWidget;
import ej.microui.MicroUI;
import ej.microui.display.Display;
import ej.microui.display.FlyingImage;
import ej.microui.display.Image;
import ej.microui.event.EventGenerator;
import ej.microui.event.generator.Pointer;
import ej.mwt.Desktop;
import ej.mwt.Panel;

/**
 * Shows three views (bar, pie, text) that represents the same data model (a percentage value).
 * It is possible to resize the views by dragging the cross at the intersection of the three views.
 */
public class ExampleMVC {

	public static void main(String[] args) {
		// start microUI
		MicroUI.start();

		// get the default display
		Display display = Display.getDefaultDisplay();

		// Add an image to display the pointer
		EventGenerator eventGen = EventGenerator.get(Pointer.class, 0);
		Pointer gen = (Pointer) eventGen;
		if (gen != null) {
			// try to create an image for the cursor
			try {
				Image cursor = Image.createImage("/images/mouse_cursor.png");
				gen.setFlyingImage(new FlyingImage(cursor));
			} catch (IOException e) {
				System.out.println("Cannot load cursor image.");
				return;
			}
		}

		Desktop desktop = new Desktop(display);

		// create model
		PercentageModel model = new PercentageModel();
		model.setValue(25);

		// create the views
		TextWidget textWidget = new TextWidget();
		BarWidget barWidget = new BarWidget();
		PieWidget pieWidget = new PieWidget();

		// add the views to the composite view
		CompositeView compositeView = new CompositeView(textWidget, pieWidget, barWidget);
		compositeView.setXCross(desktop.getWidth() / 2);
		compositeView.setYCross(desktop.getHeight() / 2);

		// set the views model (the views become listeners to the model)
		textWidget.setModel(model);
		barWidget.setModel(model);
		pieWidget.setModel(model);

		// create the panel
		Panel panel = new Panel();
		panel.setEventHandler(new PercentageController(compositeView, model));
		panel.setWidget(compositeView);

		// show the displayable
		panel.show(desktop, true);
		desktop.show();
	}

}
