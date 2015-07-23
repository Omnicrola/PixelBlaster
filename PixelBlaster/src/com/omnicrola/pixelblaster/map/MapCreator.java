package com.omnicrola.pixelblaster.map;

public class MapCreator {
	private final XmlMapWriter xmlMapWriter;
	private final MapData mapData;

	public static void main(String[] args) {
		System.out.println("Map Creator starting");
		final MapCreator mapCreator = new MapCreator();
		System.out.println("generating...");
		mapCreator.generate();
		System.out.println("saving...");
		mapCreator.save("GeneratedMap.map");
		System.out.println("Done.");
	}

	public MapCreator() {
		this.xmlMapWriter = new XmlMapWriter();
		this.mapData = new MapData();
	}

	private void save(String filename) {
		this.xmlMapWriter.write(filename, this.mapData);
	}

	private void generate() {
		fillArea(0, 10, 128, 15, CENTER);
	}

	private void fillArea(int x1, int y1, int x2, int y2, int tileIndex) {
		for (int x = x1; x <= x2; x++) {
			for (int y = y1; y <= y2; y++) {
				addTile(x, y, tileIndex);
			}

		}
	}

	private void addTile(int x, int y, int tileIndex) {
		this.mapData.mapTiles.add(new MapTileData(x, y, tileIndex));
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
