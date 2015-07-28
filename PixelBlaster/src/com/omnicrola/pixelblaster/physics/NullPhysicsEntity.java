package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public class NullPhysicsEntity implements IPhysicsEntity {
	public static NullPhysicsEntity NULL = new NullPhysicsEntity();

	private NullPhysicsEntity() {
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

	@Override
	public void updateEntity(IGameEntity gameEntity, float delta) {
	}

	@Override
	public void destroy(IPhysicsWrapper physicsWrapper) {
	}

	@Override
	public void setMaximumVelocity(float playerMaximumVelocity) {
	}

	@Override
	public void disable() {
	}

	@Override
	public void enable() {
	}

}
