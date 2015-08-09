package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.physics.contact.CollisionPair;

public class RectangleSensor extends PhysicsSensor {

	private final Rectangle rectangle;

	public RectangleSensor(Rectangle rectangle, CollisionPair collisionPair) {
		super(collisionPair);
		this.rectangle = rectangle;
	}

	public Rectangle getRectangle() {
		return this.rectangle;
	}

	@Override
	public void identify(ISensorInspector inspector) {
		inspector.iAm(this);
	}

}
