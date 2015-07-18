package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.input.MainMenuKeyHandler;

public class MenuState implements IGameState {

	private final MainGameState mainGameState;
	private final PixelBlasterGame game;

	public MenuState(PixelBlasterGame game, MainGameState mainGameState) {
		this.game = game;
		this.mainGameState = mainGameState;
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		final MainMenuKeyHandler keyHandler = new MainMenuKeyHandler(this.game, this.mainGameState);
		container.getInput().addKeyListener(keyHandler);
	}

	@Override
	public void update(GameContainer container, float delta) throws SlickException {
	}

	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
		graphics.drawString("Main Menu", 100, 100);
	}

}
