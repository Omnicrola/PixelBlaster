package com.omnicrola.pixelblaster.entity;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.collision.ICollidable;
import com.omnicrola.pixelblaster.physics.EntityPhysicsDefinition;

public class GameEntity implements IGameEntity, ICollidable {
	private final Vector2f position;
	private final Vector2f velocity;
	private final boolean isAlive;
	private final EntitySprite sprite;
	private float rotation;
	private final List<IUpdateBehavior> updateBehaviors;
	private final EntityPhysicsDefinition physicsDefinition;

	public GameEntity(EntitySprite sprite, EntityPhysicsDefinition physicsDefinition) {
		this.sprite = sprite;
		this.physicsDefinition = physicsDefinition;
		this.updateBehaviors = new ArrayList<>();
		this.position = new Vector2f();
		this.velocity = new Vector2f();
		this.rotation = 0f;
		this.isAlive = true;
	}

	@Override
	public Vector2f getPosition() {
		return this.position.copy();
	}

	@Override
	public Vector2f getVelocity() {
		return this.velocity.copy();
	}

	@Override
	public void setVelocity(Vector2f newVelocity) {
		this.velocity.set(newVelocity);
	}

	@Override
	public void setPosition(Vector2f position) {
		this.position.set(position);
	}

	@Override
	public boolean isAlive() {
		return this.isAlive;
	}

	@Override
	public void update(float delta) {
		for (final IUpdateBehavior updateBehavior : this.updateBehaviors) {
			updateBehavior.update(this, delta);
		}
	}

	@Override
	public IEntitySprite getSprite() {
		return this.sprite.setPosition(this.position).setRotation(this.rotation);
	}

	@Override
	public EntityPhysicsDefinition getPhysicsDefinition() {
		return this.physicsDefinition;
	}

	@Override
	public void setRotation(float angle) {
		this.rotation = angle;
	}

	@Override
	public void addUpdateBehavior(IUpdateBehavior behavior) {
		this.updateBehaviors.add(behavior);
	}

}
