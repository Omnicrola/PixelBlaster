package com.omnicrola.pixelblaster.entity.behavior;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.IUpdateBehavior;

public class DelayedAlternateBehaviorSwitch implements IUpdateBehavior {

	private final BinaryBehaviorController binaryBehaviorController;
	private final int delay;
	private final long startTime;

	public DelayedAlternateBehaviorSwitch(BinaryBehaviorController binaryBehaviorController, int delay) {
		this.binaryBehaviorController = binaryBehaviorController;
		this.delay = delay;
		this.startTime = System.currentTimeMillis();
	}

	@Override
	public void update(IGameEntity entity, float delta) {
		final long elapsed = System.currentTimeMillis() - this.startTime;
		if (elapsed >= this.delay) {
			entity.removeUpdateBehavior(this);
			this.binaryBehaviorController.useAlternateBehaviors();
		}

	}
}
