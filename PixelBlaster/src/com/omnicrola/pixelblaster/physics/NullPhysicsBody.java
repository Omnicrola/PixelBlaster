package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

public class NullPhysicsBody implements IPhysicsEntity {
	public static NullPhysicsBody NULL = new NullPhysicsBody();

	private NullPhysicsBody() {
	}

	@Override
	public void applyForceAtCenter(Vector2f force) {
	}

	@Override
	public Vector2f getPosition() {
		return new Vector2f();
	}

	@Override
	public float getAngle() {
		return 0;
	}

	@Override
	public void applyImpulseAtCenter(Vector2f forceVector) {
	}

	@Override
	public Vector2f getLinearVelocity() {
		return new Vector2f();
	}

	@Override
	public void setLinearVelocity(Vector2f velocity) {
	}

	@Override
	public void setPosition(Vector2f vector) {
	}

	@Override
	public void addCollisionDetector(ICollisionDetector collisionDetector) {
	}
}
