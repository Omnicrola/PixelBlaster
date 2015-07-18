package com.omnicrola.pixelblaster.player;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.main.GameSettings;

public class PlayerKeyListener implements KeyListener {

	private static final float DAMPENING_THRESHOLD = 0.001f;
	boolean moveLeft;
	boolean moveRight;
	boolean isJumping;
	private final Player player;

	public PlayerKeyListener(Player player) {
		this.player = player;
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
		final Vector2f velocity = this.player.getVelocity();
		boolean noAction = true;
		if (this.moveRight) {
			accellerateRight(velocity, delta);
			noAction = false;
		}
		if (this.moveLeft) {
			accellerateLeft(velocity, delta);
			noAction = false;
		}
		if (this.isJumping) {
			jump(velocity, delta);
			noAction = false;
		}
		if (noAction) {
			decellerate(velocity);
		}
		dampening(velocity);
		this.player.setVelocity(velocity);
	}

	private void dampening(Vector2f velocity) {
		if (Math.abs(velocity.x) < DAMPENING_THRESHOLD) {
			velocity.x = 0;
		}
		if (Math.abs(velocity.y) < DAMPENING_THRESHOLD) {
			velocity.y = 0;
		}
	}

	@Override
	public void keyPressed(int key, char c) {
		if (key == Keyboard.KEY_RIGHT) {
			this.moveRight = true;
		} else if (key == Keyboard.KEY_LEFT) {
			this.moveLeft = true;
		} else if (key == Keyboard.KEY_SPACE) {
			this.isJumping = true;
		}
	}

	@Override
	public void keyReleased(int key, char c) {
		if (key == Keyboard.KEY_RIGHT) {
			this.moveRight = false;
		} else if (key == Keyboard.KEY_LEFT) {
			this.moveLeft = false;
		} else if (key == Keyboard.KEY_SPACE) {
			this.isJumping = false;
		}
	}

	private void jump(Vector2f velocity, float delta) {
		if (velocity.y == 0) {
			velocity.y = GameSettings.PLAYER_JUMP_SPEED * -1;
			this.isJumping = false;
		}
	}

	private void decellerate(Vector2f velocity) {
		if (velocity.length() > 0) {
			velocity.x *= GameSettings.PLAYER_DECELLERATION_SCALE;
		}
	}

	private void accellerateRight(Vector2f velocity, float delta) {
		if (velocity.length() < GameSettings.MAX_PLAYER_SPEED) {
			velocity.x += GameSettings.PLAYER_ACCELERATION * delta;
		}
	}

	private void accellerateLeft(Vector2f velocity, float delta) {
		if (velocity.length() < GameSettings.MAX_PLAYER_SPEED) {
			velocity.x -= GameSettings.PLAYER_ACCELERATION * delta;
		}
	}

}
