package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.main.GameSettings;

public class SlickGraphicsWrapper implements IGraphicsWrapper {

	private static final Color FULL = new Color(1f, 1f, 1f, 1f);
	private final Graphics graphics;
	private final Camera camera;

	public SlickGraphicsWrapper(Camera camera, Graphics graphics) {
		this.camera = camera;
		this.graphics = graphics;
	}

	@Override
	public void drawImage(Image image, Rectangle bounds) {
		drawImage(image, bounds, FULL);
	}

	@Override
	public void drawImage(Image image, int x, int y) {
		drawImage(image, new Rectangle(x, y, image.getWidth(), image.getHeight()), FULL);
	}

	@Override
	public void drawImage(Image image, Rectangle bounds, Color drawColor) {
		final float x = this.camera.translateX(bounds.getX());
		final float y = this.camera.translateY(bounds.getY());
		final float scaledWidth = this.camera.scale(bounds.getWidth());
		final float scaledHeight = this.camera.scale(bounds.getHeight());
		this.graphics.drawImage(image, x, y, x + scaledWidth, y + scaledHeight, 0, 0, image.getWidth(),
				image.getHeight(), drawColor);
		// DEBUG
		if (GameSettings.DEBUG) {
			this.graphics.setColor(Color.yellow);
			this.graphics.drawRect(x, y, scaledWidth, scaledHeight);
		}
	}

	@Override
	public void drawImageFullScreen(Image image) {
		final float imageWidth = image.getWidth();
		final float imageHeight = image.getHeight();
		final float width = this.camera.getViewportWidth();
		final float height = this.camera.getViewportHeight();
		this.graphics.drawImage(image, 0, 0, width, height, 0, 0, imageWidth, imageHeight);
	}

	@Override
	public void drawRect(int x, int y, int width, int height) {
		this.graphics.drawRect(x, y, width, height);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		this.graphics.fillRect(x, y, width, height);
	}

	@Override
	public void setColor(Color color) {
		this.graphics.setColor(color);
	}

	@Override
	public void drawString(String text, int x, int y) {
		this.graphics.drawString(text, x, y);
	}
}
