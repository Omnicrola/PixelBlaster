package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.physics.IModifierToken;

public class PlayerModel {

	private MultiStateEntity playerEntity;
	private boolean isBubbled;
	private IModifierToken modifierToken;

	public PlayerModel() {
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

}
