package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;

public class NullSprite implements IEntitySprite {

	public static final NullSprite NULL = new NullSprite();

	private NullSprite() {
	}

	@Override
	public Rectangle getBounds() {
		return null;
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
