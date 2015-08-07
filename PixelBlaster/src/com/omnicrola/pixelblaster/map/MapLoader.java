package com.omnicrola.pixelblaster.map;

import java.util.HashMap;

import com.omnicrola.pixelblaster.map.io.LevelMapTemplate;

public class MapLoader {
	private final HashMap<Integer, LevelMapTemplate> templates;

	public MapLoader(HashMap<Integer, LevelMapTemplate> templates) {
		this.templates = templates;
	}

	public ILevelMap load(int currentLevel) {
		return this.templates.get(currentLevel).load();
	}

}
