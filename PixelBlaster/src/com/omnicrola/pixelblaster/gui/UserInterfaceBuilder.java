package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.util.AssetManager;

public class UserInterfaceBuilder {

	private static final String UI_PATH = "sprites/ui/";

	public IUserInterface build(IGameContext context) {
		final AssetManager assetManager = context.getAssetManager();
		final BubbleMeter bubbleMeter = buildBubbleMeter(assetManager);
		final GLabel scoreLabel = buildScoreLabel();
		return new GuiRoot(bubbleMeter, scoreLabel);
	}

	private BubbleMeter buildBubbleMeter(final AssetManager assetManager) {
		final Image fullIcon = assetManager.getImage(UI_PATH + "squareBlue.png");
		final Image emptyIcon = assetManager.getImage(UI_PATH + "squareWhite.png");
		final BubbleMeter bubbleMeter = new BubbleMeter(fullIcon, emptyIcon);
		bubbleMeter.setPosition(10, 10);
		return bubbleMeter;
	}

	private GLabel buildScoreLabel() {
		final GLabel scoreLabel = new GLabel("Score:");
		scoreLabel.setShadowed(true);
		scoreLabel.setPosition(10, 100);
		return scoreLabel;
	}
}
