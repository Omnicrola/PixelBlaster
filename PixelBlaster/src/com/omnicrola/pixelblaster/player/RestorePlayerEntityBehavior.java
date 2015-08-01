package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.behavior.IDeathBehavior;

public class RestorePlayerEntityBehavior implements IDeathBehavior {

	private final PlayerModel playerModel;
	private final MultiStateEntity playerEntity;

	public RestorePlayerEntityBehavior(PlayerModel playerModel, MultiStateEntity playerEntity) {
		this.playerModel = playerModel;
		this.playerEntity = playerEntity;
	}

	@Override
	public void entityDestroyed(IGameEntity destroyedEntity) {
		this.playerModel.setEntity(this.playerEntity);
	}

}
