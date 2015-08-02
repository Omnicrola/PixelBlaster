package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class EntitySprite implements IEntitySprite {

	public static enum Facing {
		LEFT, RIGHT;
	}

	protected Image image;
	protected float rotation;
	protected final Rectangle bounds;
	private boolean flippedX;
	private final Color drawColor;
	protected final Vector2f baseOffset;

	public EntitySprite(Image image, Rectangle bounds) {
		this.image = image;
		this.bounds = bounds;
		this.baseOffset = bounds.getLocation();
		this.rotation = 0f;
		this.flippedX = false;
		this.drawColor = new Color(1f, 1f, 1f, 1f);
	}

	@Override
	public void setTransparency(float transparency) {
		this.drawColor.a = transparency;
	}

	@Override
	public void setPosition(Vector2f position) {
		this.bounds.setLocation(position);
	}

	@Override
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	@Override
	public Rectangle getBounds() {
		final float x = this.bounds.getX() + this.baseOffset.x;
		final float y = this.bounds.getY() + this.baseOffset.y;
		return new Rectangle(x, y, this.bounds.getWidth(), this.bounds.getHeight());
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		graphics.drawImage(this.image.getFlippedCopy(this.flippedX, false), getBounds(), this.drawColor);
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void setFacing(Facing facing) {
		this.flippedX = facing.equals(Facing.LEFT) ? true : false;
	}
}
