package com.omnicrola.pixelblaster.player;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.entity.MultiStateSprite;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.physics.EntityPhysics;
import com.omnicrola.pixelblaster.physics.PhysicsDefinition;
import com.omnicrola.pixelblaster.physics.PhysicsType;

public class Player extends GameEntity {

	private static final float CHARACTER_HEIGHT = 0.7f;
	private static final float CHARACTER_WIDTH = 0.3f;
	private final MultiStateSprite multistateSprite;

	public Player(MultiStateSprite multistateSprite) {
		super(multistateSprite, createPlayerPhysics());
		this.multistateSprite = multistateSprite;
	}

	public MultiStateSprite getMultistateSprite() {
		return this.multistateSprite;
	}

	private static EntityPhysics createPlayerPhysics() {

		final PhysicsDefinition physicsDefinition = createCapsuleShape();
		physicsDefinition.setType(PhysicsType.DYNAMIC);
		physicsDefinition.allowRotation(false);
		physicsDefinition.allowSleep(false);
		physicsDefinition.setMaxVelocity(GameSettings.PLAYER_MAXIMUM_VELOCITY);
		return new EntityPhysics(physicsDefinition);
	}

	private static PhysicsDefinition createCapsuleShape() {
		final CircleShape topCircle = new CircleShape();
		topCircle.m_radius = CHARACTER_WIDTH;

		final CircleShape bottomCircle = new CircleShape();
		bottomCircle.m_radius = CHARACTER_WIDTH;
		bottomCircle.m_p.y = CHARACTER_HEIGHT;

		final PolygonShape center = new PolygonShape();
		final Vec2[] vertices = new Vec2[4];
		vertices[0] = new Vec2(-CHARACTER_WIDTH, 0);
		vertices[1] = new Vec2(CHARACTER_WIDTH, 0);
		vertices[2] = new Vec2(CHARACTER_WIDTH, CHARACTER_HEIGHT);
		vertices[3] = new Vec2(-CHARACTER_WIDTH, CHARACTER_HEIGHT);
		center.set(vertices, 4);

		final PhysicsDefinition physicsDefinition = new PhysicsDefinition(topCircle, bottomCircle, center);
		return physicsDefinition;
	}

}
