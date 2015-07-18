package com.omnicrola.pixelblaster.entity;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.collision.ICollidable;

public class GameEntity implements IGameEntity, ICollidable {
	private final Vector2f position;
	private final Vector2f velocity;
	private final boolean isAlive;
	private final EntityShape baseShape;

	public GameEntity(EntityShape baseShape) {
		this.baseShape = baseShape;
		this.position = new Vector2f();
		this.velocity = new Vector2f();
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
		this.position.x += this.velocity.x * delta;
		this.position.y += this.velocity.y * delta;
	}

	@Override
	public IEntityShape getShape() {
		return this.baseShape.setPosition(this.position);
	}

}
