package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.physics.ICollisionDetector;

public class PlayerFootCollisionDetector implements ICollisionDetector {

	private final int sensorId;
	private final Player player;

	public PlayerFootCollisionDetector(int sensorId, Player player) {
		this.sensorId = sensorId;
		this.player = player;
	}

	@Override
	public int getSensorId() {
		return this.sensorId;
	}

	@Override
	public void collisionOccured(int otherFixtureId) {
		this.player.setInMidAir(false);
		this.player.setHasDoubleJumped(false);
		this.player.getMultistateSprite().removeState(PlayerState.JUMP);
	}
}
