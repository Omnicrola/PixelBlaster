package com.omnicrola.pixelblaster.gui;

import com.omnicrola.pixelblaster.map.ILevelObserver;
import com.omnicrola.pixelblaster.map.IMapController;

public class DisplayLevelTitleObserver implements ILevelObserver {

	private final IUserInterface rootElement;

	public DisplayLevelTitleObserver(IUserInterface rootElement) {
		this.rootElement = rootElement;
	}

	@Override
	public void newLevelLoaded(IMapController mapController) {
		final String title = mapController.getTitle();
		final String subTitle = mapController.getSubtitle();

		final GLabel titleElement = new GLabel(title);
		final GLabel subtitleElement = new GLabel(subTitle);

		titleElement.addEffect(new RemoveElementDelay(5000));
		subtitleElement.addEffect(new RemoveElementDelay(4000));

		this.rootElement.addChild(titleElement);
		this.rootElement.addChild(subtitleElement);
	}

}
