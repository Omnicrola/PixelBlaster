package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.physics.IEntityPhysics;

public class Bubble extends GameEntity {

	private final MultiStateSprite multiStateSprite;

	public Bubble(MultiStateSprite sprite, IEntityPhysics physics) {
		super(sprite, physics);
		this.multiStateSprite = sprite;
	}

	public void turnOff() {
		this.multiStateSprite.clearStates();
		this.multiStateSprite.setState(BubbleState.NONE);
	}

	public void turnOn(BubbleState state) {
		this.multiStateSprite.clearStates();
		this.multiStateSprite.setState(state);
	}

}
