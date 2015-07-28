package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;

public class MultiStateEntity extends GameEntity {

	private final MultiStateSprite multistateSprite;

	public MultiStateEntity(MultiStateSprite multistateSprite, IPhysicsEntity physics) {
		super(multistateSprite, physics);
		this.multistateSprite = multistateSprite;
	}

	public MultiStateSprite getMultistateSprite() {
		return this.multistateSprite;
	}

}
