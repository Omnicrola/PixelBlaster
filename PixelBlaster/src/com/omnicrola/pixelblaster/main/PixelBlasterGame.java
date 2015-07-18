package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class PixelBlasterGame extends BasicGame {

	private IGameState newState;
	private IGameState state;
	private boolean changeState;

	public PixelBlasterGame() {
		super("Pixel Blaster");
		this.state = NullGameState.NULL;
	}

	public void setState(IGameState state) {
		this.newState = state;
		this.changeState = true;
	}

	@Override
	public void init(GameContainer container) throws SlickException {
	}

	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
		this.state.render(container, graphics);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (this.changeState) {
			this.state = this.newState;
			this.state.init(container);
		}
		this.state.update(container, delta);
	}

}
