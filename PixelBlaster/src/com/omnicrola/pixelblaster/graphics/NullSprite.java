package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.opengl.EmptyImageData;

import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;

public class NullSprite implements IEntitySprite {

	public static final NullSprite NULL = new NullSprite();

	private NullSprite() {
	}

	@Override
	public Image getImage() {
		return new Image(new EmptyImageData(0, 0));
	}

	@Override
	public float getX() {
		return 0;
	}

	@Override
	public float getY() {
		return 0;
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	@Override
	public float getRotation() {
		return 0;
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
	public IEntitySprite setPosition(Vector2f position) {
		return this;
	}

	@Override
	public IEntitySprite setRotation(float rotation) {
		return this;
	}
}
