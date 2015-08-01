package com.omnicrola.pixelblaster.physics;

public interface IPhysicsManager {

	IPhysicsBuilder getBuilder();

	IPhysicsModifier modifyEntity(IPhysicsEntity physicsEntity);

}
