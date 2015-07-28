package com.omnicrola.pixelblaster.physics.jbox2d;

import java.util.HashMap;
import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Filter;
import org.jbox2d.dynamics.Fixture;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.physics.ICollisionDetector;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsWrapper;

public class JBox2dPhysicsEntity implements IPhysicsEntity {
	private static final int NO_COLLISION_MASK = 0x0000;

	private final Body body;
	private final Vec2 vectorCache;
	private final List<Fixture> fixtures;
	private final List<JBox2dPhysicsSensor> sensors;
	private final JBox2dContactListener contactListener;
	private final Vector2f vector2f;
	private float maximumVelocity;
	private HashMap<Fixture, Filter> filterMap;

	public JBox2dPhysicsEntity(JBox2dContactListener contactHandler, Body body, List<Fixture> fixtures,
			List<JBox2dPhysicsSensor> sensors) {
		this.contactListener = contactHandler;
		this.body = body;
		this.fixtures = fixtures;
		this.sensors = sensors;
		this.maximumVelocity = 1.0f;
		this.vectorCache = new Vec2();
		this.vector2f = new Vector2f();
		buildFilterMap();
	}

	private void buildFilterMap() {
		this.filterMap = new HashMap<>();
		for (final Fixture fixture : this.fixtures) {
			this.filterMap.put(fixture, fixture.getFilterData());
		}
	}

	@Override
	public void applyForceAtCenter(Vector2f force) {
		this.vectorCache.set(force.x, force.y);
		this.body.applyForce(this.vectorCache, this.body.getWorldCenter());
	}

	@Override
	public void applyImpulseAtCenter(Vector2f force) {
		this.vectorCache.set(force.x, force.y);
		this.body.applyLinearImpulse(this.vectorCache, this.body.getWorldCenter());
	}

	@Override
	public Vector2f getLinearVelocity() {
		final Vec2 vel = this.body.getLinearVelocity();
		return new Vector2f(vel.x, vel.y);
	}

	@Override
	public void setLinearVelocity(Vector2f velocity) {
		this.vectorCache.set(velocity.x, velocity.y);
		this.body.setLinearVelocity(this.vectorCache);
	}

	@Override
	public void setPosition(Vector2f vector) {
		this.vectorCache.set(vector.x, vector.y);
		this.body.setTransform(this.vectorCache, this.body.getAngle());
	}

	@Override
	public Vector2f getPosition() {
		final Vec2 position = this.body.getPosition();
		return new Vector2f(position.x, position.y);
	}

	@Override
	public float getAngle() {
		return this.body.getAngle();
	}

	@Override
	public void addCollisionDetector(ICollisionDetector collisionDetector) {
		this.contactListener.addHandler(collisionDetector);
	}

	@Override
	public void updateEntity(IGameEntity gameEntity, float delta) {
		limitLinearVelocity();
		updatePosition(gameEntity);
	}

	private void updatePosition(IGameEntity gameEntity) {
		final Vec2 position = this.body.getPosition();
		this.vector2f.set(position.x, position.y);
		gameEntity.setPosition(this.vector2f);
	}

	private void limitLinearVelocity() {
		final Vec2 velocity = this.body.getLinearVelocity();
		final float actualSpeed = velocity.length();
		if (actualSpeed > this.maximumVelocity) {
			velocity.mulLocal(this.maximumVelocity / actualSpeed);
			this.body.setLinearVelocity(velocity);
		}
	}

	@Override
	public void destroy(IPhysicsWrapper physicsWrapper) {
		physicsWrapper.destroyEntity(this);
	}

	@Override
	public void setMaximumVelocity(float maximumVelocity) {
		this.maximumVelocity = maximumVelocity;
	}

	@Override
	public void disable() {
		for (final Fixture fixture : this.fixtures) {
			fixture.m_filter.maskBits = NO_COLLISION_MASK;
		}
	}

	@Override
	public void enable() {
		for (final Fixture fixture : this.fixtures) {
			fixture.m_filter.maskBits = this.filterMap.get(fixture).maskBits;
		}
	}

}
