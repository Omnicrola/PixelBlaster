package com.omnicrola.pixelblaster.gui;

import java.util.Arrays;
import java.util.List;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.player.IPlayerManager;
import com.omnicrola.pixelblaster.player.PlayerController;

public class GuiRoot {
	private final BubbleMeter bubbleMeter;
	private final GLabel scoreLabel;
	private final List<ScreenElement> screenElements;

	public GuiRoot(BubbleMeter bubbleMeter, GLabel scoreLabel) {
		this.bubbleMeter = bubbleMeter;
		this.scoreLabel = scoreLabel;
		this.screenElements = Arrays.asList(bubbleMeter, scoreLabel);
	}

	public void update(IGameContext gameContext) {
		updateBubbleMeter(gameContext);
		updateScoreMeter();
	}

	private void updateScoreMeter() {
		final int newScore = 100;
		this.scoreLabel.setText("Score: " + newScore);
	}

	private void updateBubbleMeter(IGameContext gameContext) {
		final PlayerController playerModel = gameContext.getSubsystem(IPlayerManager.class).getPlayerController();
		final float power = playerModel.getBubblePower();
		final float maxPower = playerModel.getMaxBubblePower();

		this.bubbleMeter.setPercentageFull(power / maxPower);
	}

	public void render(IGraphicsWrapper guiGraphics) {
		for (final ScreenElement screenElement : this.screenElements) {
			screenElement.render(guiGraphics, 0, 0);
		}

	}

}
