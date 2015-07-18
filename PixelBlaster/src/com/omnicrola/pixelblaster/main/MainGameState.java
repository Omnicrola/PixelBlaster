package com.omnicrola.pixelblaster.main;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.SlickGraphicsWrapper;

public class MainGameState implements IGameState {
	private final ArrayList<IGameSubsystem> subsystems;
	private boolean isInitialized = false;
	private final GameSubsystemInterlink interlink;

	public MainGameState() {
		this.subsystems = new ArrayList<>();
		this.interlink = new GameSubsystemInterlink();
	}

	public void addSubsystem(IGameSubsystem subsystem) {
		this.subsystems.add(subsystem);
		subsystem.load(this.interlink);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		final SlickGameContext gameContext = new SlickGameContext(this.interlink, container);
		if (!this.isInitialized) {
			for (final IGameSubsystem subsystem : this.subsystems) {
				subsystem.init(gameContext);
			}
			this.isInitialized = true;
		}
	}

	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
		for (final IGameSubsystem gameSubsystem : this.subsystems) {
			gameSubsystem.render(new SlickGraphicsWrapper(graphics));
		}
	}

	@Override
	public void update(GameContainer container, float delta) throws SlickException {
		final SlickGameContext gameContext = new SlickGameContext(this.interlink, container);
		for (final IGameSubsystem subsystem : this.subsystems) {
			subsystem.update(gameContext, delta);
		}
	}
}
