package com.omnicrola.pixelblaster.physics;

public interface IPhysicsManager {

	void destroyPhysics(IEntityPhysics physics);

	IPhysicsEntity createPhysics(PhysicsDefinition physicsDefinition);

}
