package com.omnicrola.pixelblaster.player;

import java.util.ArrayList;
import java.util.List;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;

public class Bubble extends GameEntity {

	private final List<IGameEntity> containedEntities;

	public Bubble(IEntitySprite sprite, IPhysicsEntity physics) {
		super(sprite, physics);
		this.containedEntities = new ArrayList<>();
	}

	public void containEntity(IGameEntity entityInBubble) {
		entityInBubble.getPhysics().disable();
		this.containedEntities.add(entityInBubble);
	}

}
