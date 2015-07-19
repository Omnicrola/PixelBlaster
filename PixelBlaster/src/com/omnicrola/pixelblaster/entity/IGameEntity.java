package com.omnicrola.pixelblaster.entity;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.physics.EntityPhysicsDefinition;

public interface IGameEntity {

	boolean isAlive();

	void update(float delta);

	IEntitySprite getSprite();

	Vector2f getVelocity();

	void setVelocity(Vector2f newVelocity);

	Vector2f getPosition();

	void setPosition(Vector2f vector2f);

	EntityPhysicsDefinition getPhysicsDefinition();

	void setRotation(float angle);

	void addUpdateBehavior(IUpdateBehavior behavior);

}
