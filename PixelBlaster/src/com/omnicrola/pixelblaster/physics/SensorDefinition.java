package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Rectangle;

public class SensorDefinition {

	private final Rectangle bounds;
	private final CollisionType collisionType;

	public SensorDefinition(CollisionType collisionType, Rectangle bounds) {
		this.collisionType = collisionType;
		this.bounds = bounds;
	}

	public Rectangle getBounds() {
		return this.bounds;
	}

	public CollisionType getDetectionType() {
		return this.collisionType;
	}
}
