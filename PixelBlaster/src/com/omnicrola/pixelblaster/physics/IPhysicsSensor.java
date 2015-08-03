package com.omnicrola.pixelblaster.physics;

public interface IPhysicsSensor {

	public void identify(ISensorInspector inspector);

	public CollisionIdentifier getTarget();

	public void collisionOccured();
}
