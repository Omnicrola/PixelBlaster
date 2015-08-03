package com.omnicrola.pixelblaster.physics;

public interface IPhysicsSensor {

	public void identify(ISensorInspector inspector);

	public void collisionOccured();

	public CollisionPair getCollisionPair();
}
