package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.entity.MultiStateSprite;
import com.omnicrola.pixelblaster.physics.PhysicsWrapper;

public class Player extends GameEntity {

	private final MultiStateSprite multistateSprite;
	private boolean isInMidAir;
	private boolean hasDoubleJumped;

	public Player(MultiStateSprite multistateSprite, PhysicsWrapper physicsWrapper) {
		super(multistateSprite, physicsWrapper);
		this.multistateSprite = multistateSprite;
	}

	public MultiStateSprite getMultistateSprite() {
		return this.multistateSprite;
	}

	public boolean isInMidAir() {
		return this.isInMidAir;
	}

	public void setInMidAir(boolean isInMidAir) {
		this.isInMidAir = isInMidAir;
	}

	public boolean hasDoubleJumped() {
		return this.hasDoubleJumped;
	}

	public void setHasDoubleJumped(boolean hasDoubleJumped) {
		this.hasDoubleJumped = hasDoubleJumped;
	}

}
