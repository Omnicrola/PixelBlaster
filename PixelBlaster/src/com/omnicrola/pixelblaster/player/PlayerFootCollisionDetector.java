package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.physics.ICollisionDetector;

public class PlayerFootCollisionDetector implements ICollisionDetector {

	private final int sensorId;
	private final PlayerController playerController;

	public PlayerFootCollisionDetector(int sensorId, PlayerController playerController) {
		this.sensorId = sensorId;
		this.playerController = playerController;
	}

	@Override
	public int getSensorId() {
		return this.sensorId;
	}

	@Override
	public void collisionOccured(int otherFixtureId) {
		this.playerController.clearJump();
	}
}
