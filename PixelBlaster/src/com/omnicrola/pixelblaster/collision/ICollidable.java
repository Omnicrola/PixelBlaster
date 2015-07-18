package com.omnicrola.pixelblaster.collision;

import org.newdawn.slick.geom.Vector2f;

public interface ICollidable {

	Vector2f getPosition();

	void setPosition(Vector2f position);

	Vector2f getVelocity();

	void setVelocity(Vector2f velocity);

}
