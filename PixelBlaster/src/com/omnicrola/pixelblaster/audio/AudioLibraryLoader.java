package com.omnicrola.pixelblaster.audio;

import java.util.HashMap;

import com.omnicrola.pixelblaster.util.AssetManager;

public class AudioLibraryLoader {
	public AudioLibraryLoader() {
	}

	public AudioLibrary load(AssetManager assetManager) {
		final HashMap<IAudioResource, ISound> soundMap = new HashMap<>();
		addSound(AudioFx.SPLASH, assetManager, soundMap);
		addSound(AudioFx.JUMP, assetManager, soundMap);
		return new AudioLibrary(soundMap);
	}

	private void addSound(AudioFx resource, AssetManager assetManager, final HashMap<IAudioResource, ISound> soundMap) {
		soundMap.put(resource, assetManager.getSound(resource));
	}

}
