package com.omnicrola.pixelblaster.physics;

public interface IPhysicsManager {

	void destroyPhysics(IPhysicsEntity physics);

	IPhysicsEntity createPhysics(PhysicsDefinition physicsDefinition);

}
