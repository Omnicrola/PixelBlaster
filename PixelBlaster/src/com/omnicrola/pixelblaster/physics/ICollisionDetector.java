package com.omnicrola.pixelblaster.physics;

public interface ICollisionDetector {

	public abstract void collisionOccured();

	public abstract CollisionPair getCollisionPair();

}
