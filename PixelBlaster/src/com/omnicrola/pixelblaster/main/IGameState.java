package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface IGameState {

	public abstract void update(GameContainer container, float delta) throws SlickException;

	public abstract void render(GameContainer container, Graphics graphics) throws SlickException;

	public abstract void init(GameContainer container) throws SlickException;

}
