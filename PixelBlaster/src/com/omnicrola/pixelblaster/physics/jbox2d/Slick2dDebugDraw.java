package com.omnicrola.pixelblaster.physics.jbox2d;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.collision.AABB;
import org.jbox2d.common.Color3f;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.OBBViewportTransform;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.pooling.arrays.IntArray;
import org.jbox2d.pooling.arrays.Vec2Array;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;

public class Slick2dDebugDraw extends DebugDraw {
	public static int circlePoints = 20;
	Graphics graphics;
	private final Vec2Array vec2Array = new Vec2Array();
	private final Vec2 sp1 = new Vec2();
	private final Vec2 sp2 = new Vec2();
	private final Vec2 saxis = new Vec2();
	private final Vec2 temp = new Vec2();
	private final static IntArray xIntsPool = new IntArray();
	private final static IntArray yIntsPool = new IntArray();
	private final Vec2 temp2 = new Vec2();

	public Slick2dDebugDraw(Graphics graphics) {
		super(new OBBViewportTransform());
		this.viewportTransform.setYFlip(false);
		this.graphics = graphics;

		System.out.println("Slick2D DebugDraw for JBox2D has been initialised!");
	}

	@Override
	public void drawCircle(Vec2 center, float radius, Color3f color) {
		final Vec2[] vecs = this.vec2Array.get(circlePoints);
		generateCirle(center, radius, vecs, circlePoints);
		drawPolygon(vecs, circlePoints, color);
	}

	@Override
	public void drawPoint(Vec2 argPoint, float argRadiusOnScreen, Color3f argColor) {
		getWorldToScreenToOut(argPoint, this.sp1);
		this.graphics.setColor(new Color(argColor.x, argColor.y, argColor.z));

		this.sp1.x -= argRadiusOnScreen;
		this.sp1.y -= argRadiusOnScreen;
		this.graphics.drawOval((int) this.sp1.x, (int) this.sp1.y, (int) argRadiusOnScreen * 2,
				(int) argRadiusOnScreen * 2);
		this.graphics.setColor(Color.white);
	}

	@Override
	public void drawSegment(Vec2 p1, Vec2 p2, Color3f color) {
		getWorldToScreenToOut(p1, this.sp1);
		getWorldToScreenToOut(p2, this.sp2);
		this.graphics.setColor(new Color(color.x, color.y, color.z));

		this.graphics.drawLine((int) this.sp1.x, (int) this.sp1.y, (int) this.sp2.x, (int) this.sp2.y);
		this.graphics.setColor(Color.white);
	}

	public void drawAABB(AABB argAABB, Color3f color) {
		this.graphics.setColor(new Color(color.x, color.y, color.z));
		final Vec2 vecs[] = this.vec2Array.get(4);
		argAABB.getVertices(vecs);
		drawPolygon(vecs, 4, color);
		this.graphics.setColor(Color.white);
	}

	@Override
	public void drawSolidCircle(Vec2 center, float radius, Vec2 axis, Color3f color) {
		final Vec2[] vecs = this.vec2Array.get(circlePoints);
		generateCirle(center, radius, vecs, circlePoints);
		drawSolidPolygon(vecs, circlePoints, color);
		if (axis != null) {
			this.saxis.set(axis).mulLocal(radius).addLocal(center);
			drawSegment(center, this.saxis, color);
		}
		this.graphics.setColor(Color.white);
	}

	@Override
	public void drawSolidPolygon(Vec2[] vertices, int vertexCount, Color3f color) {

		final int[] xInts = xIntsPool.get(vertexCount);
		final int[] yInts = yIntsPool.get(vertexCount);
		final Polygon p = new Polygon();

		for (int i = 0; i < vertexCount; i++) {
			getWorldToScreenToOut(vertices[i], this.temp);
			xInts[i] = (int) this.temp.x;
			yInts[i] = (int) this.temp.y;
			p.addPoint(xInts[i], yInts[i]);
		}

		this.graphics.setColor(new Color(color.x, color.y, color.z));
		this.graphics.draw(p); // Draws shape filled with colour
		this.graphics.setColor(Color.white);
		// drawPolygon(vertices, vertexCount, color);
	}

	@Override
	public void drawString(float x, float y, String s, Color3f color) {
		this.graphics.setColor(new Color(color.x, color.y, color.z));
		this.graphics.drawString(s, x, y);
		this.graphics.setColor(Color.white);
	}

	@Override
	public void drawTransform(Transform xf) {
		getWorldToScreenToOut(xf.position, this.temp);
		this.temp2.setZero();
		final float k_axisScale = 0.4f;

		this.graphics.setColor(new Color(1, 0, 0));
		this.temp2.x = xf.position.x + k_axisScale * xf.R.col1.x;
		this.temp2.y = xf.position.y + k_axisScale * xf.R.col1.y;
		getWorldToScreenToOut(this.temp2, this.temp2);
		this.graphics.drawLine((int) this.temp.x, (int) this.temp.y, (int) this.temp2.x, (int) this.temp2.y);

		this.graphics.setColor(new Color(0, 1, 0));
		this.temp2.x = xf.position.x + k_axisScale * xf.R.col2.x;
		this.temp2.y = xf.position.y + k_axisScale * xf.R.col2.y;
		getWorldToScreenToOut(this.temp2, this.temp2);
		this.graphics.drawLine((int) this.temp.x, (int) this.temp.y, (int) this.temp2.x, (int) this.temp2.y);
		this.graphics.setColor(Color.white);
	}

	// CIRCLE GENERATOR

	private void generateCirle(Vec2 argCenter, float argRadius, Vec2[] argPoints, int argNumPoints) {
		final float inc = MathUtils.TWOPI / argNumPoints;

		for (int i = 0; i < argNumPoints; i++) {
			argPoints[i].x = (argCenter.x + MathUtils.cos(i * inc) * argRadius);
			argPoints[i].y = (argCenter.y + MathUtils.sin(i * inc) * argRadius);
		}
		this.graphics.setColor(Color.white);
	}

}