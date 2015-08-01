package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.opengl.EmptyImageData;

import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;

public class EmptySprite implements IEntitySprite {

	private final Image image;
	private final Rectangle bounds;

	public EmptySprite(int width, int height) {
		this.image = new Image(new EmptyImageData(width, height));
		this.bounds = new Rectangle(0, 0, width, height);
	}

	@Override
	public Image getImage() {
		return this.image;
	}

	@Override
	public float getX() {
		return this.bounds.getX();
	}

	@Override
	public float getY() {
		return this.bounds.getY();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.bounds.getX(), this.bounds.getY(), this.bounds.getWidth(), this.bounds.getHeight());
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
