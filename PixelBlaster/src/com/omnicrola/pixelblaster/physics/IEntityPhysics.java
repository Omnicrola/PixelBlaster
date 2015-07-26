package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public interface IEntityPhysics {

	void destroy(IPhysicsWrapper physics);

	public abstract void setMaximumVelocity(float maximumVelocity);

	void setPosition(Vector2f position);

	void update(IGameEntity gameEntity, float delta);

	void moveRight(float force);

	void moveLeft(float force);

	void moveUp(float force);

	void moveDown(float force);

	void jump(float force);

}