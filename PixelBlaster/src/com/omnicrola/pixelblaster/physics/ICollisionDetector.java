package com.omnicrola.pixelblaster.physics;

public interface ICollisionDetector {

	public abstract CollisionIdentifier getTarget();

	public abstract void collisionOccured();

}
