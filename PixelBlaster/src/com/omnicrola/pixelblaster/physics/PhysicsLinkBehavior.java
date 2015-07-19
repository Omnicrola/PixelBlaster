package com.omnicrola.pixelblaster.physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.IUpdateBehavior;

public class PhysicsLinkBehavior implements IUpdateBehavior {

	private final Body body;

	public PhysicsLinkBehavior(Body body) {
		this.body = body;
	}

	@Override
	public void update(IGameEntity entity, float delta) {
		final Vec2 position = this.body.getPosition();
		final float angle = this.body.getAngle();

		entity.setPosition(new Vector2f(position.x, position.y));
		entity.setRotation(angle);
	}

}
