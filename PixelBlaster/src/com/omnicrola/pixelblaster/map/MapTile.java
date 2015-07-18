package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class MapTile implements IMapTile {

	public static final IMapTile AIR = (x, y, graphics) -> {
	};

	private final Image image;

	public MapTile(Image image) {
		this.image = image;
	}

	@Override
	public void render(int x, int y, IGraphicsWrapper graphics) {
		graphics.drawImage(this.image, x, y);
	}

}
