package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.graphics.ISpriteState;

public enum PlayerState implements ISpriteState {
	//@formatter:off
	HIT(1, 		1),
	JUMP(2, 	1),
	DUCK(3, 	1),
	WALK(4, 	1),
	STAND(5,	1),
	BUBBLE_NONE(-1,	2),
	BUBBLE_BLUE(-1,	2),
	BUBBLE_YELLOW(-1,	2),
	BUBBLE_GREY(-1,	2);
	//@formatter:on

	private final int priority;
	private final int group;

	private PlayerState(int priority, int group) {
		this.priority = priority;
		this.group = group;
	}

	@Override
	public int priority() {
		return this.priority;
	}

	@Override
	public int group() {
		return this.group;
	}

}
