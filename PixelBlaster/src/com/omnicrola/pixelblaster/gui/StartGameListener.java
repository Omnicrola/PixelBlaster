package com.omnicrola.pixelblaster.gui;

import com.omnicrola.pixelblaster.main.MainGameState;
import com.omnicrola.pixelblaster.main.PixelBlasterGame;

public class StartGameListener implements IEventListener {

	private final PixelBlasterGame game;
	private final MainGameState mainState;

	public StartGameListener(PixelBlasterGame game, MainGameState mainState) {
		this.game = game;
		this.mainState = mainState;
	}

	@Override
	public void trigger() {
		this.game.setState(this.mainState);
	}

}
