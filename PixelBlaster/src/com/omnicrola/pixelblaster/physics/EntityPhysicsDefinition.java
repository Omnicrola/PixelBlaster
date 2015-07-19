package com.omnicrola.pixelblaster.physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.BodyDef;

public class EntityPhysicsDefinition {
	public static final EntityPhysicsDefinition NULL = new EntityPhysicsDefinition(PhysicsType.NONE, 0,
			new CircleShape(), new BodyDef());
	private final PhysicsType physicsType;
	private final float density;
	private final Shape shape;
	private final BodyDef bodyDef;

	public EntityPhysicsDefinition(PhysicsType physicsType, float density, Shape shape, BodyDef bodyDef) {
		this.physicsType = physicsType;
		this.density = density;
		this.shape = shape;
		this.bodyDef = bodyDef;
	}

	public BodyDef getPhysicsBody() {
		return this.bodyDef;
	}

	public Shape getShape() {
		return this.shape;
	}

	public float getDensity() {
		return this.density;
	}

	public PhysicsType getPhysicsType() {
		return this.physicsType;
	}

}
