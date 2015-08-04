package com.omnicrola.pixelblaster.audio;

import java.util.HashMap;

public class AudioLibrary {

	private final HashMap<IAudioResource, ISound> soundMap;

	public AudioLibrary(HashMap<IAudioResource, ISound> soundMap) {
		this.soundMap = soundMap;
	}

	public void playSound(IAudioResource audioResource, float volume) {
		final ISound resource = this.soundMap.get(audioResource);
		if (resource != null) {
			resource.play(volume);
		}
	}
}
