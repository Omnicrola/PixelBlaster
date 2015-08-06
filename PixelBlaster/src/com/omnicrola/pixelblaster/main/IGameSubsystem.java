package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public interface IGameSubsystem {
	public void load(GameSubsystemInterlink interlink);

	public void init(IGameContext context) throws SlickException;

	public void enter(IGameContext context);

	public void leave(IGameContext context);

	public void update(IGameContext gameContext, float delta);

	public void render(IGraphicsWrapper graphics) throws SlickException;

}
