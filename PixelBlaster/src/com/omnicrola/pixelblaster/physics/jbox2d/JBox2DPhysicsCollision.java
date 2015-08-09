package com.omnicrola.pixelblaster.physics.jbox2d;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.physics.IPhysicsCollision;

public class JBox2DPhysicsCollision implements IPhysicsCollision {
	private Body primaryBody;
	private Body secondaryBody;

	public JBox2DPhysicsCollision() {
	}

	public void set(Body primaryBody, Body secondaryBody) {
		this.primaryBody = primaryBody;
		this.secondaryBody = secondaryBody;
	}

	@Override
	public Vector2f getImpactVector() {
		final Vec2 primaryVelocity = this.primaryBody.getLinearVelocity();
		final Vec2 secondaryVelocity = this.secondaryBody.getLinearVelocity();
		final Vec2 impactVelocity = primaryVelocity.sub(secondaryVelocity);
		return new Vector2f(impactVelocity.x, impactVelocity.y);
	}
}
