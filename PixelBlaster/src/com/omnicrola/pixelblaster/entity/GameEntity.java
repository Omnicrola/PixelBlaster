package com.omnicrola.pixelblaster.entity;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.physics.PhysicsWrapper;

public class GameEntity implements IGameEntity {
	private final Vector2f position;
	private final boolean isAlive;
	private final EntitySprite sprite;
	private float rotation;
	private final List<IUpdateBehavior> updateBehaviors;
	private final PhysicsWrapper physics;

	public GameEntity(EntitySprite sprite, PhysicsWrapper physics) {
		this.sprite = sprite;
		this.physics = physics;
		this.updateBehaviors = new ArrayList<>();
		this.position = new Vector2f();
		this.rotation = 0f;
		this.isAlive = true;
	}

	@Override
	public Vector2f getPosition() {
		return this.position.copy();
	}

	@Override
	public void setPosition(Vector2f position) {
		this.position.set(position);
		this.physics.setPosition(position);
	}

	@Override
	public boolean isAlive() {
		return this.isAlive;
	}

	@Override
	public void update(float delta) {
		this.physics.update(this, delta);
		this.sprite.update(delta);
	}

	@Override
	public IEntitySprite getSprite() {
		return this.sprite.setPosition(this.position).setRotation(this.rotation);
	}

	@Override
	public PhysicsWrapper getPhysics() {
		return this.physics;
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
