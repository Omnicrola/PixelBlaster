package com.omnicrola.pixelblaster.audio;

public class NullSound implements ISound {
	public static final NullSound NULL = new NullSound();

	private NullSound() {
	}

	@Override
	public void play(float volume) {
	}
}
