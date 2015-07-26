package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public class NullPhysics implements IEntityPhysics {

	public static final NullPhysics NULL = new NullPhysics();

	private NullPhysics() {
	}

	@Override
	public void destroy(IPhysicsWrapper physics) {
	}

	@Override
	public void setMaximumVelocity(float maximumVelocity) {
	}

	@Override
	public void setPosition(Vector2f position) {
	}

	@Override
	public void update(IGameEntity gameEntity, float delta) {
	}

	@Override
	public void moveRight(float force) {
	}

	@Override
	public void moveLeft(float force) {
	}

	@Override
	public void moveUp(float force) {
	}

	@Override
	public void moveDown(float force) {
	}

	@Override
	public void jump(float force) {
	}

}
