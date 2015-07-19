package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.entity.IEntitySprite;
import com.omnicrola.pixelblaster.main.GameSettings;

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
	public void drawShape(IEntitySprite shape) {
		final Image image = shape.getImage();
		final float y = shape.getY() - image.getHeight();
		final float x = shape.getX();
		drawImage(image, x, y);
	}

	@Override
	public void drawImage(Image image, float x, float y) {
		x = this.camera.translateX(x);
		y = this.camera.translateY(y);
		final float scaledWidth = this.camera.scale(image.getWidth());
		final float scaledHeight = this.camera.scale(image.getHeight());
		this.graphics.drawImage(image, x, y, x + scaledWidth, y + scaledHeight, 0, 0, image.getWidth(),
				image.getHeight());
		if (GameSettings.DEBUG) {
			this.graphics.setColor(Color.green);
			this.graphics.drawRect(x, y, scaledWidth, scaledHeight);
		}
	}
}
