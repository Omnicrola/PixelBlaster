package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.physics.IPhysicsContactHandler;

public class ClearPlayerJumpContactHandler implements IPhysicsContactHandler {

	private final PlayerController playerController;

	public ClearPlayerJumpContactHandler(PlayerController playerController) {
		this.playerController = playerController;
	}

	@Override
	public void contactOccured() {
		this.playerController.clearJump();
	}

}
