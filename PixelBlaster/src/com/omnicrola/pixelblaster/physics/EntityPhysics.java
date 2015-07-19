package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public class EntityPhysics implements IEntityPhysics {

	private final PhysicsDefinition physicsDefinition;
	protected IPhysicsBody physicsBody;

	public EntityPhysics(PhysicsDefinition physicsDefinition) {
		this.physicsDefinition = physicsDefinition;
	}

	public void update(IGameEntity gameEntity, float delta) {
		final Vector2f position = this.physicsBody.getPosition();
		final float angle = this.physicsBody.getAngle();
		gameEntity.setPosition(new Vector2f(position.x, position.y));
		gameEntity.setRotation(angle);
	}

	@Override
	public void create(IPhysicsWrapper physics) {
		this.physicsBody = physics.createBody(this.physicsDefinition);
	}

	@Override
	public void destroy(IPhysicsWrapper physics) {
		physics.destroyBody(this.physicsBody);
		this.physicsBody = null;
	}

	public void moveLeft(float force) {
		this.physicsBody.applyForceAtCenter(new Vector2f(-force, 0));
	}

	public void moveRight(float force) {
		this.physicsBody.applyForceAtCenter(new Vector2f(force, 0));
	}

	public void jump(float force) {
	}

	public void moveUp(float force) {
		this.physicsBody.applyForceAtCenter(new Vector2f(0, -force));
	}

	public void moveDown(float force) {
		this.physicsBody.applyForceAtCenter(new Vector2f(0, force));
	}

}
