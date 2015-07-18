package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import com.omnicrola.pixelblaster.entity.IEntityShape;

public class SlickGraphicsWrapper implements IGraphicsWrapper {

	private final Graphics graphics;

	public SlickGraphicsWrapper(Graphics graphics) {
		this.graphics = graphics;
	}

	@Override
	public void drawLine(float x1, float y1, float x2, float y2) {
		this.graphics.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void setColor(Color color) {
		this.graphics.setColor(color);
	}

	@Override
	public void drawShape(IEntityShape shape) {
		this.graphics.drawImage(shape.getImage(), shape.getX(), shape.getY());
	}

}
