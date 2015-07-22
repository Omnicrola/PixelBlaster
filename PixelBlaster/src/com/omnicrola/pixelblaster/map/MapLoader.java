package com.omnicrola.pixelblaster.map;

import java.util.Random;

import org.jbox2d.collision.shapes.Shape;
import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.graphics.GameBackground;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.util.AssetManager;

public class MapLoader {
	private final AssetManager assetManager;

	public MapLoader(AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	public ILevelMap load(int currentLevel) {
		final short[][] tileData = createTileData();
		final IMapTile[] mapTiles = createTiles();
		return new LevelMap(GameSettings.MAP_TILE_SIZE_IN_METERS, mapTiles, tileData, createBackground());
	}

	private GameBackground createBackground() {
		final Image image = this.assetManager.getImage("Backgrounds/blue_land.png");
		return new GameBackground(image);
	}

	private short[][] createTileData() {
		final Random random = new Random(149);
		final short[][] data = new short[128][12];
		for (int x = 0; x < data.length; x++) {
			data[x][5] = 17;
			data[x][4] = randTile(random);
		}
		return data;
	}

	private short randTile(final Random random) {
		return (short) (random.nextInt(100) < 50 ? 0 : random.nextInt(18));
	}

	private IMapTile[] createTiles() {
		final String base = "Ground/Planet/planet";
		final IMapTile[] mapTiles = new IMapTile[19];
		mapTiles[0] = MapTile.AIR;
		mapTiles[1] = tile(base, TerrainShapes.BASE);
		mapTiles[2] = tile(base + "Center", TerrainShapes.CENTER);
		mapTiles[3] = tile(base + "Center_rounded", TerrainShapes.ROUNDED);
		mapTiles[4] = tile(base + "Cliff_left", TerrainShapes.CLIFF_LEFT);
		mapTiles[5] = tile(base + "Cliff_right", TerrainShapes.CLIFF_RIGHT);
		mapTiles[6] = tile(base + "CliffAlt_left", TerrainShapes.CLIFF_ALT_LEFT);
		mapTiles[7] = tile(base + "CliffAlt_right", TerrainShapes.CLIFF_ALT_RIGHT);
		mapTiles[8] = tile(base + "Corner_left", TerrainShapes.CORNER_LEFT);
		mapTiles[9] = tile(base + "Corner_right", TerrainShapes.CORNER_RIGHT);
		mapTiles[10] = tile(base + "Half", TerrainShapes.HALF);
		mapTiles[11] = tile(base + "Half_left", TerrainShapes.HALF_LEFT);
		mapTiles[12] = tile(base + "Half_mid", TerrainShapes.HALF_MID);
		mapTiles[13] = tile(base + "Half_right", TerrainShapes.HALF_RIGHT);
		mapTiles[14] = tile(base + "Hill_left", TerrainShapes.HILL_LEFT);
		mapTiles[15] = tile(base + "Hill_right", TerrainShapes.HILL_RIGHT);
		mapTiles[16] = tile(base + "Left", TerrainShapes.LEFT);
		mapTiles[17] = tile(base + "Mid", TerrainShapes.MID);
		mapTiles[18] = tile(base + "Right", TerrainShapes.RIGHT);
		return mapTiles;
	}

	private IMapTile tile(String filename, Shape shape) {
		filename = filename + ".png";
		final Image image = this.assetManager.getImage(filename);
		return new MapTile(image, shape);
	}
}
