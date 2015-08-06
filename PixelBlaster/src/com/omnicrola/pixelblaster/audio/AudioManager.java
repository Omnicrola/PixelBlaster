package com.omnicrola.pixelblaster.audio;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.AudioLoader;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class AudioManager implements IGameSubsystem, IAudioManager {
	private AudioController audioController;
	private final AudioLibraryLoader audioLibraryLoader;

	public AudioManager(AudioLibraryLoader audioLibraryLoader) {
		this.audioLibraryLoader = audioLibraryLoader;
	}

	@Override
	public IAudioController getAudioController() {
		return this.audioController;
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IAudioManager.class, this);
	}

	@Override
	public void init(IGameContext context) throws SlickException {
		final AudioLibrary audioLibrary = this.audioLibraryLoader.load(context.getAssetManager());
		this.audioController = new AudioController(audioLibrary);

	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		AudioLoader.update();
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

	@Override
	public void enter(IGameContext context) {
		this.audioController.resume();
	}

	@Override
	public void leave(IGameContext context) {
		this.audioController.pause();
	}

}
