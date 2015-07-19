package com.omnicrola.pixelblaster.map;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class LevelMap implements ILevelMap {
	private final short[][] tileData;
	private final IMapTile[] mapTiles;
	private final float tileSize;

	public LevelMap(float tileSize, IMapTile[] mapTiles, short[][] tileData) {
		this.tileSize = tileSize;
		this.mapTiles = mapTiles;
		this.tileData = tileData;
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		for (int x = 0; x < this.tileData.length; x++) {
			for (int y = 0; y < this.tileData[x].length; y++) {
				final short tileIndex = this.tileData[x][y];
				final IMapTile tile = this.mapTiles[tileIndex];
				tile.render(x * this.tileSize, y * this.tileSize, graphics);
			}
		}
	}

}
