package com.omnicrola.pixelblaster.audio;

import org.newdawn.slick.Sound;

public class SoundWrapper implements ISound {

	private final Sound sound;

	public SoundWrapper(Sound sound) {
		this.sound = sound;
	}

	@Override
	public void play(float volume) {
		this.sound.play(1.0f, volume);
	}
}
