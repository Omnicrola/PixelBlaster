package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class AnimatedSprite extends EntitySprite {

	private final Image[] images;
	private final float framerate;
	private float totalTime;
	private float lastFrameChange;
	private int currentFrameIndex;

	public AnimatedSprite(Image[] images, Rectangle bounds, float framerate) {
		super(images[0], bounds);
		this.images = images;
		this.framerate = framerate;
		this.currentFrameIndex = 0;
	}

	@Override
	public void update(float delta) {
		this.totalTime += delta;
		final float elapsed = this.totalTime - this.lastFrameChange;
		if (elapsed >= this.framerate) {
			incrementFrame();
		}
	}

	private void incrementFrame() {
		this.currentFrameIndex++;
		if (this.currentFrameIndex >= this.images.length) {
			this.currentFrameIndex = 0;
		}
		this.lastFrameChange = this.totalTime;
		this.image = this.images[this.currentFrameIndex];
	}

}
