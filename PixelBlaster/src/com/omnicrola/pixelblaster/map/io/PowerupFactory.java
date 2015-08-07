package com.omnicrola.pixelblaster.map.io;

import java.util.List;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.graphics.SpriteBuilder;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.powerups.ContactSensorBuilder;
import com.omnicrola.pixelblaster.powerups.PowerupPhysicsFactory;

public class PowerupFactory {

	private final SpriteBuilder spriteBuilder;
	private final PowerupPhysicsFactory powerupPhysicsBuilder;
	private final ContactSensorBuilder sensorBuilder;
	private final IEntityManager entityManager;

	public PowerupFactory(IEntityManager entityManager, SpriteBuilder spriteBuilder,
			PowerupPhysicsFactory powerupPhysicsBuilder, ContactSensorBuilder sensorBuilder) {
		this.entityManager = entityManager;
		this.spriteBuilder = spriteBuilder;
		this.powerupPhysicsBuilder = powerupPhysicsBuilder;
		this.sensorBuilder = sensorBuilder;
	}

	public void buildAll(float tileSize, List<PowerupData> powerups) {
		for (final PowerupData powerupData : powerups) {
			createPowerup(powerupData, tileSize);
		}
	}

	private void createPowerup(PowerupData powerupData, float tileSize) {
		final IPhysicsEntity physics = this.powerupPhysicsBuilder.build(powerupData);
		final IEntitySprite sprite = this.spriteBuilder.build(powerupData);
		final GameEntity gameEntity = new GameEntity(sprite, physics);
		this.sensorBuilder.addPowerupSensor(powerupData, gameEntity, physics);

		adjustPosition(powerupData, gameEntity, tileSize);
		this.entityManager.addEntity(gameEntity);
	}

	private void adjustPosition(PowerupData powerupData, final GameEntity gameEntity, float tileSize) {
		final float x = tileSize * powerupData.x;
		final float y = tileSize * powerupData.y;
		gameEntity.setPosition(new Vector2f(x, y));
	}

}
