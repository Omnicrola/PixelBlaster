package com.omnicrola.pixelblaster.entity.behavior;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.IUpdateBehavior;

public class SynchEntityPosition implements IUpdateBehavior {

	private final IGameEntity targetEntity;
	private final Vector2f offset;

	public SynchEntityPosition(IGameEntity entity, Vector2f offset) {
		this.targetEntity = entity;
		this.offset = offset;
	}

	@Override
	public void update(IGameEntity entity, float delta) {
		final Vector2f position = entity.getPosition();
		position.x += this.offset.x;
		position.y += this.offset.y;
		this.targetEntity.setPosition(position);
	}

}
