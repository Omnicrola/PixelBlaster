package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public interface IGamePhysics {

	void destroy(IPhysicsWrapper physics);

	void setMaximumVelocity(float maximumVelocity);

	void setPosition(Vector2f position);

	void update(IGameEntity gameEntity, float delta);

}
