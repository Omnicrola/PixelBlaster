package com.omnicrola.pixelblaster.map;

import java.util.List;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.entity.build.EntityStrategies;
import com.omnicrola.pixelblaster.entity.build.IEntityFactoryStrategy;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.graphics.SpriteBuilder;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
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
		final IEntitySprite sprite = factoryStrategy.buildSprite(this.spriteBuilder);
		final IPhysicsEntity physics = factoryStrategy.buildPhysics(this.physicsManager);
		final GameEntity gameEntity = new GameEntity(sprite, physics);
		setPosition(entityData.position, gameEntity, tileSize);
		this.entityManager.addEntity(gameEntity);

	}

	private void setPosition(Coordinate position, GameEntity gameEntity, float tileSize) {
		final float x = position.getX() * tileSize;
		final float y = position.getY() * tileSize;
		gameEntity.setPosition(new Vector2f(x, y));
	}

}
