package com.omnicrola.pixelblaster.physics.jbox2d;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.physics.IPhysicsBody;

public class JBox2dPhysicsBody implements IPhysicsBody {

	private final Body body;

	public JBox2dPhysicsBody(Body body) {
		this.body = body;
	}

	@Override
	public void applyForceAtCenter(Vector2f force) {
		this.body.applyForce(new Vec2(force.x, force.y), this.body.getWorldCenter());
	}

	@Override
	public Vector2f getPosition() {
		final Vec2 position = this.body.getPosition();
		return new Vector2f(position.x, position.y);
	}

	@Override
	public float getAngle() {
		return this.body.getAngle();
	}

}
