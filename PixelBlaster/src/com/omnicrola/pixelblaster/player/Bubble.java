package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;

public class Bubble extends GameEntity {

	private final MultiStateSprite multiStateSprite;

	public Bubble(MultiStateSprite sprite, IPhysicsEntity physics) {
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
