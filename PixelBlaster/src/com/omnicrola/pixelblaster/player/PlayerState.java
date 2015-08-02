package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.graphics.ISpriteState;

public enum PlayerState implements ISpriteState {
	//@formatter:off
	HIT(1, 		0x001),
	JUMP(2, 	0x001),
	DUCK(3, 	0x001),
	WALK(4, 	0x001),
	STAND(5,	0x001),
	BUBBLE_NONE(6,	0x010),
	BUBBLE_BLUE(7,	0x010),
	BUBBLE_YELLOW(8,	0x010),
	BUBBLE_GREY(9,	0x010);
	//@formatter:on

	private final int priority;
	private final int mask;

	private PlayerState(int priority, int mask) {
		this.priority = priority;
		this.mask = mask;
	}

	@Override
	public int priority() {
		return this.priority;
	}

	@Override
	public int mask() {
		return this.mask;
	}

}
