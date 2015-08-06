package com.omnicrola.pixelblaster.audio;

public interface ISound {

	void play(float volume);

	boolean isFinished();

	void pause();

	void resume();

}
