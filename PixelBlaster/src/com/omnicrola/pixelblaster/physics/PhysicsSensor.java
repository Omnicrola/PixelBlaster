package com.omnicrola.pixelblaster.physics;

import java.util.ArrayList;
import java.util.List;

public abstract class PhysicsSensor implements IPhysicsSensor {

	protected final CollisionIdentifier targetId;
	private final List<IPhysicsContactHandler> contacthandlers;

	public PhysicsSensor(CollisionIdentifier targetId) {
		this.targetId = targetId;
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
	public CollisionIdentifier getTarget() {
		return this.targetId;
	}
}
