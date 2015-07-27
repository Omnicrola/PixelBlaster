package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;

public class Bubble extends GameEntity {

	private final MultiStateSprite multiStateSprite;
	private boolean isOn;

	public Bubble(MultiStateSprite sprite, IPhysicsEntity physics) {
		super(sprite, physics);
		this.multiStateSprite = sprite;
		this.isOn = false;
	}

	public void toggle() {
		this.isOn = !this.isOn;
		final BubbleState state = this.isOn ? BubbleState.GREY : BubbleState.NONE;
		this.multiStateSprite.setState(state);
	}

}
