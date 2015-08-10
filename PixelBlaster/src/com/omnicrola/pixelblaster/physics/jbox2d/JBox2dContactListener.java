package com.omnicrola.pixelblaster.physics.jbox2d;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.contacts.Contact;

import com.omnicrola.pixelblaster.physics.contact.CollisionIdentifier;
import com.omnicrola.pixelblaster.physics.contact.CollisionPair;
import com.omnicrola.pixelblaster.physics.contact.ICollisionDetector;

public class JBox2dContactListener implements ContactListener {

	private final List<ICollisionDetector> handlers;
	private final JBox2DPhysicsCollision physicsCollision;

	public JBox2dContactListener() {
		this.handlers = new ArrayList<>();
		this.physicsCollision = new JBox2DPhysicsCollision();
	}

	@Override
	public void beginContact(Contact contact) {
		final CollisionIdentifier id1 = (CollisionIdentifier) contact.getFixtureA().getUserData();
		final CollisionIdentifier id2 = (CollisionIdentifier) contact.getFixtureB().getUserData();
		final CollisionPair collisionPair = new CollisionPair(id1, id2);
		final Body bodyA = contact.getFixtureA().m_body;
		final Body bodyB = contact.getFixtureB().m_body;

		for (final ICollisionDetector contactHandler : this.handlers) {
			final CollisionPair targetPair = contactHandler.getCollisionPair();
			if (collisionPair.equals(targetPair)) {
				if (id1.equals(targetPair.getPrimary())) {
					this.physicsCollision.set(bodyA, bodyB);
				} else {
					this.physicsCollision.set(bodyB, bodyA);
				}
				contactHandler.collisionOccured(this.physicsCollision);
			}
		}
	}

	// public static void main(String[] args) {
	// final CollisionIdentifier id1 = new CollisionIdentifier();
	// final CollisionIdentifier id2 = new CollisionIdentifier();
	// final CollisionIdentifier id3 = new CollisionIdentifier();
	// System.out.println(id1);
	// System.out.println(id2);
	// System.out.println(id3);
	//
	// final CollisionPair pair1 = new CollisionPair(id1, id2);
	// final CollisionPair pair2 = new CollisionPair(id1, id1);
	// final CollisionPair pair3 = new CollisionPair(id1, id3);
	//
	// System.out.println("false " + pair1.hashCode() + "==" + pair2.hashCode()
	// + " " + pair1.equals(pair2));
	// System.out.println("false " + pair2.hashCode() + "==" + pair1.hashCode()
	// + " " + pair2.equals(pair1));
	// System.out.println("false " + pair1.hashCode() + "==" + pair3.hashCode()
	// + " " + pair1.equals(pair3));
	//
	// }

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
