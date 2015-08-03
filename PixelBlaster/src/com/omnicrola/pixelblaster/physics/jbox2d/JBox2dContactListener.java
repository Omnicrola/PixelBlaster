package com.omnicrola.pixelblaster.physics.jbox2d;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.contacts.Contact;

import com.omnicrola.pixelblaster.physics.CollisionIdentifier;
import com.omnicrola.pixelblaster.physics.CollisionPair;
import com.omnicrola.pixelblaster.physics.ICollisionDetector;

public class JBox2dContactListener implements ContactListener {

	private final List<ICollisionDetector> handlers;

	public JBox2dContactListener() {
		this.handlers = new ArrayList<>();
	}

	@Override
	public void beginContact(Contact contact) {
		final CollisionIdentifier id1 = (CollisionIdentifier) contact.getFixtureA().getUserData();
		final CollisionIdentifier id2 = (CollisionIdentifier) contact.getFixtureB().getUserData();
		final CollisionPair collisionPair = new CollisionPair(id1, id2);
		for (final ICollisionDetector contactHandler : this.handlers) {
			final CollisionPair targetPair = contactHandler.getCollisionPair();
			if (collisionPair.equals(targetPair)) {
				contactHandler.collisionOccured();
			}
		}
	}

	@Override
	public void endContact(Contact contact) {
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
	}

	public void addHandler(ICollisionDetector collisionDetector) {
		this.handlers.add(collisionDetector);
	}

}
