package com.omnicrola.pixelblaster.map;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSettings;

public class MapTile implements IMapTile {

	public static final IMapTile AIR = new IMapTile() {

		@Override
		public void render(float x, float y, IGraphicsWrapper graphics) {
		}

		@Override
		public PolygonShape getShape() {
			return new PolygonShape();
		}
	};

	private final Image image;
	private final Shape shape;
	private final Rectangle imageBounds;

	public MapTile(Image image, Shape shape) {
		this.image = image;
		this.shape = shape;
		final float size = GameSettings.MAP_TILE_SIZE_IN_METERS;
		this.imageBounds = new Rectangle(0, 0, size, size);
	}

	@Override
	public Shape getShape() {
		return this.shape;
	}

	@Override
	public void render(float x, float y, IGraphicsWrapper graphics) {
		this.imageBounds.setLocation(x, y);
		graphics.drawImage(this.image, this.imageBounds);
	}

}
