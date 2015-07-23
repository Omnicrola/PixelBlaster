package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Image;

public class GameBackground {
	private final Image image;

	public GameBackground(Image image) {
		this.image = image;
	}

	public void render(IGraphicsWrapper graphics) {
		graphics.drawImageFullScreen(this.image);
	}

}
