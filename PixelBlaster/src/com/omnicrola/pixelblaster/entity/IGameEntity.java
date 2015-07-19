package com.omnicrola.pixelblaster.entity;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.physics.EntityPhysics;

public interface IGameEntity {

	boolean isAlive();

	void update(float delta);

	IEntitySprite getSprite();

	Vector2f getPosition();

	void setPosition(Vector2f vector2f);

	EntityPhysics getPhysics();

	void setRotation(float angle);

	void addUpdateBehavior(IUpdateBehavior behavior);

}
