package com.omnicrola.pixelblaster.player;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class PlayerKeyListener implements KeyListener {

	private boolean moveLeft;
	private boolean moveRight;
	private boolean moveUp;
	private boolean moveDown;
	private boolean isJumping;
	private boolean bubbleE;
	private final PlayerController playerController;

	public PlayerKeyListener(PlayerController playerController) {
		this.playerController = playerController;
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

	public void update(float delta) {
		moveDirection();
		if (this.isJumping) {
			this.playerController.jump();
			this.isJumping = false;
		}
		if (this.bubbleE) {
			this.playerController.bubble();
			this.bubbleE = false;
		}
	}

	private void moveDirection() {
		if (this.moveRight) {
			this.playerController.moveRight();
		}
		if (this.moveLeft) {
			this.playerController.moveLeft();
		}
		if (!this.moveLeft && !this.moveRight) {
			this.playerController.stand();
		}
		if (this.moveDown) {
			this.playerController.duck();
		}
	}

	@Override
	public void keyPressed(int key, char c) {
		if (key == Keyboard.KEY_RIGHT) {
			this.moveRight = true;
		} else if (key == Keyboard.KEY_LEFT) {
			this.moveLeft = true;
		} else if (key == Keyboard.KEY_UP) {
			this.moveUp = true;
		} else if (key == Keyboard.KEY_DOWN) {
			this.moveDown = true;
		} else if (key == Keyboard.KEY_SPACE) {
			this.isJumping = true;
		} else if (key == Keyboard.KEY_E) {
			this.bubbleE = true;
		}
	}

	@Override
	public void keyReleased(int key, char c) {
		if (key == Keyboard.KEY_RIGHT) {
			this.moveRight = false;
		} else if (key == Keyboard.KEY_LEFT) {
			this.moveLeft = false;
		} else if (key == Keyboard.KEY_UP) {
			this.moveUp = false;
		} else if (key == Keyboard.KEY_DOWN) {
			this.moveDown = false;
		} else if (key == Keyboard.KEY_SPACE) {
			this.isJumping = false;
		} else if (key == Keyboard.KEY_E) {
			this.bubbleE = false;
		}
	}

}
