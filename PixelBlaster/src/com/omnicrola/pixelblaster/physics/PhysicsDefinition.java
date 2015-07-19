package com.omnicrola.pixelblaster.physics;

import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;

public class PhysicsDefinition {
	private final Vec2 position;
	private PhysicsType type;
	private final Shape shape;
	private boolean allowRotation;
	private final float friction;

	public PhysicsDefinition(Shape shape) {
		this.shape = shape;
		this.position = new Vec2();
		this.type = PhysicsType.DYNAMIC;
		this.allowRotation = true;
		this.friction = 0.2f;
	}

	public void setPosition(float pX, float pY) {
		this.position.set(pX, pY);
	}

	public void setType(PhysicsType type) {
		this.type = type;
	}

	public void allowRotation(boolean allowRotation) {
		this.allowRotation = allowRotation;
	}

	public Vec2 getPosition() {
		return this.position;
	}

	public boolean allowRotation() {
		return this.allowRotation;
	}

	public PhysicsType getType() {
		return this.type;
	}

	public float getFriction() {
		return this.friction;
	}

	public Shape getShape() {
		return this.shape;
	}

}
