package com.omnicrola.pixelblaster.entity;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.behavior.IDeathBehavior;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.physics.ICollisionDetector;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.physics.IPhysicsModifier;

public class GameEntity implements IGameEntity {
	protected final IEntitySprite sprite;
	protected final IPhysicsEntity physics;
	private final Vector2f position;
	private boolean isAlive;
	private float rotation;
	private final List<IUpdateBehavior> updateBehaviors;
	private boolean usePhysics;
	private final List<IDeathBehavior> deathBehaviors;

	public GameEntity(IEntitySprite sprite, IPhysicsEntity physics) {
		this.sprite = sprite;
		this.physics = physics;
		this.updateBehaviors = new ArrayList<>();
		this.deathBehaviors = new ArrayList<>();
		this.position = new Vector2f();
		this.rotation = 0f;
		this.isAlive = true;
		this.usePhysics = true;
	}

	@Override
	public Vector2f getPosition() {
		return this.position.copy();
	}

	@Override
	public Vector2f getVelocity() {
		return this.physics.getLinearVelocity();
	}

	@Override
	public void setVelocity(Vector2f velocity) {
		this.physics.setLinearVelocity(velocity);
	}

	@Override
	public void setPosition(Vector2f position) {
		if (!this.position.equals(position)) {
			this.position.set(position);
			this.physics.setPosition(position);
		}
	}

	@Override
	public float getMaximumVelocity() {
		return this.physics.getMaximumVelocity();
	}

	@Override
	public void setMaximumVelocity(float max) {
		this.physics.setMaximumVelocity(max);
	}

	@Override
	public void update(float delta) {
		if (this.usePhysics) {
			this.physics.updateEntity(this, delta);
		}
		this.sprite.update(delta);
		updateBehavior(delta);
	}

	private void updateBehavior(float delta) {
		for (final IUpdateBehavior behavior : this.updateBehaviors) {
			behavior.update(this, delta);
		}
	}

	@Override
	public IEntitySprite getSprite() {
		this.sprite.setPosition(this.position);
		this.sprite.setRotation(this.rotation);
		return this.sprite;
	}

	@Override
	public void disablePhysics() {
		this.usePhysics = false;
		this.physics.disable();
	}

	@Override
	public void enablePhysics() {
		this.usePhysics = true;
		this.physics.enable();
	}

	@Override
	public IPhysicsModifier modifyPhysics(IPhysicsManager physicsManager) {
		return physicsManager.modifyEntity(this.physics);
	}

	@Override
	public void setRotation(float angle) {
		this.rotation = angle;
	}

	@Override
	public void addUpdateBehavior(IUpdateBehavior behavior) {
		this.updateBehaviors.add(behavior);
	}

	@Override
	public void removeUpdateBehavior(IUpdateBehavior behavior) {
		this.updateBehaviors.remove(behavior);
	}

	@Override
	public void addDeathBehavior(IDeathBehavior deathBehavior) {
		this.deathBehaviors.add(deathBehavior);
	}

	@Override
	public boolean isAlive() {
		return this.isAlive;
	}

	@Override
	public void kill() {
		this.isAlive = false;
	}

	@Override
	public void dispose() {
		this.physics.dispose();
		for (final IDeathBehavior behavior : this.deathBehaviors) {
			behavior.entityDestroyed(this);
		}
	}

	@Override
	public void applyForceAtCenter(Vector2f forceVector) {
		if (this.usePhysics) {
			this.physics.applyForceAtCenter(forceVector);
		}
	}

	@Override
	public void applyImpulseAtCenter(Vector2f forceVector) {
		if (this.usePhysics) {
			this.physics.applyImpulseAtCenter(forceVector);
		}
	}

	@Override
	public void addCollisionDetector(ICollisionDetector collisionDetector) {
		this.physics.addCollisionDetector(collisionDetector);
	}

}
