package com.omnicrola.pixelblaster.physics.jbox2d;

import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.physics.IPhysicsBody;

public class JBox2dPhysicsBody implements IPhysicsBody {

	private final Body body;
	private final Vec2 forceVector;
	private final List<Fixture> fixtures;

	public JBox2dPhysicsBody(Body body, List<Fixture> fixtures) {
		this.body = body;
		this.fixtures = fixtures;
		this.forceVector = new Vec2();
	}

	@Override
	public void applyForceAtCenter(Vector2f force) {
		this.forceVector.set(force.x, force.y);
		this.body.applyForce(this.forceVector, this.body.getWorldCenter());
	}

	@Override
	public void applyImpulseAtCenter(Vector2f force) {
		this.forceVector.set(force.x, force.y);
		this.body.applyLinearImpulse(this.forceVector, this.body.getWorldCenter());
	}

	@Override
	public Vector2f getLinearVelocity() {
		final Vec2 vel = this.body.getLinearVelocity();
		return new Vector2f(vel.x, vel.y);
	}

	@Override
	public void setLinearVelocity(Vector2f velocity) {
		this.forceVector.set(velocity.x, velocity.y);
		this.body.setLinearVelocity(this.forceVector);
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
