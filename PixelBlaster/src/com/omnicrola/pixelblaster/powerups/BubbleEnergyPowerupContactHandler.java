package com.omnicrola.pixelblaster.powerups;

import com.omnicrola.pixelblaster.audio.AudioController;
import com.omnicrola.pixelblaster.audio.AudioFx;
import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsContactHandler;
import com.omnicrola.pixelblaster.player.IPlayerManager;

public class BubbleEnergyPowerupContactHandler implements IPhysicsContactHandler {

	private final IPlayerManager playerManager;
	private final GameEntity gameEntity;
	private final AudioController audioController;

	public BubbleEnergyPowerupContactHandler(GameEntity gameEntity, IPlayerManager playerManager,
			AudioController audioController) {
		this.gameEntity = gameEntity;
		this.playerManager = playerManager;
		this.audioController = audioController;
	}

	@Override
	public void contactOccured() {
		if (this.gameEntity.isAlive()) {
			this.playerManager.getPlayerController().increaseBubblePower(1.0f);
			this.gameEntity.kill();
			this.audioController.playSound(AudioFx.SPLASH, 0.25f);
		}
	}

}
