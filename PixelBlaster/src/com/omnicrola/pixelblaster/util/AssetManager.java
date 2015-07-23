package com.omnicrola.pixelblaster.util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.io.XmlMapLoader;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.map.MapData;

public class AssetManager {
	private final XmlMapLoader xmlMapLoader;

	public AssetManager(XmlMapLoader xmlMapLoader) {
		this.xmlMapLoader = xmlMapLoader;

	}

	public Image getImage(String string) {
		try {
			return new Image(string);
		} catch (final SlickException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MapData getMapData(int currentLevel) {
		final String filename = GameSettings.MAP_FILE_PATH + "level" + currentLevel + ".map";
		return this.xmlMapLoader.load(filename);
	}

}
