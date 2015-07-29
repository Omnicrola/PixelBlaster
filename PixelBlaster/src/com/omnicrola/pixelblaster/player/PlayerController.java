package com.omnicrola.pixelblaster.player;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.BubbleFactory;
import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;

public class PlayerController {
	private final PlayerModel playerModel;
	private final Vector2f cacheVector;
	private boolean isInMidAir;
	private boolean hasDoubleJumped;
	private final BubbleFactory bubbleFactory;
	private final IEntityManager entityManager;

	public PlayerController(IEntityManager entityManager, PlayerModel playerModel, BubbleFactory bubbleFactory) {
		this.entityManager = entityManager;
		this.playerModel = playerModel;
		this.bubbleFactory = bubbleFactory;
		this.cacheVector = new Vector2f();

	}

	public void moveRight() {
		applyForce(GameSettings.PLAYER_ACCELERATION, 0);
		setPlayerState(PlayerState.WALK);
		sprite().setFacing(Facing.RIGHT);

	}

	public void moveLeft() {
		applyForce(-GameSettings.PLAYER_ACCELERATION, 0);
		setPlayerState(PlayerState.WALK);
		sprite().setFacing(Facing.LEFT);
	}

	public void stand() {
		removePlayerState(PlayerState.WALK);
		setPlayerState(PlayerState.STAND);

	}

	public void crouch() {
		applyForce(0, -GameSettings.PLAYER_ACCELERATION);
		setPlayerState(PlayerState.DUCK);
	}

	public void uncrouch() {
		removePlayerState(PlayerState.DUCK);
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
		sprite().removeState(state);
	}

	private void setPlayerState(PlayerState state) {
		sprite().addState(state);
	}

	private MultiStateSprite sprite() {
		return this.playerModel.getEntity().getMultistateSprite();
	}

	public void bubble() {
		final Bubble bubble = this.bubbleFactory.createBubble(this.playerModel.getEntity());
		this.entityManager.addEntity(bubble);
	}

	private void applyImpulse(float forceX, float forceY) {
		this.cacheVector.set(forceX, forceY);
		physics().applyImpulseAtCenter(this.cacheVector);
	}

	private void applyForce(float forceX, float forceY) {
		this.cacheVector.set(forceX, forceY);
		physics().applyForceAtCenter(this.cacheVector);
	}

	private IPhysicsEntity physics() {
		return this.playerModel.getEntity().getPhysics();
	}

	public void clearJump() {
		this.isInMidAir = false;
		this.hasDoubleJumped = false;
		sprite().removeState(PlayerState.JUMP);
	}

}
