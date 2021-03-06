package com.omnicrola.pixelblaster.map;

import java.util.List;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.build.EntityStrategies;
import com.omnicrola.pixelblaster.entity.build.IEntityFactoryStrategy;
import com.omnicrola.pixelblaster.graphics.SpriteBuilder;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.util.Coordinate;

public class EntityFactory {
	private final IEntityManager entityManager;
	private final SpriteBuilder spriteBuilder;
	private final IPhysicsManager physicsManager;
	private final EntityStrategies entityStrategies;

	public EntityFactory(SpriteBuilder spriteBuilder, IEntityManager entityManager, IPhysicsManager physicsManager,
			EntityStrategies entityStrategies) {
		this.spriteBuilder = spriteBuilder;
		this.entityManager = entityManager;
		this.physicsManager = physicsManager;
		this.entityStrategies = entityStrategies;
	}

	public void buildAll(float tileSize, List<EntityData> entities) {
		for (final EntityData entityData : entities) {
			buildEntity(tileSize, entityData);
		}
	}

	private void buildEntity(float tileSize, EntityData entityData) {
		final IEntityFactoryStrategy factoryStrategy = this.entityStrategies.getStrategy(entityData.entityType);
		final IGameEntity gameEntity = factoryStrategy.buildEntity(entityData, this.spriteBuilder, this.physicsManager);
		setPosition(entityData.position, gameEntity, tileSize);
		this.entityManager.addEntity(gameEntity);

	}

	private void setPosition(Coordinate position, IGameEntity gameEntity, float tileSize) {
		final float x = position.getX() * tileSize;
		final float y = position.getY() * tileSize;
		gameEntity.setPosition(new Vector2f(x, y));
	}

}
