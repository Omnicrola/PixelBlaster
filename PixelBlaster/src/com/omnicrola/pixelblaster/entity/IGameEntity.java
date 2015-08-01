package com.omnicrola.pixelblaster.entity;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.behavior.IDeathBehavior;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.physics.ICollisionDetector;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.physics.IPhysicsModifier;

public interface IGameEntity {

	IEntitySprite getSprite();

	Vector2f getPosition();

	void setPosition(Vector2f position);

	void setRotation(float angle);

	boolean isAlive();

	void update(float delta);

	void addUpdateBehavior(IUpdateBehavior behavior);

	void removeUpdateBehavior(IUpdateBehavior behavior);

	void disablePhysics();

	void enablePhysics();

	IPhysicsModifier modifyPhysics(IPhysicsManager physicsManager);

	Vector2f getVelocity();

	void setVelocity(Vector2f velocity);

	void setMaximumVelocity(float max);

	float getMaximumVelocity();

	void applyImpulseAtCenter(Vector2f forceVector);

	void applyForceAtCenter(Vector2f forceVector);

	void addCollisionDetector(ICollisionDetector collisionDetector);

	void addDeathBehavior(IDeathBehavior deathBehavior);

	void dispose();

	void kill();

}
