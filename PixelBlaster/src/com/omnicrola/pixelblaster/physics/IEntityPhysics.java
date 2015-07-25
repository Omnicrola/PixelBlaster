package com.omnicrola.pixelblaster.physics;

public interface IEntityPhysics {

	void destroy(IPhysicsWrapper physics);

	public abstract void setMaximumVelocity(float maximumVelocity);

}