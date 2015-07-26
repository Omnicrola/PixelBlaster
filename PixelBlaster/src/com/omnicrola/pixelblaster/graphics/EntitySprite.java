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

	public EntitySprite(Image image, Rectangle bounds) {
		this.image = image;
		this.bounds = bounds;
		this.rotation = 0f;
		this.flippedX = false;
		this.drawColor = new Color(1, 1, 1, 0.75f);
	}

	@Override
	public float getY() {
		return this.bounds.getY();
	}

	@Override
	public void setTransparency(float transparency) {
		this.drawColor.a = transparency;
	}

	@Override
	public float getX() {
		return this.bounds.getX();
	}

	@Override
	public float getRotation() {
		return this.rotation;
	}

	@Override
	public Image getImage() {
		return this.image;
	}

	@Override
	public IEntitySprite setPosition(Vector2f position) {
		this.bounds.setLocation(position);
		return this;
	}

	@Override
	public IEntitySprite setRotation(float rotation) {
		this.rotation = rotation;
		return this;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.bounds.getX(), this.bounds.getY(), this.bounds.getWidth(), this.bounds.getHeight());
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		graphics.drawImage(this.image.getFlippedCopy(this.flippedX, false), this.bounds, this.drawColor);
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void setFacing(Facing facing) {
		this.flippedX = facing.equals(Facing.LEFT) ? true : false;
	}
}