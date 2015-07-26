package com.omnicrola.pixelblaster.player;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.physics.IEntityPhysics;

public class PlayerKeyListener implements KeyListener {

	private boolean moveLeft;
	private boolean moveRight;
	private boolean moveUp;
	private boolean moveDown;
	private boolean isJumping;
	private final Player player;
	private boolean bubbleE;

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
		final IEntityPhysics physics = this.player.getPhysics();
		moveDirection(physics);
		handleJump(physics);
		if (this.bubbleE) {
			this.player.getBubble().turnOn(BubbleState.BLUE);
		} else {
			this.player.getBubble().turnOff();
		}
	}

	private void moveDirection(final IEntityPhysics physics) {
		if (this.moveRight) {
			physics.moveRight(GameSettings.PLAYER_ACCELERATION);
			setPlayerState(PlayerState.WALK);
			this.player.getMultistateSprite().setFacing(Facing.RIGHT);
		}
		if (this.moveLeft) {
			physics.moveLeft(GameSettings.PLAYER_ACCELERATION);
			setPlayerState(PlayerState.WALK);
			this.player.getMultistateSprite().setFacing(Facing.LEFT);
		}
		if (!this.moveLeft && !this.moveRight) {
			removePlayerState(PlayerState.WALK);
			setPlayerState(PlayerState.STAND);
		}
		if (this.moveUp) {
			physics.moveUp(0);
		}
		if (this.moveDown) {
			physics.moveDown(GameSettings.PLAYER_ACCELERATION);
			setPlayerState(PlayerState.DUCK);
		} else {
			removePlayerState(PlayerState.DUCK);
		}
	}

	private void handleJump(final IEntityPhysics physics) {
		final boolean isInMidAir = this.player.isInMidAir();
		final boolean isNotInMidair = !isInMidAir;
		final boolean hasNotDoubleJumped = !this.player.hasDoubleJumped();
		if (this.isJumping && (isNotInMidair || hasNotDoubleJumped)) {
			physics.jump(GameSettings.PLAYER_JUMP_SPEED);
			setPlayerState(PlayerState.JUMP);
			this.player.setInMidAir(true);
			if (isInMidAir && hasNotDoubleJumped) {
				this.player.setHasDoubleJumped(true);
			}
			this.isJumping = false;
		}
	}

	private void removePlayerState(PlayerState state) {
		this.player.getMultistateSprite().removeState(state);
		;
	}

	private void setPlayerState(PlayerState state) {
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
