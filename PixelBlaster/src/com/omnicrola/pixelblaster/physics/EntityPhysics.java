package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public class EntityPhysics implements IEntityPhysics {

	private final PhysicsDefinition physicsDefinition;
	protected IPhysicsBody physicsBody;
	private final Vector2f forceVector;

	public EntityPhysics(PhysicsDefinition physicsDefinition) {
		this.physicsDefinition = physicsDefinition;
		this.forceVector = new Vector2f();
	}

	public void update(IGameEntity gameEntity, float delta) {
		limitLinearVelocity();
		updatePosition(gameEntity);
		updateAngle(gameEntity);
	}

	private void limitLinearVelocity() {
		final Vector2f velocity = this.physicsBody.getLinearVelocity();
		final float maximumVelocity = this.physicsDefinition.getMaxVelocity();
		final float actualSpeed = velocity.length();
		if (actualSpeed > maximumVelocity) {
			velocity.scale(maximumVelocity / actualSpeed);
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
	public void create(IPhysicsWrapper physics) {
		this.physicsBody = physics.createBody(this.physicsDefinition);
	}

	@Override
	public void destroy(IPhysicsWrapper physics) {
		physics.destroyBody(this.physicsBody);
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
		this.forceVector.set(forceX, forceY);
		this.physicsBody.applyImpulseAtCenter(this.forceVector);
	}

	private void applyForce(float forceX, float forceY) {
		this.forceVector.set(forceX, forceY);
		this.physicsBody.applyForceAtCenter(this.forceVector);
	}

}
