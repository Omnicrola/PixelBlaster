package com.omnicrola.pixelblaster.entity.behavior;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.IUpdateBehavior;

public class DampenVelocityBehavior implements IUpdateBehavior {
	private final float multiplier;

	public DampenVelocityBehavior(float multiplier) {
		this.multiplier = multiplier;
	}

	@Override
	public void update(IGameEntity entity, float delta) {
		final Vector2f velocity = entity.getVelocity();
		velocity.scale(this.multiplier);
		entity.setVelocity(velocity);

	}

}
