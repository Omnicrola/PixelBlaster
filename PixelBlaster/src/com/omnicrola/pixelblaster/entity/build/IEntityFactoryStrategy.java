package com.omnicrola.pixelblaster.entity.build;

import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.graphics.SpriteBuilder;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;

public interface IEntityFactoryStrategy {

	IEntitySprite buildSprite(SpriteBuilder spriteBuilder);

	IPhysicsEntity buildPhysics(IPhysicsManager physicsManager);

}
