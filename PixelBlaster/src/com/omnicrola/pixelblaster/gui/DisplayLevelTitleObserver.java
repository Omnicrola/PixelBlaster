package com.omnicrola.pixelblaster.gui;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.gui.fx.CenterHorizontal;
import com.omnicrola.pixelblaster.map.ILevelObserver;
import com.omnicrola.pixelblaster.map.IMapController;

public class DisplayLevelTitleObserver implements ILevelObserver {

	private final IUserInterface rootElement;
	private final IGraphicsWrapper graphicsWrapper;

	public DisplayLevelTitleObserver(IUserInterface rootElement, IGraphicsWrapper graphicsWrapper) {
		this.rootElement = rootElement;
		this.graphicsWrapper = graphicsWrapper;
	}

	@Override
	public void newLevelLoaded(IMapController mapController) {
		final String title = mapController.getTitle();
		final String subTitle = mapController.getSubtitle();

		final GLabel titleElement = new GLabel(title);
		final GLabel subtitleElement = new GLabel(subTitle);
		titleElement.setShadowed(true);
		subtitleElement.setShadowed(true);

		titleElement.addEffect(new RemoveElementDelay(5000));
		subtitleElement.addEffect(new RemoveElementDelay(4000));
		titleElement.addEffect(new CenterHorizontal(-100, this.graphicsWrapper));
		subtitleElement.addEffect(new CenterHorizontal(0, this.graphicsWrapper));

		this.rootElement.addChild(titleElement);
		this.rootElement.addChild(subtitleElement);
	}

}
