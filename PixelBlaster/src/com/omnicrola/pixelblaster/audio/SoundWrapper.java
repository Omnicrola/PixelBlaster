package com.omnicrola.pixelblaster.audio;

import org.newdawn.slick.openal.Audio;

public class SoundWrapper implements ISound {

	private final Audio sound;
	private float pausePosition;
	private final float pitch;
	private float gain;

	public SoundWrapper(Audio audio) {
		this.sound = audio;
		this.pitch = 1.0f;
	}

	@Override
	public void play(float volume) {
		this.gain = volume;
		this.sound.playAsSoundEffect(this.pitch, this.gain, false);
	}

	@Override
	public boolean isFinished() {
		return this.sound.isPlaying();
	}

	@Override
	public void pause() {
		this.pausePosition = this.sound.getPosition();
		this.sound.stop();
	}

	@Override
	public void resume() {
		this.sound.setPosition(this.pausePosition);
		this.sound.playAsSoundEffect(this.pitch, this.gain, false);
	}
}
