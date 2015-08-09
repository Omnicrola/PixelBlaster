package com.omnicrola.pixelblaster.entity.build;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.graphics.SpriteBuilder;
import com.omnicrola.pixelblaster.map.EntityData;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;

public interface IEntityFactoryStrategy {

	IGameEntity buildEntity(EntityData entityData, SpriteBuilder spriteBuilder, IPhysicsManager physicsManager);

}
