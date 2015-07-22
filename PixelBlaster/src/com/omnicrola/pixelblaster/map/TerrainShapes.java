package com.omnicrola.pixelblaster.map;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;

public class TerrainShapes {
	private static final float TILE_SIZE = 1.0f;

	public static final Shape BASE = createBase();
	public static final Shape CENTER = createBase();
	public static final Shape ROUNDED = createBase();
	public static final Shape CLIFF_LEFT = createBase();
	public static final Shape CLIFF_RIGHT = createBase();
	public static final Shape CLIFF_ALT_LEFT = createBase();
	public static final Shape CLIFF_ALT_RIGHT = createBase();
	public static final Shape CORNER_LEFT = createBase();
	public static final Shape CORNER_RIGHT = createBase();
	public static final Shape HALF = createBase();
	public static final Shape HALF_LEFT = createBase();
	public static final Shape HALF_MID = createBase();
	public static final Shape HALF_RIGHT = createBase();
	public static final Shape HILL_LEFT = createHillLeft();
	public static final Shape HILL_RIGHT = createHillRight();
	public static final Shape LEFT = createBase();
	public static final Shape MID = createBase();
	public static final Shape RIGHT = createBase();

	private static Shape createBase() {
		final PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(TILE_SIZE, TILE_SIZE);
		return polygonShape;
	}

	private static Shape createHillRight() {
		final PolygonShape polygonShape = new PolygonShape();
		final Vec2[] vertices = new Vec2[3];
		vertices[0] = new Vec2(TILE_SIZE, -TILE_SIZE);
		vertices[1] = new Vec2(TILE_SIZE, TILE_SIZE);
		vertices[2] = new Vec2(-TILE_SIZE, TILE_SIZE);
		polygonShape.set(vertices, vertices.length);
		return polygonShape;
	}

	private static Shape createHillLeft() {
		final PolygonShape polygonShape = new PolygonShape();
		final Vec2[] vertices = new Vec2[3];
		vertices[0] = new Vec2(-TILE_SIZE, -TILE_SIZE);
		vertices[1] = new Vec2(TILE_SIZE, TILE_SIZE);
		vertices[2] = new Vec2(-TILE_SIZE, TILE_SIZE);
		polygonShape.set(vertices, vertices.length);
		return polygonShape;
	}

}
