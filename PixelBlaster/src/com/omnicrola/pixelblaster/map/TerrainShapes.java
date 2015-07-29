package com.omnicrola.pixelblaster.map;

import com.omnicrola.pixelblaster.util.PointSet;

public class TerrainShapes {
	public static final PointSet BASE = createRounded();
	public static final PointSet CENTER = createSquare();
	public static final PointSet ROUNDED = createRounded();
	public static final PointSet CLIFF_LEFT = createSquare();
	public static final PointSet CLIFF_RIGHT = createSquare();
	public static final PointSet CLIFF_ALT_LEFT = createSquare();
	public static final PointSet CLIFF_ALT_RIGHT = createSquare();
	public static final PointSet CORNER_LEFT = createSquare();
	public static final PointSet CORNER_RIGHT = createSquare();
	public static final PointSet HALF = createSquare();
	public static final PointSet HALF_LEFT = createSquare();
	public static final PointSet HALF_MID = createSquare();
	public static final PointSet HALF_RIGHT = createSquare();
	public static final PointSet HILL_LEFT = createHillLeft();
	public static final PointSet HILL_RIGHT = createHillRight();
	public static final PointSet LEFT = createSquare();
	public static final PointSet MID = createSquare();
	public static final PointSet RIGHT = createSquare();

	private static PointSet createSquare() {
		final PointSet polygon = new PointSet();
		polygon.addPoint(-1.0f, -1.0f);
		polygon.addPoint(1.0f, -1.0f);
		polygon.addPoint(1.0f, 1.0f);
		polygon.addPoint(-1.0f, 1.0f);
		return polygon;
	}

	private static PointSet createRounded() {
		final PointSet polygon = new PointSet();
		final float outerCorner = 0.75f;
		final float innerCorner = 0.9125f;
		final float edge = 1.0f;
		polygon.addPoint(-edge, -outerCorner);
		polygon.addPoint(-innerCorner, -innerCorner);
		polygon.addPoint(-outerCorner, -edge);

		polygon.addPoint(outerCorner, -edge);
		polygon.addPoint(innerCorner, -innerCorner);
		polygon.addPoint(edge, -outerCorner);

		polygon.addPoint(edge, edge);
		polygon.addPoint(-edge, edge);
		return polygon;
	}

	private static PointSet createHillRight() {
		final PointSet polygon = new PointSet();
		polygon.addPoint(1.0f, -1.0f);
		polygon.addPoint(1.0f, 1.0f);
		polygon.addPoint(-1.0f, 1.0f);
		return polygon;
	}

	private static PointSet createHillLeft() {
		final PointSet polygon = new PointSet();
		polygon.addPoint(-1.0f, -1.0f);
		polygon.addPoint(1.0f, 1.0f);
		polygon.addPoint(-1.0f, 1.0f);
		return polygon;
	}

}
