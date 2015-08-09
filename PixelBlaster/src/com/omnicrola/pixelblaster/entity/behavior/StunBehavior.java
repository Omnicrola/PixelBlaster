package com.omnicrola.pixelblaster.entity.behavior;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.IUpdateBehavior;

public class StunBehavior implements IUpdateBehavior {

	private final int stunTime;
	private final long startTime;

	public StunBehavior(int stunTime) {
		this.stunTime = stunTime;
		this.startTime = System.currentTimeMillis();
	}

	@Override
	public void update(IGameEntity entity, float delta) {
		final long elapsed = System.currentTimeMillis() - this.startTime;
		if (elapsed <= this.stunTime) {
			entity.setVelocity(new Vector2f());
		} else {
			entity.removeUpdateBehavior(this);
		}
	}

}
