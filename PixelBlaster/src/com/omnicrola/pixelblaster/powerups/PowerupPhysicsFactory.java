package com.omnicrola.pixelblaster.powerups;

import com.omnicrola.pixelblaster.map.PowerupData;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;

public class PowerupPhysicsFactory {
	private final IPhysicsManager physicsManager;

	public PowerupPhysicsFactory(IPhysicsManager physicsManager) {
		this.physicsManager = physicsManager;
	}

	public IPhysicsEntity build(PowerupData powerupData) {
		//@formatter:off
		final IPhysicsEntity physicsEntity = this.physicsManager.getBuilder()
				.setStatic()
				.density(0)
				.friction(0)
				.build();
		//@formatter:on

		return physicsEntity;
	}

}
