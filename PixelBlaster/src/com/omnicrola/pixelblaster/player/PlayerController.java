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
		addPlayerState(PlayerState.WALK);
		player().setFacing(Facing.RIGHT);

	}

	public void moveLeft() {
		applyForce(-GameSettings.PLAYER_ACCELERATION, 0);
		addPlayerState(PlayerState.WALK);
		player().setFacing(Facing.LEFT);
	}

	public void stand() {
		removePlayerState(PlayerState.WALK);
		addPlayerState(PlayerState.STAND);

	}

	public void crouch() {
		applyForce(0, GameSettings.PLAYER_ACCELERATION);
		addPlayerState(PlayerState.DUCK);
	}

	public void uncrouch() {
		removePlayerState(PlayerState.DUCK);
	}

	public void bubble() {
		if (isBubbled()) {
			turnBubbleOff();
		} else {
			turnBubbleOn();
		}
	}

	private void turnBubbleOn() {
		final IModifierToken modifierToken = this.bubbleBuilder.envelop(player());
		addPlayerState(PlayerState.BUBBLE_BLUE);
		this.playerModel.setBubble(modifierToken);
	}

	private void turnBubbleOff() {
		this.playerModel.unBubble();
		removePlayerState(PlayerState.BUBBLE_BLUE);
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
			addPlayerState(PlayerState.JUMP);
		}
	}

	private void removePlayerState(PlayerState state) {
		player().removeState(state);
	}

	private void addPlayerState(PlayerState state) {
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

	public float getBubblePower() {
		return this.playerModel.getBubblePower();
	}

	public float getMaxBubblePower() {
		return this.playerModel.getMaxBubblePower();
	}

	public void update(float delta) {
		adjustBubblePower();
		checkIfBubbleShouldCollapse();
	}

	private void checkIfBubbleShouldCollapse() {
		final float bubblePower = this.playerModel.getBubblePower();
		if (isBubbled() && bubblePower <= 0) {
			turnBubbleOff();
		}
	}

	private void adjustBubblePower() {
		if (isBubbled()) {
			decreaseBubblePower(GameSettings.BUBBLE_POWER_USE_RATE);
		} else {
			increaseBubblePower(GameSettings.BUBBLE_POWER_REGEN_RATE);
		}
	}

	public void decreaseBubblePower(float decreaseAmount) {
		final float bubblePower = this.playerModel.getBubblePower();
		if (bubblePower > 0) {
			this.playerModel.setBubblePower(bubblePower - decreaseAmount);
		}
	}

	public void increaseBubblePower(float incrementAmount) {
		final float bubblePower = this.playerModel.getBubblePower();
		final float maxBubblePower = this.playerModel.getMaxBubblePower();
		if (bubblePower < maxBubblePower) {
			this.playerModel.setBubblePower(bubblePower + incrementAmount);
		}
	}

}
