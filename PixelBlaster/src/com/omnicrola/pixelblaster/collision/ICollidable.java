package com.omnicrola.pixelblaster.collision;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IEntityShape;

public interface ICollidable {

	Vector2f getPosition();

	void setPosition(Vector2f position);

	Vector2f getVelocity();

	void setVelocity(Vector2f velocity);

	IEntityShape getShape();

}
