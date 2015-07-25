package com.omnicrola.pixelblaster.player;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

import com.omnicrola.pixelblaster.entity.MultiStateSprite.Facing;
import com.omnicrola.pixelblaster.entity.MultiStateSprite.State;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.physics.PhysicsWrapper;

public class PlayerKeyListener implements KeyListener {

	private boolean moveLeft;
	private boolean moveRight;
	private boolean moveUp;
	private boolean moveDown;
	private boolean isJumping;
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
		final PhysicsWrapper physics = this.player.getPhysics();
		if (this.moveRight) {
			physics.moveRight(GameSettings.PLAYER_ACCELERATION);
			setPlayerState(State.WALK);
			this.player.getMultistateSprite().setFacing(Facing.RIGHT);
		}
		if (this.moveLeft) {
			physics.moveLeft(GameSettings.PLAYER_ACCELERATION);
			setPlayerState(State.WALK);
			this.player.getMultistateSprite().setFacing(Facing.LEFT);
		}
		if (!this.moveLeft && !this.moveRight) {
			removePlayerState(State.WALK);
			setPlayerState(State.STAND);
		}
		if (this.moveUp) {
			physics.moveUp(GameSettings.PLAYER_ACCELERATION);
		}
		if (this.moveDown) {
			physics.moveDown(GameSettings.PLAYER_ACCELERATION);
			setPlayerState(State.DUCK);
		} else {
			removePlayerState(State.DUCK);
		}
		if (this.isJumping) {
			physics.jump(GameSettings.PLAYER_JUMP_SPEED);
			setPlayerState(State.JUMP);
			this.isJumping = false;
		}
	}

	private void removePlayerState(State state) {
		this.player.getMultistateSprite().removeState(state);
		;
	}

	private void setPlayerState(State state) {
		this.player.getMultistateSprite().setState(state);
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
		}
	}

}
