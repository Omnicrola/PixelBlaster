package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSettings;

public class MapTile implements IMapTile {

	public static final IMapTile AIR = (x, y, graphics) -> {
	};

	private final Image image;
	private final Rectangle imageBounds;

	public MapTile(Image image) {
		this.image = image;
		final float size = GameSettings.MAP_TILE_SIZE_IN_METERS;
		this.imageBounds = new Rectangle(0, 0, size, size);
	}

	@Override
	public void render(float x, float y, IGraphicsWrapper graphics) {
		this.imageBounds.setLocation(x, y);
		graphics.drawImage(this.image, this.imageBounds);
	}

}
