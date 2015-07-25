package com.omnicrola.pixelblaster.physics;


public interface ICollisionDetector {

	public abstract int getSensorId();

	public abstract void collisionOccured(int otherFixtureId);

}
