package com.omnicrola.pixelblaster.entity;

import com.omnicrola.pixelblaster.entity.behavior.IBehavior;

public interface IUpdateBehavior extends IBehavior {
	public void update(IGameEntity entity, float delta);
}
