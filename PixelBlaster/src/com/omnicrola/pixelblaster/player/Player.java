package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.entity.MultiStateSprite;
import com.omnicrola.pixelblaster.physics.PhysicsWrapper;

public class Player extends GameEntity {

	private final MultiStateSprite multistateSprite;

	public Player(MultiStateSprite multistateSprite, PhysicsWrapper physicsWrapper) {
		super(multistateSprite, physicsWrapper);
		this.multistateSprite = multistateSprite;
	}

	public MultiStateSprite getMultistateSprite() {
		return this.multistateSprite;
	}

}
