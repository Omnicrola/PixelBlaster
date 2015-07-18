package com.omnicrola.pixelblaster.entity;

import org.newdawn.slick.geom.Vector2f;

public interface IGameEntity {

	boolean isAlive();

	void update(float delta);

	IEntityShape getShape();

	Vector2f getVelocity();

	void setVelocity(Vector2f newVelocity);

	Vector2f getPosition();

}
