package com.omnicrola.pixelblaster.physics;

public class SensorIds {

	private static int nextId = 100;

	public static int next() {
		return nextId++;
	}

}
