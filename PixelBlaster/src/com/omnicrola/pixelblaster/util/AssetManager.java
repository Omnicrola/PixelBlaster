package com.omnicrola.pixelblaster.util;

import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.omnicrola.pixelblaster.audio.IAudioResource;
import com.omnicrola.pixelblaster.audio.ISound;
import com.omnicrola.pixelblaster.audio.NullSound;
import com.omnicrola.pixelblaster.audio.SoundWrapper;
import com.omnicrola.pixelblaster.io.XmlMapLoader;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.map.io.XmlMapData;

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

	public XmlMapData getMapData(int currentLevel) {
		final String filename = GameSettings.MAP_FILE_PATH + "level" + currentLevel + ".map";
		return this.xmlMapLoader.load(filename);
	}

	public ISound getSound(IAudioResource resource) {
		try {
			return new SoundWrapper(
					AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream(resource.getPath())));
		} catch (final IOException e) {
			e.printStackTrace();
			return NullSound.NULL;
		}
	}

}
