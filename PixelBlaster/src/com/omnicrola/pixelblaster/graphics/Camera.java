package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public class Camera {

	private static final float VERTICAL_GUTTER = 100;
	private static final float HORIZONTAL_GUTTER = 100;
	private float xOffset;
	private float yOffset;
	private final int viewportWidth;
	private final int viewportHeight;

	public Camera(int viewportWidth, int viewportHeight) {
		this.viewportWidth = viewportWidth;
		this.viewportHeight = viewportHeight;
		this.xOffset = 0;
		this.yOffset = 0;
	}

	public float getXOffset() {
		return this.xOffset;
	}

	public void setXOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public void setYOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public float getYOffset() {
		return this.yOffset;
	}

	public void focusOn(IGameEntity entity) {
		final Rectangle bounds = entity.getShape().getBounds();
		if (bounds.getMinX() < frameLeft()) {
			this.xOffset = bounds.getMinX() - HORIZONTAL_GUTTER;
		}
		if (bounds.getMaxX() > frameRight()) {
			this.xOffset = bounds.getMaxX() - this.viewportWidth + HORIZONTAL_GUTTER;
		}
		if (bounds.getMinY() < frameTop()) {
			this.yOffset = bounds.getMinY() - VERTICAL_GUTTER;
		}
		if (bounds.getMaxY() > frameBottom()) {
			this.yOffset = bounds.getMaxY() - this.viewportHeight + VERTICAL_GUTTER;
		}
	}

	private float frameTop() {
		return this.yOffset + VERTICAL_GUTTER;
	}

	private float frameBottom() {
		return this.yOffset + this.viewportHeight + VERTICAL_GUTTER;
	}

	private float frameLeft() {
		return this.xOffset + HORIZONTAL_GUTTER;
	}

	private float frameRight() {
		return this.xOffset + this.viewportWidth - HORIZONTAL_GUTTER;
	}
}
