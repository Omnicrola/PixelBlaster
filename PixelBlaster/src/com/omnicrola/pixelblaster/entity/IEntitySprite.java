package com.omnicrola.pixelblaster.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public interface IEntitySprite {

	Image getImage();

	float getX();

	float getY();

	Rectangle getBounds();

	public abstract float getRotation();

	void update(float delta);

	void render(IGraphicsWrapper graphics);

}
