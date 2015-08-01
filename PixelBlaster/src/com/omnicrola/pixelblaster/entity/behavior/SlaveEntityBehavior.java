package com.omnicrola.pixelblaster.entity.behavior;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.IUpdateBehavior;

public class SlaveEntityBehavior implements IUpdateBehavior {

	private final IGameEntity sourceEntity;

	public SlaveEntityBehavior(IGameEntity entity) {
		this.sourceEntity = entity;
	}

	@Override
	public void update(IGameEntity targetEntity, float delta) {
		targetEntity.setPosition(this.sourceEntity.getPosition());
		targetEntity.setVelocity(new Vector2f());

	}

}
