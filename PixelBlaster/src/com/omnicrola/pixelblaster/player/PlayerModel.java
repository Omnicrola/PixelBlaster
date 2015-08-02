package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.physics.IModifierToken;

public class PlayerModel {

	private MultiStateEntity playerEntity;
	private boolean isBubbled;
	private IModifierToken modifierToken;
	private float bubblePower;
	private final float maxBubblePower;

	public PlayerModel() {
		this.maxBubblePower = 100.0f;
		this.bubblePower = 5.0f;
		this.isBubbled = false;
	}

	public void setEntity(MultiStateEntity playerEntity) {
		this.playerEntity = playerEntity;
	}

	public MultiStateEntity getEntity() {
		return this.playerEntity;
	}

	public boolean isBubbled() {
		return this.isBubbled;
	}

	public void setBubble(IModifierToken modifierToken) {
		this.modifierToken = modifierToken;
		this.isBubbled = true;
	}

	public void unBubble() {
		this.modifierToken.destroy();
		this.isBubbled = false;
	}

	public float getBubblePower() {
		return this.bubblePower;
	}

	public float getMaxBubblePower() {
		return this.maxBubblePower;
	}

	public void setBubblePower(float power) {
		this.bubblePower = power;
	}

}
