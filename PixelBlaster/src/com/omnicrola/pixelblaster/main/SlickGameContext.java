package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class SlickGameContext implements IGameContext {

	private final GameSubsystemInterlink interlink;
	private final GameContainer container;

	public SlickGameContext(GameSubsystemInterlink interlink, GameContainer container) {
		this.interlink = interlink;
		this.container = container;
	}

	@Override
	public <T> T getSubsystem(Class<T> key) {
		return this.interlink.getSubsystem(key);
	}

	@Override
	public Input getInput() {
		return this.container.getInput();
	}

}
