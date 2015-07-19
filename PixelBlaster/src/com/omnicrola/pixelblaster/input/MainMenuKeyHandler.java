package com.omnicrola.pixelblaster.input;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

import com.omnicrola.pixelblaster.gui.MainMenu;

public class MainMenuKeyHandler implements KeyListener {

	private final MainMenu menu;

	public MainMenuKeyHandler(MainMenu menu) {
		this.menu = menu;
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
			this.menu.selectCurrent();
		} else if (key == Keyboard.KEY_UP) {
			this.menu.moveUp();
		} else if (key == Keyboard.KEY_DOWN) {
			this.menu.moveDown();
		}
	}

	@Override
	public void keyReleased(int key, char c) {
	}

}
