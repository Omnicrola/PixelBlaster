package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public interface IGameSubsystem {

	public void init(GameContainer container, GameSubsystemInterlink interlink);

	public void update(IGameContext gameContext, float delta);

	public void render(IGraphicsWrapper graphics);
}
