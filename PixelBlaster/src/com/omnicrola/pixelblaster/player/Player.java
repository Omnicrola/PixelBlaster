package com.omnicrola.pixelblaster.player;

import org.jbox2d.collision.shapes.PolygonShape;

import com.omnicrola.pixelblaster.entity.EntitySprite;
import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.physics.EntityPhysics;
import com.omnicrola.pixelblaster.physics.PhysicsDefinition;
import com.omnicrola.pixelblaster.physics.PhysicsType;

public class Player extends GameEntity {

	public Player(EntitySprite baseShape) {
		super(baseShape, createPlayerPhysics());
	}

	private static EntityPhysics createPlayerPhysics() {
		final PolygonShape shape = new PolygonShape();
		shape.setAsBox(0.5f, 1f);
		final PhysicsDefinition physicsDefinition = new PhysicsDefinition(shape);
		physicsDefinition.setType(PhysicsType.DYNAMIC);
		physicsDefinition.allowRotation(false);
		physicsDefinition.allowSleep(false);
		physicsDefinition.setMaxVelocity(GameSettings.PLAYER_MAXIMUM_VELOCITY);
		return new EntityPhysics(physicsDefinition);
	}

}
