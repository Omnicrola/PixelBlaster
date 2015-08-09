package com.omnicrola.pixelblaster.physics;

import java.util.ArrayList;
import java.util.List;

import com.omnicrola.pixelblaster.physics.contact.CollisionPair;
import com.omnicrola.pixelblaster.physics.contact.IPhysicsContactHandler;

public abstract class PhysicsSensor implements IPhysicsSensor {

	private final List<IPhysicsContactHandler> contacthandlers;
	private final CollisionPair collisionPair;

	public PhysicsSensor(CollisionPair collisionPair) {
		this.collisionPair = collisionPair;
		this.contacthandlers = new ArrayList<>();
	}

	public void addContactHandler(IPhysicsContactHandler contactHandler) {
		this.contacthandlers.add(contactHandler);
	}

	@Override
	public void collisionOccured(IPhysicsCollision physicsCollision) {
		for (final IPhysicsContactHandler contactHandler : this.contacthandlers) {
			contactHandler.contactOccured(physicsCollision);
		}
	}

	@Override
	public CollisionPair getCollisionPair() {
		return this.collisionPair;
	}
}
