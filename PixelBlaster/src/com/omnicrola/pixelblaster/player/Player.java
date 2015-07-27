package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;

public class Player extends GameEntity {

	private final MultiStateSprite multistateSprite;
	private boolean isInMidAir;
	private boolean hasDoubleJumped;
	private final Bubble bubble;

	public Player(Bubble bubble, MultiStateSprite multistateSprite, IPhysicsEntity physics) {
		super(multistateSprite, physics);
		this.bubble = bubble;
		this.multistateSprite = multistateSprite;
	}

	public MultiStateSprite getMultistateSprite() {
		return this.multistateSprite;
	}

	public Bubble getBubble() {
		return this.bubble;
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
