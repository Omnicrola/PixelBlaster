package com.omnicrola.pixelblaster.collision;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IEntitySprite;

public interface ICollidable {

	Vector2f getPosition();

	void setPosition(Vector2f position);

	Vector2f getVelocity();

	void setVelocity(Vector2f velocity);

	IEntitySprite getSprite();

}
