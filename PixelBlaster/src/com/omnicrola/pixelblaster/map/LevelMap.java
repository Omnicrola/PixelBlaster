package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class LevelMap implements ILevelMap {
	private static final float WORLD_BOTTOM = 5000;
	private final short[][] tileData;
	private final IMapTile[] mapTiles;
	private final int tileSize;

	public LevelMap(int tileSize, IMapTile[] mapTiles, short[][] tileData) {
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

	@Override
	public boolean isWallAt(float x, float y) {
		final short tile = getTile(alignToGrid(x), alignToGrid(y));
		if (tile <= 0) {
			return false;
		}
		return true;
	}

	@Override
	public float getFloorAt(Vector2f position) {
		final int x = alignToGrid(position.x);
		int y = alignToGrid(position.y);
		if (y < 0) {
			y = 0;
		}
		return findSolidTile(x, y);
	}

	private int alignToGrid(float x2) {
		return (int) x2 / this.tileSize;
	}

	private float findSolidTile(int x, int y) {
		final short tileId = getTile(x, y);
		if (tileId == -1) {
			return WORLD_BOTTOM;
		} else if (tileId == 0) {
			return findSolidTile(x, y + 1);
		} else {
			return y * this.tileSize;
		}
	}

	private short getTile(int x, int y) {
		if (x >= 0 && x < this.tileData.length) {
			if (y >= 0 && y < this.tileData[x].length) {
				return this.tileData[x][y];
			}
		}
		return -1;
	}

}
