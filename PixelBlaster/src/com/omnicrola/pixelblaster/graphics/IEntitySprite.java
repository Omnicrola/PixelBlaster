package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;

public interface IEntitySprite {

	Image getImage();

	float getX();

	float getY();

	Rectangle getBounds();

	float getRotation();

	void setTransparency(float value);

	void update(float delta);

	void render(IGraphicsWrapper graphics);

	void setFacing(Facing facing);

	IEntitySprite setPosition(Vector2f position);

	IEntitySprite setRotation(float rotation);

}
