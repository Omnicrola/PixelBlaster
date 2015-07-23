package com.omnicrola.pixelblaster.map;

public class MapTileDataSet {
	private static final int AIR = 0;

	public static interface TileDataCallback {
		public void callTile(int x, int y, IMapTile mapTile);
	}

	private final short[][] tileData;
	private final MapTileSet mapTileSet;

	public MapTileDataSet(MapTileSet mapTileSet, short[][] tileData) {
		this.mapTileSet = mapTileSet;
		this.tileData = tileData;
	}

	public void allTiles(TileDataCallback callback) {
		for (int x = 0; x < this.tileData.length; x++) {
			for (int y = 0; y < this.tileData[x].length; y++) {
				invokeWithTile(callback, x, y);
			}
		}
	}

	public void allButAir(TileDataCallback callback) {
		for (int x = 0; x < this.tileData.length; x++) {
			for (int y = 0; y < this.tileData[x].length; y++) {
				final short tileIndex = this.tileData[x][y];
				if (tileIndex != AIR) {
					callback.callTile(x, y, getTile(tileIndex));
				}
			}
		}
	}

	private void invokeWithTile(TileDataCallback callback, int x, int y) {
		final short tileIndex = this.tileData[x][y];
		callback.callTile(x, y, getTile(tileIndex));
	}

	private IMapTile getTile(short tileIndex) {
		return this.mapTileSet.getTile(tileIndex);
	}

}
