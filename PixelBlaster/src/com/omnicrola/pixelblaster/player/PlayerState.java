package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.graphics.ISpriteState;

public enum PlayerState implements ISpriteState {
	//@formatter:off
	HIT(1),
	JUMP(2),
	DUCK(3),
	WALK(4),
	STAND(5);
	//@formatter:on

	private final int priority;

	private PlayerState(int priority) {
		this.priority = priority;
	}

	@Override
	public int priority() {
		return this.priority;
	}

}
