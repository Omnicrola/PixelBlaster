package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Rectangle;

public class RectangleSensor extends PhysicsSensor {

	private final Rectangle rectangle;

	public RectangleSensor(Rectangle rectangle, CollisionIdentifier target) {
		super(target);
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
