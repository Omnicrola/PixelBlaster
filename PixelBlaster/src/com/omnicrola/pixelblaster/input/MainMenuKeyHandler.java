package com.omnicrola.pixelblaster.input;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

import com.omnicrola.pixelblaster.main.MainGameState;
import com.omnicrola.pixelblaster.main.PixelBlasterGame;

public class MainMenuKeyHandler implements KeyListener {

	private final PixelBlasterGame game;
	private final MainGameState mainGameState;

	public MainMenuKeyHandler(PixelBlasterGame game, MainGameState mainGameState) {
		this.game = game;
		this.mainGameState = mainGameState;
	}

	@Override
	public void setInput(Input input) {
	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void inputEnded() {
	}

	@Override
	public void inputStarted() {
	}

	@Override
	public void keyPressed(int key, char c) {
		if (key == Keyboard.KEY_RETURN) {
			this.game.setState(this.mainGameState);
		}
	}

	@Override
	public void keyReleased(int key, char c) {
	}

}
