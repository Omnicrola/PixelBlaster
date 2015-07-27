package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public interface IPhysicsEntity {
	public void applyForceAtCenter(Vector2f force);

	public Vector2f getPosition();

	public float getAngle();

	public void applyImpulseAtCenter(Vector2f forceVector);

	public Vector2f getLinearVelocity();

	public void setLinearVelocity(Vector2f velocity);

	public void setPosition(Vector2f vector);

	public void addCollisionDetector(ICollisionDetector collisionDetector);

	public void updateEntity(IGameEntity gameEntity, float delta);

	public void destroy(IPhysicsWrapper physicsWrapper);

	public void setMaximumVelocity(float playerMaximumVelocity);

}
