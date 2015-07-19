package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

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
	public void setColor(Color color) {
		this.graphics.setColor(color);
	}

	@Override
	public void drawShape(IEntitySprite shape) {
		final Rectangle bounds = shape.getBounds();
		final Image image = shape.getImage();
		drawImage(image, bounds);
	}

	@Override
	public void drawImage(Image image, Rectangle bounds) {
		final float x = this.camera.translateX(bounds.getX());
		final float y = this.camera.translateY(bounds.getY());
		final float scaledWidth = this.camera.scale(bounds.getWidth());
		final float scaledHeight = this.camera.scale(bounds.getHeight());
		this.graphics.drawImage(image, x, y, x + scaledWidth, y + scaledHeight, 0, 0, image.getWidth(),
				image.getHeight());
		// DEBUG
		if (GameSettings.DEBUG) {
			this.graphics.setColor(Color.green);
			this.graphics.drawRect(x, y, scaledWidth, scaledHeight);
		}
	}

}
