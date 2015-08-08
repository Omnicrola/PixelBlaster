package com.omnicrola.pixelblaster.map.io;

import com.omnicrola.pixelblaster.entity.build.EntityType;
import com.omnicrola.pixelblaster.map.EntityData;
import com.omnicrola.pixelblaster.map.MapBounds;
import com.omnicrola.pixelblaster.util.Coordinate;

@SuppressWarnings("unused")
public class MapCreator {
	private final XmlMapWriter xmlMapWriter;
	private final XmlMapData mapData;

	public static void main(String[] args) {
		System.out.println("Map Creator starting");
		final MapCreator mapCreator = new MapCreator();
		System.out.println("generating...");
		mapCreator.generate();
		System.out.println("saving...");
		mapCreator.save("assets/Levels/level1.map");
		System.out.println("Done.");
	}

	public MapCreator() {
		this.xmlMapWriter = new XmlMapWriter();
		this.mapData = new XmlMapData();
	}

	private void save(String filename) {
		this.xmlMapWriter.write(filename, this.mapData);
	}

	private void generate() {
		this.mapData.title = "Test Level 1:";
		this.mapData.subtitle = "Purple Destiny";
		this.mapData.mapHeight = 11;
		this.mapData.mapWidth = 128;
		this.mapData.mapBounds = new MapBounds(0, 0, 100, 128);
		this.mapData.playerSpawn = new Coordinate(8, 4);
		fillArea(0, 5, 127, 10, CENTER);
		fillArea(0, 5, 127, 5, FULL_MID);
		tileSequence(10, 5, new int[] { 14, 0, 0, 0, 15, 1, 1, 14, 0, 15, 1, 1, 0, 0, 11, 12, 13, 0, 0, 15 });
		addPowerups();
		createEntities();

	}

	private void createEntities() {
		final EntityData entityData = new EntityData();
		entityData.entityType = EntityType.BEE;
		entityData.position = new Coordinate(10, 3);
		this.mapData.entities.add(entityData);
	}

	private void addPowerups() {
		for (int i = 0; i < 20; i++) {
			this.mapData.powerups.add(bubblePowerup(10.5f + i, 3.75f));
		}
	}

	private PowerupData bubblePowerup(float x, float y) {
		final PowerupData powerupData = new PowerupData();
		final float size = 0.5f;
		powerupData.width = size;
		powerupData.height = size;
		powerupData.image = "bubble.png";
		powerupData.x = x;
		powerupData.y = y;
		return powerupData;
	}

	private void fillArea(int x1, int y1, int x2, int y2, int tileIndex) {
		for (int x = x1; x <= x2; x++) {
			for (int y = y1; y <= y2; y++) {
				addTile(x, y, tileIndex);
			}

		}
	}

	private void addTile(int x, int y, int tileIndex) {
		this.mapData.mapTiles.add(new XmlMapTileData(x, y, tileIndex));
	}

	private void tileSequence(int x, int y, int[] tiles) {
		for (int i = 0; i < tiles.length; i++) {
			addTile(x + i, y, tiles[i]);
		}
	}

	private static final int AIR = 0;
	private static final int FULL = 1;
	private static final int CENTER = 2;
	private static final int CENTER_ROUND = 3;
	private static final int CLIFF_LEFT = 4;
	private static final int CLIFF_RIGHT = 5;
	private static final int CLIFF_ALT_LEFT = 6;
	private static final int CLIFF_ALT_RIGHT = 7;
	private static final int CORNER_LEFT = 8;
	private static final int CORNER_RIGHT = 9;
	private static final int HALF = 10;
	private static final int HALF_LEFT = 11;
	private static final int HALF_MID = 12;
	private static final int HALF_RIGHT = 13;
	private static final int HILL_LEFT = 14;
	private static final int HILL_RIGHT = 15;
	private static final int FULL_LEFT = 16;
	private static final int FULL_MID = 17;
	private static final int FULL_RIGHT = 18;

}
