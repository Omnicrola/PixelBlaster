package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.geom.Rectangle;

public class SpriteData {
	private final String imageSet;
	private final Rectangle bounds;

	public SpriteData(String imageSet, Rectangle bounds) {
		this.imageSet = imageSet;
		this.bounds = bounds;
	}

	public String getImageSet() {
		return this.imageSet;
	}

	public Rectangle getBounds() {
		return this.bounds;
	}

}
