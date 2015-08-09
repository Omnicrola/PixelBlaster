package com.omnicrola.pixelblaster.physics.jbox2d;

import com.omnicrola.pixelblaster.physics.IPhysicsCollision;
import com.omnicrola.pixelblaster.physics.IPhysicsSensor;
import com.omnicrola.pixelblaster.physics.contact.CollisionPair;
import com.omnicrola.pixelblaster.physics.contact.ICollisionDetector;

public class JBox2DSensorHandler implements ICollisionDetector {

	private final IPhysicsSensor sensor;

	public JBox2DSensorHandler(IPhysicsSensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public CollisionPair getCollisionPair() {
		return this.sensor.getCollisionPair();
	}

	@Override
	public void collisionOccured(IPhysicsCollision physicsCollision) {
		this.sensor.collisionOccured(physicsCollision);
	}
}
