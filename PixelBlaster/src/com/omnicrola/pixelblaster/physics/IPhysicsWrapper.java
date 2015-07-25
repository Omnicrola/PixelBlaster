package com.omnicrola.pixelblaster.physics;


public interface IPhysicsWrapper {

	public void destroyEntity(IPhysicsEntity body);

	public IPhysicsEntity createBody(PhysicsDefinition physicsDefinition);

}
