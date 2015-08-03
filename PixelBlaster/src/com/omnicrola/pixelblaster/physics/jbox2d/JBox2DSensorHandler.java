package com.omnicrola.pixelblaster.physics.jbox2d;

import com.omnicrola.pixelblaster.physics.CollisionPair;
import com.omnicrola.pixelblaster.physics.ICollisionDetector;
import com.omnicrola.pixelblaster.physics.IPhysicsSensor;

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
	public void collisionOccured() {
		this.sensor.collisionOccured();
	}
}
