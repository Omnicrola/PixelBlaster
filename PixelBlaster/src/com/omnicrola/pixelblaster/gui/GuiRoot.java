package com.omnicrola.pixelblaster.gui;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.player.IPlayerManager;
import com.omnicrola.pixelblaster.player.PlayerController;

public class GuiRoot {
	private final BubbleMeter bubbleMeter;

	public GuiRoot(BubbleMeter bubbleMeter) {
		this.bubbleMeter = bubbleMeter;
	}

	public void update(IGameContext gameContext) {
		final PlayerController playerModel = gameContext.getSubsystem(IPlayerManager.class).getPlayerController();
		final float power = playerModel.getBubblePower();
		final float maxPower = playerModel.getMaxBubblePower();

		this.bubbleMeter.setPercentageFull(power / maxPower);

	}

	public void render(IGraphicsWrapper guiGraphics) {
		this.bubbleMeter.render(guiGraphics, 0, 0);

	}

}
