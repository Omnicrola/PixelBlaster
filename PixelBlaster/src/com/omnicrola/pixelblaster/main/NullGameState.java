package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class NullGameState implements IGameState {

	public static final IGameState NULL = new NullGameState();

	private NullGameState() {
	}

	@Override
	public void update(GameContainer container, float delta) throws SlickException {
	}

	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
	}

	@Override
	public void init(GameContainer container) throws SlickException {
	}

}
