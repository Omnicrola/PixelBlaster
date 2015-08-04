package com.omnicrola.pixelblaster.audio;

public class AudioController {

	private final AudioLibrary audioLibrary;

	public AudioController(AudioLibrary audioLibrary) {
		this.audioLibrary = audioLibrary;
	}

	public void playSound(IAudioResource audioResource, float volume) {
		this.audioLibrary.playSound(audioResource, volume);
	}

}
