package com.omnicrola.pixelblaster.physics.contact;

import com.omnicrola.pixelblaster.physics.IPhysicsCollision;

public interface ICollisionDetector {

	public abstract void collisionOccured(IPhysicsCollision physicsCollision);

	public abstract CollisionPair getCollisionPair();

}
