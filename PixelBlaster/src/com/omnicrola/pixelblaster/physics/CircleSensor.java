package com.omnicrola.pixelblaster.physics;

public class CircleSensor extends PhysicsSensor {

	private final float radius;
	private final float x;
	private final float y;

	public CircleSensor(float radius, float x, float y, CollisionPair collisionPair) {
		super(collisionPair);
		this.radius = radius;
		this.x = x;
		this.y = y;
	}

	public float getRadius() {
		return this.radius;
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	@Override
	public void identify(ISensorInspector inspector) {
		inspector.iAm(this);
	}

}
