package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public class PhysicsWrapper implements IEntityPhysics {

	private IPhysicsEntity physicsBody;
	private final Vector2f cacheVector;
	private float maximumVelocity;

	public PhysicsWrapper(IPhysicsEntity physicsBody) {
		this.physicsBody = physicsBody;
		this.cacheVector = new Vector2f();
		this.maximumVelocity = 1.0f;
	}

	@Override
	public void setMaximumVelocity(float maximumVelocity) {
		this.maximumVelocity = maximumVelocity;
	}

	public void update(IGameEntity gameEntity, float delta) {
		limitLinearVelocity();
		updatePosition(gameEntity);
		updateAngle(gameEntity);
	}

	private void limitLinearVelocity() {
		final Vector2f velocity = this.physicsBody.getLinearVelocity();
		final float actualSpeed = velocity.length();
		if (actualSpeed > this.maximumVelocity) {
			velocity.scale(this.maximumVelocity / actualSpeed);
			this.physicsBody.setLinearVelocity(velocity);
		}
	}

	private void updateAngle(IGameEntity gameEntity) {
		final float angle = this.physicsBody.getAngle();
		gameEntity.setRotation(angle);
	}

	private void updatePosition(IGameEntity gameEntity) {
		final Vector2f position = this.physicsBody.getPosition();
		gameEntity.setPosition(new Vector2f(position.x, position.y));
	}

	@Override
	public void destroy(IPhysicsWrapper physics) {
		physics.destroyEntity(this.physicsBody);
		this.physicsBody = null;
	}

	public void moveLeft(float force) {
		applyForce(-force, 0);
	}

	public void moveRight(float force) {
		applyForce(force, 0);
	}

	public void moveUp(float force) {
		applyForce(0, -force);
	}

	public void moveDown(float force) {
		applyForce(0, force);
	}

	public void jump(float force) {
		applyImpulse(0, -force);
	}

	private void applyImpulse(float forceX, float forceY) {
		this.cacheVector.set(forceX, forceY);
		this.physicsBody.applyImpulseAtCenter(this.cacheVector);
	}

	private void applyForce(float forceX, float forceY) {
		this.cacheVector.set(forceX, forceY);
		this.physicsBody.applyForceAtCenter(this.cacheVector);
	}

	public void setPosition(Vector2f position) {
		this.cacheVector.set(position.x, position.y);
		this.physicsBody.setPosition(this.cacheVector);
	}

}
