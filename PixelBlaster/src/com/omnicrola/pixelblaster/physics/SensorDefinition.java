package com.omnicrola.pixelblaster.physics;

import org.jbox2d.collision.shapes.Shape;

public class SensorDefinition {

	private final Shape shape;
	private final int sensorId;

	public SensorDefinition(int sensorId, Shape shape) {
		this.sensorId = sensorId;
		this.shape = shape;
	}

	public Shape getShape() {
		return this.shape;
	}

	public int getSensorId() {
		return this.sensorId;
	}
}
