package com.omnicrola.pixelblaster.physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public class EntityPhysics {
	public static final EntityPhysics NULL = new EntityPhysics(PhysicsType.NONE, 0, new CircleShape(), new BodyDef());
	private final PhysicsType physicsType;
	private final float density;
	private final Shape shape;
	private final BodyDef bodyDef;
	private Body physicsBody;

	public EntityPhysics(PhysicsType physicsType, float density, Shape shape, BodyDef bodyDef) {
		this.physicsType = physicsType;
		this.density = density;
		this.shape = shape;
		this.bodyDef = bodyDef;
		this.physicsBody = NullPhysicsBody.NULL;
	}

	public BodyDef getPhysicsBodyDefinition() {
		return this.bodyDef;
	}

	public void setPhysicsBody(Body physicsBody) {
		this.physicsBody = physicsBody;
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

	public void update(IGameEntity gameEntity, float delta) {
		final Vec2 position = this.physicsBody.getPosition();
		final float angle = this.physicsBody.getAngle();
		gameEntity.setPosition(new Vector2f(position.x, position.y));
		gameEntity.setRotation(angle);
	}

	public void moveLeft(float force) {
		this.physicsBody.applyForce(new Vec2(-force, 0), this.physicsBody.getWorldCenter());
	}

	public void moveRight(float force) {
		this.physicsBody.applyForce(new Vec2(force, 0), this.physicsBody.getWorldCenter());
	}

	public void jump(float force) {
		this.physicsBody.applyForce(new Vec2(1000, 1000), this.physicsBody.getWorldCenter());
	}

	public void moveUp(float force) {
		this.physicsBody.applyForce(new Vec2(0, -force), this.physicsBody.getWorldCenter());
	}

	public void moveDown(float force) {
		this.physicsBody.applyForce(new Vec2(0, force), this.physicsBody.getWorldCenter());
	}

	public Body getPhysicsBody() {
		return this.physicsBody;
	}
}
