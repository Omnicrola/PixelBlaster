package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

public class CharacterPhysicsWrapper {

	private final IPhysicsEntity physics;
	private final Vector2f cacheVector;

	public CharacterPhysicsWrapper(IPhysicsEntity physics) {
		this.physics = physics;
		this.cacheVector = new Vector2f();
	}

	public void moveLeft(float force) {
		applyForce(-force, 0);
	}

	public void moveRight(float force) {
		applyForce(force, 0);
	}

	public void moveUp(float force) {
		applyForce(0, -force);
	}

	public void moveDown(float force) {
		applyForce(0, force);
	}

	public void jump(float force) {
		applyImpulse(0, -force);
	}

	private void applyImpulse(float forceX, float forceY) {
		this.cacheVector.set(forceX, forceY);
		this.physics.applyImpulseAtCenter(this.cacheVector);
	}

	private void applyForce(float forceX, float forceY) {
		this.cacheVector.set(forceX, forceY);
		this.physics.applyForceAtCenter(this.cacheVector);
	}

}
