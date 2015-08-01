package com.omnicrola.pixelblaster.entity.behavior;

import com.omnicrola.pixelblaster.entity.IGameEntity;

public interface IDeathBehavior extends IBehavior {
	public void entityDestroyed(IGameEntity destroyedEntity);
}
