package com.omnicrola.pixelblaster.player;


public class PlayerModel {

	private MultiStateEntity playerEntity;

	public PlayerModel() {
	}

	public void setEntity(MultiStateEntity playerEntity) {
		this.playerEntity = playerEntity;
	}

	public MultiStateEntity getEntity() {
		return this.playerEntity;
	}

}
