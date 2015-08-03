package com.omnicrola.pixelblaster.physics;

import java.util.ArrayList;
import java.util.List;

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
	public void collisionOccured() {
		for (final IPhysicsContactHandler contactHandler : this.contacthandlers) {
			contactHandler.contactOccured();
		}
	}

	@Override
	public CollisionPair getCollisionPair() {
		return this.collisionPair;
	}
}
