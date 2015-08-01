package com.omnicrola.pixelblaster.player;

import java.util.ArrayList;
import java.util.List;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.behavior.SlaveEntityBehavior;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;

public class Bubble extends MultiStateEntity {

	private final List<IGameEntity> containedEntities;
	private final SlaveEntityBehavior synchPosition;

	public Bubble(MultiStateSprite sprite, IPhysicsEntity physics) {
		super(sprite, physics);
		this.containedEntities = new ArrayList<>();
		this.synchPosition = new SlaveEntityBehavior(this);
	}

	public void containEntity(IGameEntity entityInBubble) {
		this.setPosition(entityInBubble.getPosition());
		this.setVelocity(entityInBubble.getVelocity());
		entityInBubble.disablePhysics();
		entityInBubble.addUpdateBehavior(this.synchPosition);
		this.containedEntities.add(entityInBubble);
	}

	public void releaseEntity(IGameEntity entity) {
		if (this.containedEntities.contains(entity)) {
			this.containedEntities.remove(entity);
			entity.enablePhysics();
			entity.removeUpdateBehavior(this.synchPosition);
			entity.setVelocity(this.getVelocity());
			entity.setPosition(this.getPosition());
		}
	}
}
