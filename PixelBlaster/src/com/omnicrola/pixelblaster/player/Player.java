package com.omnicrola.pixelblaster.player;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;

import com.omnicrola.pixelblaster.entity.EntitySprite;
import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.physics.EntityPhysics;
import com.omnicrola.pixelblaster.physics.PhysicsType;

public class Player extends GameEntity {

	public Player(EntitySprite baseShape) {
		super(baseShape, createPlayerPhysics());
	}

	private static EntityPhysics createPlayerPhysics() {
		final BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DYNAMIC;
		bodyDef.fixedRotation = true;
		bodyDef.allowSleep = false;

		final PolygonShape shape = new PolygonShape();
		shape.setAsBox(0.5f, 1f);
		return new EntityPhysics(PhysicsType.DYNAMIC, 1.0f, shape, bodyDef);
	}

}
