package com.omnicrola.pixelblaster.physics.jbox2d;

import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.physics.ICollisionDetector;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;

public class JBox2dPhysicsBody implements IPhysicsEntity {

	private final Body body;
	private final Vec2 vectorCache;
	private final List<Fixture> fixtures;
	private final List<JBox2dPhysicsSensor> sensors;
	private final JBox2dContactListener contactListener;

	public JBox2dPhysicsBody(JBox2dContactListener contactHandler, Body body, List<Fixture> fixtures,
			List<JBox2dPhysicsSensor> sensors) {
		this.contactListener = contactHandler;
		this.body = body;
		this.fixtures = fixtures;
		this.sensors = sensors;
		this.vectorCache = new Vec2();
	}

	@Override
	public void applyForceAtCenter(Vector2f force) {
		this.vectorCache.set(force.x, force.y);
		this.body.applyForce(this.vectorCache, this.body.getWorldCenter());
	}

	@Override
	public void applyImpulseAtCenter(Vector2f force) {
		this.vectorCache.set(force.x, force.y);
		this.body.applyLinearImpulse(this.vectorCache, this.body.getWorldCenter());
	}

	@Override
	public Vector2f getLinearVelocity() {
		final Vec2 vel = this.body.getLinearVelocity();
		return new Vector2f(vel.x, vel.y);
	}

	@Override
	public void setLinearVelocity(Vector2f velocity) {
		this.vectorCache.set(velocity.x, velocity.y);
		this.body.setLinearVelocity(this.vectorCache);
	}

	@Override
	public void setPosition(Vector2f vector) {
		this.vectorCache.set(vector.x, vector.y);
		this.body.setTransform(this.vectorCache, this.body.getAngle());
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

	@Override
	public void addCollisionDetector(ICollisionDetector collisionDetector) {
		this.contactListener.addHandler(collisionDetector);
	}
}
