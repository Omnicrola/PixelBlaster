package com.omnicrola.pixelblaster.graphics;

import org.jbox2d.common.IViewportTransform;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.main.GameSettings;

public class Camera {

	private static final float VERTICAL_GUTTER = 100;
	private static final float LEFT_HORIZONTAL_GUTTER = 100;
	private static final float RIGHT_HORIZONTAL_GUTTER = 300;
	private float xOffset;
	private float yOffset;
	private final int viewportWidth;
	private final int viewportHeight;
	private final float scale;

	public Camera(float scale, int viewportWidth, int viewportHeight) {
		this.scale = scale;
		this.viewportWidth = viewportWidth;
		this.viewportHeight = viewportHeight;
		this.xOffset = 0;
		this.yOffset = 0;
	}

	public void focusOn(IGameEntity entity) {
		final Rectangle bounds = entity.getSprite().getBounds();
		final float minX = scale(bounds.getMinX());
		final float maxX = scale(bounds.getMaxX());
		final float minY = scale(bounds.getMinY());
		final float maxY = scale(bounds.getMaxY());

		if (minX < frameLeft()) {
			this.xOffset = minX - LEFT_HORIZONTAL_GUTTER;
		}
		if (maxX > frameRight()) {
			this.xOffset = maxX - this.viewportWidth + RIGHT_HORIZONTAL_GUTTER;
		}
		if (minY < frameTop()) {
			this.yOffset = minY + VERTICAL_GUTTER;
		}
		if (maxY > frameBottom()) {
			this.yOffset += GameSettings.CAMERA_SCROLL_SPEED;
		}
	}

	private float frameTop() {
		return this.yOffset - VERTICAL_GUTTER;
	}

	private float frameBottom() {
		return this.yOffset + this.viewportHeight + VERTICAL_GUTTER;
	}

	private float frameLeft() {
		return this.xOffset + LEFT_HORIZONTAL_GUTTER;
	}

	private float frameRight() {
		return this.xOffset + this.viewportWidth - RIGHT_HORIZONTAL_GUTTER;
	}

	public float scale(float value) {
		return value * this.scale;
	}

	public float translateX(float x) {
		return (x * this.scale) - this.xOffset;
	}

	public float translateY(float y) {
		return (y * this.scale) - this.yOffset;
	}

	public void applyTo(IViewportTransform viewportTranform) {
		viewportTranform.setExtents(this.viewportWidth / 2f, this.viewportHeight / 2f);
		final float x = this.xOffset / this.scale;
		final float y = this.yOffset / this.scale;
		viewportTranform.setCamera(x + 7.5f, y + 4.99f, this.scale);
	}

	public float getViewportWidth() {
		return this.viewportWidth;
	}

	public float getViewportHeight() {
		return this.viewportHeight;
	}

}
