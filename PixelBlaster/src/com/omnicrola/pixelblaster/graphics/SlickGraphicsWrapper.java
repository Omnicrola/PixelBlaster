package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.entity.IEntityShape;

public class SlickGraphicsWrapper implements IGraphicsWrapper {

	private final Graphics graphics;
	private final Camera camera;

	public SlickGraphicsWrapper(Camera camera, Graphics graphics) {
		this.camera = camera;
		this.graphics = graphics;
	}

	@Override
	public void drawLine(float x1, float y1, float x2, float y2) {
		final float xOffset = this.camera.getXOffset();
		final float yOffset = this.camera.getYOffset();
		x1 = x1 + xOffset;
		y1 = y1 + yOffset;
		x2 = x2 + yOffset;
		y2 = y2 + yOffset;
		this.graphics.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void setColor(Color color) {
		this.graphics.setColor(color);
	}

	@Override
	public void drawShape(IEntityShape shape) {
		final Image image = shape.getImage();
		final float y = shape.getY() - image.getHeight();
		final float x = shape.getX();
		drawImage(image, x, y);
	}

	@Override
	public void drawImage(Image image, float x, float y) {
		x = x - this.camera.getXOffset();
		y = y - this.camera.getYOffset();
		this.graphics.drawImage(image, x, y);
		this.graphics.setColor(Color.green);
		this.graphics.drawRect(x, y, image.getWidth(), image.getHeight());
	}
}
