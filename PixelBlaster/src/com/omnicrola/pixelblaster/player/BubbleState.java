package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.graphics.ISpriteState;

public enum BubbleState implements ISpriteState {
	//@formatter:off
	NONE(2),
	BLACK(1),
	BLUE(1),
	GREY(1),
	YELLOW(1);
	//@formatter:on
	private final int priority;

	private BubbleState(int priority) {
		this.priority = priority;
	}

	@Override
	public int priority() {
		return this.priority;
	}

}
