package com.omnicrola.pixelblaster.util;

import java.util.ArrayList;

import org.newdawn.slick.geom.Vector2f;

public class PointSet {
	private final ArrayList<Vector2f> points;

	public PointSet() {
		this.points = new ArrayList<>();
	}

	public void addPoint(float x, float y) {
		this.points.add(new Vector2f(x, y));
	}

	public int size() {
		return this.points.size();
	}

	public Vector2f[] getPoints() {
		final Vector2f[] array = new Vector2f[size()];
		return this.points.toArray(array);
	}

}
