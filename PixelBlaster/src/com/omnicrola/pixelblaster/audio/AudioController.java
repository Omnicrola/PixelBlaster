package com.omnicrola.pixelblaster.audio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AudioController implements IAudioController {

	private final AudioLibrary audioLibrary;
	private final List<ISound> playingSounds;

	public AudioController(AudioLibrary audioLibrary) {
		this.audioLibrary = audioLibrary;
		this.playingSounds = new ArrayList<>();
	}

	@Override
	public void playSound(IAudioResource audioResource, float volume) {
		final ISound sound = this.audioLibrary.getSound(audioResource, volume);
		sound.play(volume);
		this.playingSounds.add(sound);
	}

	public void update() {
		final Iterator<ISound> iterator = this.playingSounds.iterator();
		while (iterator.hasNext()) {
			final ISound sound = iterator.next();
			if (sound.isFinished()) {
				iterator.remove();
			}
		}
	}

	public void pause() {
		for (final ISound sound : this.playingSounds) {
			sound.pause();
		}
	}

	public void resume() {
		for (final ISound sound : this.playingSounds) {
			sound.resume();
		}
	}

}
