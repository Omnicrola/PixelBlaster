package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;

public interface IEntitySprite {

	Rectangle getBounds();

	void setTransparency(float value);

	void update(float delta);

	void render(IGraphicsWrapper graphics);

	void setFacing(Facing facing);

	void setPosition(Vector2f position);

	void setRotation(float rotation);

}
