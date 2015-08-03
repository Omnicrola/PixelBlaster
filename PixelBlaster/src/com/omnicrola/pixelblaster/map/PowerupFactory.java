package com.omnicrola.pixelblaster.map;

import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.graphics.EntitySprite;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.physics.CircleSensor;
import com.omnicrola.pixelblaster.physics.CollisionIdentifier;
import com.omnicrola.pixelblaster.physics.CollisionPair;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.powerups.BubbleEnergyPowerupContactHandler;
import com.omnicrola.pixelblaster.util.AssetManager;

public class PowerupFactory {

	private static final float Y_PHYSICS_OFFSET = -1f;
	private static final float X_PHYSICS_OFFSET = -0.5f;
	private static final String POWERUP = "sprites/powerups/";

	public void buildAll(float tileSize, MapTools mapTools, List<PowerupData> powerups) {
		for (final PowerupData powerupData : powerups) {
			createPowerup(powerupData, tileSize, mapTools);
		}
	}

	private void createPowerup(PowerupData powerupData, float tileSize, MapTools mapTools) {
		final IPhysicsEntity physics = buildPhysics(powerupData, mapTools);
		final IEntitySprite sprite = buildSprite(powerupData, mapTools.getAssetManager());
		final GameEntity gameEntity = new GameEntity(sprite, physics);
		addContactSensor(powerupData, gameEntity, physics, mapTools);

		adjustPosition(powerupData, gameEntity, tileSize);
		mapTools.getEntityManager().addEntity(gameEntity);
	}

	private void adjustPosition(PowerupData powerupData, final GameEntity gameEntity, float tileSize) {
		final float x = tileSize * powerupData.x;
		final float y = tileSize * powerupData.y;
		gameEntity.setPosition(new Vector2f(x, y));
	}

	private IPhysicsEntity buildPhysics(PowerupData powerupData, MapTools mapTools) {
		//@formatter:off
		final IPhysicsEntity physicsEntity = mapTools.getPhysicsManager().getBuilder()
				.setStatic()
				.density(0)
				.friction(0)
				.build();
		//@formatter:on

		return physicsEntity;
	}

	private void addContactSensor(PowerupData powerupData, GameEntity gameEntity, IPhysicsEntity physicsEntity,
			MapTools mapTools) {
		final float width = powerupData.width;
		final float x = X_PHYSICS_OFFSET + (width / 2f);
		final float y = Y_PHYSICS_OFFSET + (powerupData.height / 2f);

		final CollisionPair collisionPair = new CollisionPair(new CollisionIdentifier(),
				CollisionIdentifier.PLAYER_BODY);
		final CircleSensor circleSensor = new CircleSensor(width / 2f, x, y, collisionPair);
		final BubbleEnergyPowerupContactHandler contactHandler = new BubbleEnergyPowerupContactHandler(gameEntity,
				mapTools.getPlayerManager());
		circleSensor.addContactHandler(contactHandler);
		physicsEntity.addSensor(circleSensor);
	}

	private IEntitySprite buildSprite(PowerupData powerupData, AssetManager assetManager) {
		final Image image = assetManager.getImage(POWERUP + powerupData.image);
		final float width = powerupData.width;
		final float height = powerupData.height;
		final Rectangle bounds = new Rectangle(0, 0, width, height);
		return new EntitySprite(image, bounds);
	}

}
