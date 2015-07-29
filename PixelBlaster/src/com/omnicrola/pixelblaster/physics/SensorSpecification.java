package com.omnicrola.pixelblaster.physics;

import org.jbox2d.collision.shapes.Shape;

public class SensorSpecification {

	private final int sensorId;
	private final Shape shape;

	public SensorSpecification(int sensorId, Shape shape) {
		this.sensorId = sensorId;
		this.shape = shape;
	}

	public int getSensorId() {
		return this.sensorId;
	}

	public Shape getShape() {
		return this.shape;
	}

}
