package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

public interface IPhysicsBody {
	public void applyForceAtCenter(Vector2f force);

	public Vector2f getPosition();

	public float getAngle();
}
