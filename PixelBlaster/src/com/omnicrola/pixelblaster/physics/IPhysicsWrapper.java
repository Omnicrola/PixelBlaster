package com.omnicrola.pixelblaster.physics;


public interface IPhysicsWrapper {

	public void destroyBody(IPhysicsBody body);

	public IPhysicsBody createBody(PhysicsDefinition physicsDefinition);

}
