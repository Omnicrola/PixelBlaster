package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;

public class EmptySprite implements IEntitySprite {

	private final Rectangle bounds;

	public EmptySprite(int width, int height) {
		this.bounds = new Rectangle(0, 0, width, height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.bounds.getX(), this.bounds.getY(), this.bounds.getWidth(), this.bounds.getHeight());
	}

	@Override
	public void setTransparency(float value) {
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

	@Override
	public void setFacing(Facing facing) {
	}

	@Override
	public void setPosition(Vector2f position) {
	}

	@Override
	public void setRotation(float rotation) {
	}

}
