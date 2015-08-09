package com.omnicrola.pixelblaster.map.io;

import java.util.HashMap;
import java.util.Map;

import com.omnicrola.pixelblaster.audio.IAudioManager;
import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.entity.build.BeeFactoryStrategy;
import com.omnicrola.pixelblaster.entity.build.EntityStrategies;
import com.omnicrola.pixelblaster.entity.build.EntityType;
import com.omnicrola.pixelblaster.entity.build.IEntityFactoryStrategy;
import com.omnicrola.pixelblaster.graphics.SpriteBuilder;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.map.EntityFactory;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.player.IPlayerManager;
import com.omnicrola.pixelblaster.powerups.ContactSensorBuilder;
import com.omnicrola.pixelblaster.powerups.PowerupPhysicsFactory;
import com.omnicrola.pixelblaster.util.AssetManager;

public class MapTemplateReaderBuilder {

	public MapTemplateReader build(IGameContext context) {
		final IAudioManager audioManager = context.getSubsystem(IAudioManager.class);
		final IPlayerManager playerManager = context.getSubsystem(IPlayerManager.class);
		final IPhysicsManager physicsManager = context.getSubsystem(IPhysicsManager.class);
		final AssetManager assetManager = context.getAssetManager();
		final IEntityManager entityManager = context.getSubsystem(IEntityManager.class);

		final ContactSensorBuilder sensorBuilder = new ContactSensorBuilder(audioManager, playerManager);
		final PowerupPhysicsFactory powerupPhysicsBuilder = new PowerupPhysicsFactory(physicsManager);
		final SpriteBuilder spriteBuilder = new SpriteBuilder(assetManager);
		final PowerupFactory powerupFactory = new PowerupFactory(entityManager, spriteBuilder, powerupPhysicsBuilder,
				sensorBuilder);
		final EntityStrategies entityStrategies = buildEntityStrategies(context);
		final EntityFactory entityFactory = new EntityFactory(spriteBuilder, entityManager, physicsManager,
				entityStrategies);

		final MapTemplateReader mapTemplateReader = new MapTemplateReader(assetManager, physicsManager, powerupFactory,
				entityFactory);
		return mapTemplateReader;
	}

	private EntityStrategies buildEntityStrategies(IGameContext context) {
		final IPlayerManager playerManager = context.getSubsystem(IPlayerManager.class);

		final Map<EntityType, IEntityFactoryStrategy> factoryStrategies = new HashMap<>();
		factoryStrategies.put(EntityType.BEE, new BeeFactoryStrategy(playerManager));
		final EntityStrategies entityStrategies = new EntityStrategies(factoryStrategies);
		return entityStrategies;
	}

}
