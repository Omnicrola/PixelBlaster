package com.omnicrola.pixelblaster.map;

import java.util.List;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.graphics.SpriteBuilder;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;

public class EntityFactory {
	private final IEntityManager entityManager;
	private final SpriteBuilder spriteBuilder;
	private final IPhysicsManager physicsManager;

	public EntityFactory(SpriteBuilder spriteBuilder, IEntityManager entityManager, IPhysicsManager physicsManager) {
		this.spriteBuilder = spriteBuilder;
		this.entityManager = entityManager;
		this.physicsManager = physicsManager;
	}

	public void buildAll(float tileSize, List<EntityData> entities) {
		for (final EntityData entityData : entities) {
			buildEntity(tileSize, entityData);
		}
	}

	private void buildEntity(float tileSize, EntityData entityData) {
		final IEntitySprite sprite = this.spriteBuilder.build(entityData);
		final IPhysicsEntity physics = buildPhysics(entityData);
		final GameEntity gameEntity = new GameEntity(sprite, physics);
		final float x = entityData.position.getX() * tileSize;
		final float y = entityData.position.getY() * tileSize;
		final Vector2f position = new Vector2f(x, y);
		gameEntity.setPosition(position);
		this.entityManager.addEntity(gameEntity);
	}

	private IPhysicsEntity buildPhysics(EntityData entityData) {
		//@formatter:off
		final float size = entityData.width /2f;
		return this.physicsManager.getBuilder()
				.setDynamic()
				.density(1.0f)
				.disableRotation()
//				.addCircle(entityData.width/2f)
				.addRectangle(new Rectangle(0, 0, size, size))
				.build();
		//@formatter:on
	}

}
