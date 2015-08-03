package com.omnicrola.pixelblaster.powerups;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsContactHandler;
import com.omnicrola.pixelblaster.player.IPlayerManager;

public class BubbleEnergyPowerupContactHandler implements IPhysicsContactHandler {

	private final IPlayerManager playerManager;
	private final GameEntity gameEntity;

	public BubbleEnergyPowerupContactHandler(GameEntity gameEntity, IPlayerManager playerManager) {
		this.gameEntity = gameEntity;
		this.playerManager = playerManager;
	}

	@Override
	public void contactOccured() {
		this.playerManager.getPlayerController().increaseBubblePower(1.0f);
		this.gameEntity.kill();
	}

}
