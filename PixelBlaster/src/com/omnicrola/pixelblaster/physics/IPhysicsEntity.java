package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

public interface IPhysicsEntity {
	public void applyForceAtCenter(Vector2f force);

	public Vector2f getPosition();

	public float getAngle();

	public void applyImpulseAtCenter(Vector2f forceVector);

	public Vector2f getLinearVelocity();

	public void setLinearVelocity(Vector2f velocity);

	public void setPosition(Vector2f vector);

	public void addCollisionDetector(ICollisionDetector collisionDetector);
}
