package com.omnicrola.pixelblaster.map;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;

public class TerrainShapes {
	public static final Shape BASE = createRounded();
	public static final Shape CENTER = createSquare();
	public static final Shape ROUNDED = createRounded();
	public static final Shape CLIFF_LEFT = createSquare();
	public static final Shape CLIFF_RIGHT = createSquare();
	public static final Shape CLIFF_ALT_LEFT = createSquare();
	public static final Shape CLIFF_ALT_RIGHT = createSquare();
	public static final Shape CORNER_LEFT = createSquare();
	public static final Shape CORNER_RIGHT = createSquare();
	public static final Shape HALF = createSquare();
	public static final Shape HALF_LEFT = createSquare();
	public static final Shape HALF_MID = createSquare();
	public static final Shape HALF_RIGHT = createSquare();
	public static final Shape HILL_LEFT = createHillLeft();
	public static final Shape HILL_RIGHT = createHillRight();
	public static final Shape LEFT = createSquare();
	public static final Shape MID = createSquare();
	public static final Shape RIGHT = createSquare();

	private static Shape createSquare() {
		final PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(1.0f, 1.0f);
		return polygonShape;
	}

	private static Shape createRounded() {
		final PolygonShape polygonShape = new PolygonShape();
		final Vec2[] vertices = new Vec2[8];
		final float outerCorner = 0.75f;
		final float innerCorner = 0.9125f;
		final float edge = 1.0f;
		vertices[0] = new Vec2(-edge, -outerCorner);
		vertices[1] = new Vec2(-innerCorner, -innerCorner);
		vertices[2] = new Vec2(-outerCorner, -edge);

		vertices[3] = new Vec2(outerCorner, -edge);
		vertices[4] = new Vec2(innerCorner, -innerCorner);
		vertices[5] = new Vec2(edge, -outerCorner);

		vertices[6] = new Vec2(edge, edge);
		vertices[7] = new Vec2(-edge, edge);
		polygonShape.set(vertices, vertices.length);
		return polygonShape;
	}

	private static Shape createHillRight() {
		final PolygonShape polygonShape = new PolygonShape();
		final Vec2[] vertices = new Vec2[3];
		vertices[0] = new Vec2(1.0f, -1.0f);
		vertices[1] = new Vec2(1.0f, 1.0f);
		vertices[2] = new Vec2(-1.0f, 1.0f);
		polygonShape.set(vertices, vertices.length);
		return polygonShape;
	}

	private static Shape createHillLeft() {
		final PolygonShape polygonShape = new PolygonShape();
		final Vec2[] vertices = new Vec2[3];
		vertices[0] = new Vec2(-1.0f, -1.0f);
		vertices[1] = new Vec2(1.0f, 1.0f);
		vertices[2] = new Vec2(-1.0f, 1.0f);
		polygonShape.set(vertices, vertices.length);
		return polygonShape;
	}

}
