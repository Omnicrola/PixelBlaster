package com.omnicrola.pixelblaster.player;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.physics.CharacterPhysicsWrapper;

public class PlayerKeyListener implements KeyListener {

	private boolean moveLeft;
	private boolean moveRight;
	private boolean moveUp;
	private boolean moveDown;
	private boolean isJumping;
	private boolean bubbleE;
	private final Bubble bubble;
	private final CharacterPhysicsWrapper playerPhysics;
	private final MultiStateSprite playerSprite;
	private final Player player;

	public PlayerKeyListener(Player player) {
		this.playerPhysics = new CharacterPhysicsWrapper(player.getPhysics());
		this.playerSprite = player.getMultistateSprite();
		this.player = player;
		this.bubble = player.getBubble();
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
		handleJump();
		if (this.bubbleE) {
			this.bubble.toggle();
			this.bubbleE = false;
		}
	}

	private void moveDirection() {
		if (this.moveRight) {
			this.playerPhysics.moveRight(GameSettings.PLAYER_ACCELERATION);
			setPlayerState(PlayerState.WALK);
			this.playerSprite.setFacing(Facing.RIGHT);
		}
		if (this.moveLeft) {
			this.playerPhysics.moveLeft(GameSettings.PLAYER_ACCELERATION);
			setPlayerState(PlayerState.WALK);
			this.playerSprite.setFacing(Facing.LEFT);
		}
		if (!this.moveLeft && !this.moveRight) {
			removePlayerState(PlayerState.WALK);
			setPlayerState(PlayerState.STAND);
		}
		if (this.moveUp) {
			this.playerPhysics.moveUp(0);
		}
		if (this.moveDown) {
			this.playerPhysics.moveDown(GameSettings.PLAYER_ACCELERATION);
			setPlayerState(PlayerState.DUCK);
		} else {
			removePlayerState(PlayerState.DUCK);
		}
	}

	private void handleJump() {
		final boolean isInMidAir = this.player.isInMidAir();
		final boolean isNotInMidair = !isInMidAir;
		final boolean hasNotDoubleJumped = !this.player.hasDoubleJumped();
		if (this.isJumping && (isNotInMidair || hasNotDoubleJumped)) {
			this.playerPhysics.jump(GameSettings.PLAYER_JUMP_SPEED);
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
		this.player.getMultistateSprite().addState(state);
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
