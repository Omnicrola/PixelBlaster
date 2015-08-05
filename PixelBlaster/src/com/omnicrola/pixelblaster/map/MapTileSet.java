package com.omnicrola.pixelblaster.map;

public class MapTileSet {

	private final IMapTile[] tiles;

	public MapTileSet(IMapTile[] tiles) {
		this.tiles = tiles;
	}

	public IMapTile getTile(int tileIndex) {
		assert(tileIndex >= 0);
		assert(tileIndex < this.tiles.length);
		return this.tiles[tileIndex];
	}

}
