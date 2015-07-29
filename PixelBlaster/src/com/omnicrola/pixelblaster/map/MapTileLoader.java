package com.omnicrola.pixelblaster.map;

import java.io.File;

import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.util.AssetManager;
import com.omnicrola.pixelblaster.util.PointSet;

public class MapTileLoader {

	private static final String DELIM = File.separator;

	private final AssetManager assetManager;

	public MapTileLoader(AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	public MapTileDataSet loadData(XmlMapData mapData) {
		final int w = mapData.mapWidth;
		final int h = mapData.mapHeight;
		final short[][] tileData = new short[w][h];
		for (final XmlMapTileData singleTile : mapData.mapTiles) {
			tileData[singleTile.x][singleTile.y] = (short) singleTile.tileIndex;
		}
		return new MapTileDataSet(loadTileSet(mapData), tileData);
	}

	private MapTileSet loadTileSet(XmlMapData mapData) {
		final IMapTile[] tiles = createTiles(mapData.tilesetName);
		return new MapTileSet(tiles);
	}

	private IMapTile[] createTiles(String tilesetName) {
		final String filePrefix = tilesetName;
		final String baseFilepath = "Ground" + DELIM + "planet" + DELIM + filePrefix;
		final IMapTile[] mapTiles = new IMapTile[19];
		mapTiles[0] = MapTile.AIR;
		mapTiles[1] = tile(baseFilepath, TerrainShapes.BASE);
		mapTiles[2] = tile(baseFilepath + "Center", TerrainShapes.CENTER);
		mapTiles[3] = tile(baseFilepath + "Center_rounded", TerrainShapes.ROUNDED);
		mapTiles[4] = tile(baseFilepath + "Cliff_left", TerrainShapes.CLIFF_LEFT);
		mapTiles[5] = tile(baseFilepath + "Cliff_right", TerrainShapes.CLIFF_RIGHT);
		mapTiles[6] = tile(baseFilepath + "CliffAlt_left", TerrainShapes.CLIFF_ALT_LEFT);
		mapTiles[7] = tile(baseFilepath + "CliffAlt_right", TerrainShapes.CLIFF_ALT_RIGHT);
		mapTiles[8] = tile(baseFilepath + "Corner_left", TerrainShapes.CORNER_LEFT);
		mapTiles[9] = tile(baseFilepath + "Corner_right", TerrainShapes.CORNER_RIGHT);
		mapTiles[10] = tile(baseFilepath + "Half", TerrainShapes.HALF);
		mapTiles[11] = tile(baseFilepath + "Half_left", TerrainShapes.HALF_LEFT);
		mapTiles[12] = tile(baseFilepath + "Half_mid", TerrainShapes.HALF_MID);
		mapTiles[13] = tile(baseFilepath + "Half_right", TerrainShapes.HALF_RIGHT);
		mapTiles[14] = tile(baseFilepath + "Hill_left", TerrainShapes.HILL_LEFT);
		mapTiles[15] = tile(baseFilepath + "Hill_right", TerrainShapes.HILL_RIGHT);
		mapTiles[16] = tile(baseFilepath + "Left", TerrainShapes.LEFT);
		mapTiles[17] = tile(baseFilepath + "Mid", TerrainShapes.MID);
		mapTiles[18] = tile(baseFilepath + "Right", TerrainShapes.RIGHT);
		return mapTiles;
	}

	private IMapTile tile(String filename, PointSet shape) {
		filename = filename + ".png";
		final Image image = this.assetManager.getImage(filename);
		return new MapTile(image, shape);
	}

}
