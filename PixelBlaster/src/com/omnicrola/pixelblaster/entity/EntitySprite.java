package com.omnicrola.pixelblaster.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class EntitySprite implements IEntitySprite {
	private final Image image;
	private float rotation;
	private final Rectangle bounds;

	public EntitySprite(Image image, Rectangle bounds) {
		this.image = image;
		this.bounds = bounds;
		this.rotation = 0f;
	}

	@Override
	public float getY() {
		return this.bounds.getY();
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

	public EntitySprite setPosition(Vector2f position) {
		this.bounds.setLocation(position);
		return this;
	}

	public IEntitySprite setRotation(float rotation) {
		this.rotation = rotation;
		return this;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.bounds.getX(), this.bounds.getY(), this.bounds.getWidth(), this.bounds.getHeight());
	}
}