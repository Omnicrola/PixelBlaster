package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public class Camera {

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
		return frameLeft();
	}

	public void setXOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public void setYOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public float getYOffset() {
		return frameTop();
	}

	public void focusOn(IGameEntity entity) {
		final Rectangle bounds = entity.getShape().getBounds();
		if (bounds.getMinX() < frameLeft()) {
			this.xOffset = bounds.getMinX();
		}
		if (bounds.getMaxX() > frameRight()) {
			this.xOffset = bounds.getMaxX() - this.viewportWidth;
		}
		if (bounds.getMaxY() < frameTop()) {
			this.yOffset = bounds.getMaxY();
		}
		if (bounds.getMinY() > frameBottom()) {
			this.yOffset = bounds.getMinY() - this.viewportHeight;
		}
	}

	private float frameTop() {
		return this.yOffset;
	}

	private float frameBottom() {
		return frameTop() + this.viewportHeight;
	}

	private float frameLeft() {
		return this.xOffset;
	}

	private float frameRight() {
		return frameLeft() + this.viewportWidth;
	}
}
