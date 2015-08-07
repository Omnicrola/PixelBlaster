package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Font;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.gui.fx.CenterHorizontal;
import com.omnicrola.pixelblaster.gui.fx.FadeTextEffect;
import com.omnicrola.pixelblaster.map.ILevelObserver;
import com.omnicrola.pixelblaster.map.IMapController;

public class DisplayLevelTitleObserver implements ILevelObserver {

	private final IUserInterface rootElement;
	private final IGraphicsWrapper graphicsWrapper;
	private final Font titleFont;
	private final Font subtitleFont;

	public DisplayLevelTitleObserver(IUserInterface rootElement, IGraphicsWrapper graphicsWrapper) {
		this.rootElement = rootElement;
		this.graphicsWrapper = graphicsWrapper;
		this.titleFont = FontRepository.get(FontResource.KEN_VECTOR_FUTURE_THIN, 48);
		this.subtitleFont = FontRepository.get(FontResource.KEN_VECTOR_FUTURE_THIN, 32);
	}

	@Override
	public void newLevelLoaded(IMapController mapController) {
		final String title = mapController.getTitle();
		final String subTitle = mapController.getSubtitle();

		final GLabel titleElement = new GLabel(title);
		final GLabel subtitleElement = new GLabel(subTitle);
		titleElement.setFont(this.titleFont);
		subtitleElement.setFont(this.subtitleFont);

		titleElement.setShadowed(true);
		subtitleElement.setShadowed(true);

		titleElement.addEffect(new RemoveElementDelay(5000));
		subtitleElement.addEffect(new RemoveElementDelay(4000));
		titleElement.addEffect(new FadeTextEffect(titleElement, 4000, 250));
		subtitleElement.addEffect(new FadeTextEffect(subtitleElement, 3000, 250));
		titleElement.addEffect(new CenterHorizontal(-20, this.graphicsWrapper));
		subtitleElement.addEffect(new CenterHorizontal(20, this.graphicsWrapper));

		this.rootElement.addChild(titleElement);
		this.rootElement.addChild(subtitleElement);
	}

}
