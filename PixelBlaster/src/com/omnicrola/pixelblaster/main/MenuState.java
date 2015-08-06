package com.omnicrola.pixelblaster.main;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import com.omnicrola.pixelblaster.audio.AudioMusic;
import com.omnicrola.pixelblaster.graphics.Camera;
import com.omnicrola.pixelblaster.graphics.SlickGraphicsWrapper;
import com.omnicrola.pixelblaster.gui.MainMenu;
import com.omnicrola.pixelblaster.gui.MainMenuBuilder;
import com.omnicrola.pixelblaster.input.MainMenuKeyHandler;

public class MenuState extends BasicGameState {

	private MainMenu menu;
	private final MainMenuBuilder menuBuilder;
	private Audio titleMusic;
	private MainMenuKeyHandler keyHandler;

	public MenuState(MainMenuBuilder menuBuilder) {
		this.menuBuilder = menuBuilder;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		playTitleMusic(AudioMusic.TITLE_IDENT);
		this.menu = this.menuBuilder.build(game);
		this.keyHandler = new MainMenuKeyHandler(this.menu);
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		this.titleMusic.playAsMusic(1.0f, 1.0f, false);
		container.getInput().addKeyListener(this.keyHandler);
	}

	@Override
	public void leave(GameContainer container, StateBasedGame game) throws SlickException {
		container.getInput().removeKeyListener(this.keyHandler);
		this.titleMusic.stop();
	}

	private void playTitleMusic(AudioMusic audioResource) {
		try {
			this.titleMusic = AudioLoader.getStreamingAudio("OGG", ResourceLoader.getResource(audioResource.getPath()));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		AudioLoader.update();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException {
		final Camera camera = new Camera(1.0f, container.getWidth(), container.getHeight());
		final SlickGraphicsWrapper slickGraphicsWrapper = new SlickGraphicsWrapper(camera, graphics);
		this.menu.render(slickGraphicsWrapper, 0, 0);
	}

	@Override
	public int getID() {
		return GameStates.MAIN_MENU.ordinal();
	}

}
