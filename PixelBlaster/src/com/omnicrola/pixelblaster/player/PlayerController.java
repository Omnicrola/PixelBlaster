package com.omnicrola.pixelblaster.player;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.BubbleBuilder;
import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.physics.IModifierToken;

public class PlayerController {
	private final PlayerModel playerModel;
	private final Vector2f cacheVector;
	private boolean isInMidAir;
	private boolean hasDoubleJumped;
	private final BubbleBuilder bubbleBuilder;

	public PlayerController(PlayerModel playerModel, BubbleBuilder bubbleBuilder) {
		this.playerModel = playerModel;
		this.bubbleBuilder = bubbleBuilder;
		this.cacheVector = new Vector2f();

	}

	public void moveRight() {
		applyForce(GameSettings.PLAYER_ACCELERATION, 0);
		setPlayerState(PlayerState.WALK);
		player().setFacing(Facing.RIGHT);

	}

	public void moveLeft() {
		applyForce(-GameSettings.PLAYER_ACCELERATION, 0);
		setPlayerState(PlayerState.WALK);
		player().setFacing(Facing.LEFT);
	}

	public void stand() {
		removePlayerState(PlayerState.WALK);
		setPlayerState(PlayerState.STAND);

	}

	public void crouch() {
		applyForce(0, GameSettings.PLAYER_ACCELERATION);
		setPlayerState(PlayerState.DUCK);
	}

	public void uncrouch() {
		removePlayerState(PlayerState.DUCK);
	}

	public void bubble() {
		if (isBubbled()) {
			this.playerModel.unBubble();
		} else {
			final IModifierToken modifierToken = this.bubbleBuilder.envelop(player());
			this.playerModel.setBubble(modifierToken);
		}
	}

	private boolean isBubbled() {
		return this.playerModel.isBubbled();
	}

	public void jump() {
		final boolean isNotInMidAir = !this.isInMidAir;
		final boolean hasNotDoubleJumped = !this.hasDoubleJumped;
		if (isNotInMidAir || hasNotDoubleJumped) {
			this.isInMidAir = true;
			if (this.isInMidAir && hasNotDoubleJumped) {
				this.hasDoubleJumped = true;
			}
			applyImpulse(0, -GameSettings.PLAYER_JUMP_SPEED);
			setPlayerState(PlayerState.JUMP);
		}
	}

	private void removePlayerState(PlayerState state) {
		player().removeState(state);
	}

	private void setPlayerState(PlayerState state) {
		player().addState(state);
	}

	private void applyImpulse(float forceX, float forceY) {
		this.cacheVector.set(forceX, forceY);
		player().applyImpulseAtCenter(this.cacheVector);
	}

	private void applyForce(float forceX, float forceY) {
		this.cacheVector.set(forceX, forceY);
		player().applyForceAtCenter(this.cacheVector);
	}

	private MultiStateEntity player() {
		return this.playerModel.getEntity();
	}

	public void clearJump() {
		this.isInMidAir = false;
		this.hasDoubleJumped = false;
		player().removeState(PlayerState.JUMP);
	}

}
