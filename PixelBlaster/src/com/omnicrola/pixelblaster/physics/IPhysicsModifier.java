package com.omnicrola.pixelblaster.physics;

import com.omnicrola.pixelblaster.physics.contact.CollisionIdentifier;

public interface IPhysicsModifier {

	IPhysicsModifier addCircleShape(float radius, float x, float y);

	IPhysicsModifier collisionId(CollisionIdentifier id);

	IModifierToken modify();

	IPhysicsModifier density(float density);

	IPhysicsModifier friction(float friction);

}
