package com.omnicrola.pixelblaster.physics;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;

public class PhysicsDefinition {
	private final Vec2 position;
	private PhysicsType type;
	private final Shape[] shapes;
	private boolean allowRotation;
	private float friction;
	private boolean allowSleep;
	private float maxVelocity;
	private final ArrayList<SensorDefinition> sensors;
	private CollisionType collisionType;

	public PhysicsDefinition(Shape... shapes) {
		this.shapes = shapes;
		this.position = new Vec2();
		this.sensors = new ArrayList<>();
		this.type = PhysicsType.DYNAMIC;
		this.collisionType = CollisionType.NONE;
		this.allowRotation = true;
		this.allowSleep = true;
		this.maxVelocity = 10f;
		this.friction = 0.2f;
	}

	public float getMaxVelocity() {
		return this.maxVelocity;
	}

	public void setMaxVelocity(float maxVelocity) {
		this.maxVelocity = maxVelocity;
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

	public boolean allowRotation() {
		return this.allowRotation;
	}

	public void allowSleep(boolean allowSleep) {
		this.allowSleep = allowSleep;
	}

	public boolean allowSleep() {
		return this.allowSleep;
	}

	public Vec2 getPosition() {
		return this.position;
	}

	public PhysicsType getType() {
		return this.type;
	}

	public float getFriction() {
		return this.friction;
	}

	public void setFriction(float friction) {
		this.friction = friction;
	}

	public Shape[] getShapes() {
		return this.shapes;
	}

	public void addSensor(SensorDefinition sensor) {
		this.sensors.add(sensor);
	}

	public List<SensorDefinition> getSensors() {
		return this.sensors;
	}

	public CollisionType getDetectionType() {
		return this.collisionType;
	}

	public void setCollisionType(CollisionType collisionType) {
		this.collisionType = collisionType;
	}

}
