package com.omnicrola.pixelblaster.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class EntityShape implements IEntityShape {
	private final Vector2f position;
	private final Image image;

	public EntityShape(Image image) {
		this.image = image;
		this.position = new Vector2f();
	}

	public float getY() {
		return this.position.x;
	}

	public float getX() {
		return this.position.y;
	}

	public Image getImage() {
		return this.image;
	}

	public EntityShape setPosition(Vector2f position) {
		this.position.set(position);
		return this;
	}

}
