package com.omnicrola.pixelblaster.gui;

import com.omnicrola.pixelblaster.player.IPlayerManager;

public class GuiController {
	private final IPlayerManager playerManager;

	public GuiController(IPlayerManager playerManager) {
		this.playerManager = playerManager;
	}

	public void update(IUserInterface userInterface) {
		updateBubbleMeter(userInterface);
		updateScore(userInterface);
	}

	private void updateScore(IUserInterface userInterface) {
		final int score = this.playerManager.getPlayerController().getScore();
		userInterface.setScore(score);
	}

	private void updateBubbleMeter(IUserInterface userInterface) {
		final float bubblePower = this.playerManager.getPlayerController().getBubblePower();
		final float maxBubblePower = this.playerManager.getPlayerController().getMaxBubblePower();
		userInterface.setBubbleMeter(bubblePower / maxBubblePower);
	}

}
