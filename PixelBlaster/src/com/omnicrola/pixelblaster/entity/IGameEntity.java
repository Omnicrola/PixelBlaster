package com.omnicrola.pixelblaster.entity;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsWrapper;

public interface IGameEntity {

	IEntitySprite getSprite();

	Vector2f getPosition();

	void setPosition(Vector2f vector2f);

	void setRotation(float angle);

	IPhysicsEntity getPhysics();

	boolean isAlive();

	void update(float delta);

	void destroy(IPhysicsWrapper physicsWrapper);

	void addUpdateBehavior(IUpdateBehavior behavior);

}
