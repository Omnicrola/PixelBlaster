package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.util.AssetManager;

public class UserInterfaceBuilder {

	private static final String UI_PATH = "sprites/ui/";

	public GuiRoot build(IGameContext context) {
		final AssetManager assetManager = context.getAssetManager();
		final Image fullIcon = assetManager.getImage(UI_PATH + "squareBlue.png");
		final Image emptyIcon = assetManager.getImage(UI_PATH + "squareWhite.png");
		final BubbleMeter bubbleMeter = new BubbleMeter(fullIcon, emptyIcon);
		bubbleMeter.setPosition(10, 10);
		return new GuiRoot(bubbleMeter);
	}

}
