package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.GameBackground;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.map.io.XmlMapData;
import com.omnicrola.pixelblaster.util.Coordinate;

public class BasicLevelMap implements ILevelMap {
	private final float tileSize;
	private final MapTileDataSet tileData;
	private final GameBackground background;
	private final XmlMapData mapData;

	public BasicLevelMap(float tileSize, MapTileDataSet tileData, GameBackground background, XmlMapData mapData) {
		this.tileSize = tileSize;
		this.tileData = tileData;
		this.background = background;
		this.mapData = mapData;
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		this.background.render(graphics);
		this.tileData.allTiles((x, y, mapTile) -> mapTile.render(x * this.tileSize, y * this.tileSize, graphics));
	}

	@Override
	public Vector2f getPlayerSpawn() {
		final Coordinate playerSpawn = this.mapData.playerSpawn;
		final float x = playerSpawn.getX() * this.tileSize;
		final float y = playerSpawn.getY() * this.tileSize;
		return new Vector2f(x, y);
	}

	@Override
	public MapBounds getMapBounds() {
		return this.mapData.mapBounds;
	}

	@Override
	public void load() {
	}

	@Override
	public String getTitle() {
		return this.mapData.title;
	}

	@Override
	public String getSubtitle() {
		return this.mapData.subtitle;
	}

}
