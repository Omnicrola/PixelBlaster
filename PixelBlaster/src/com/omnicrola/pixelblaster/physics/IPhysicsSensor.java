package com.omnicrola.pixelblaster.physics;

import com.omnicrola.pixelblaster.physics.contact.CollisionPair;

public interface IPhysicsSensor {

	public void identify(ISensorInspector inspector);

	public void collisionOccured(IPhysicsCollision physicsCollision);

	public CollisionPair getCollisionPair();
}
