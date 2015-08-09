package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.physics.IPhysicsCollision;
import com.omnicrola.pixelblaster.physics.contact.IPhysicsContactHandler;

public class ClearPlayerJumpContactHandler implements IPhysicsContactHandler {

	private final PlayerController playerController;

	public ClearPlayerJumpContactHandler(PlayerController playerController) {
		this.playerController = playerController;
	}

	@Override
	public void contactOccured(IPhysicsCollision physicsCollision) {
		this.playerController.clearJump();
	}

}
