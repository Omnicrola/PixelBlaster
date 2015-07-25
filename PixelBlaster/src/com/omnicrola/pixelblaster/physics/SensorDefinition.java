package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Rectangle;

public class SensorDefinition {

	private final Rectangle bounds;
	private final int sensorId;

	public SensorDefinition(int sensorId, Rectangle bounds) {
		this.sensorId = sensorId;
		this.bounds = bounds;
	}

	public Rectangle getBounds() {
		return this.bounds;
	}

	public int getSensorId() {
		return this.sensorId;
	}
}
