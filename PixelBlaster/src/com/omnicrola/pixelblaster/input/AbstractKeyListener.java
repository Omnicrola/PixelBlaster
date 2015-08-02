package com.omnicrola.pixelblaster.input;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public abstract class AbstractKeyListener implements KeyListener {

	protected boolean isAcceptingInput;

	@Override
	public void setInput(Input input) {
	}

	@Override
	public boolean isAcceptingInput() {
		return this.isAcceptingInput;
	}

	@Override
	public void inputEnded() {
	}

	@Override
	public void inputStarted() {
	}

	@Override
	public void keyPressed(int key, char c) {
	}

	@Override
	public void keyReleased(int key, char c) {
	}

}
