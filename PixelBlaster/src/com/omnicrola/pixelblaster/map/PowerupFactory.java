package com.omnicrola.pixelblaster.map;

import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.graphics.EntitySprite;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
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
		final IPhysicsManager physicsManager = mapTools.getPhysicsManager();
		final IPhysicsEntity physics = buildPhysics(powerupData, physicsManager);
		final IEntitySprite sprite = buildSprite(powerupData, mapTools.getAssetManager());
		final GameEntity gameEntity = new GameEntity(sprite, physics);

		adjustPosition(powerupData, gameEntity, tileSize);
		mapTools.getEntityManager().addEntity(gameEntity);
	}

	private void adjustPosition(PowerupData powerupData, final GameEntity gameEntity, float tileSize) {
		final float x = tileSize * powerupData.x;
		final float y = tileSize * powerupData.y;
		gameEntity.setPosition(new Vector2f(x, y));
	}

	//@formatter:off
	private IPhysicsEntity buildPhysics(PowerupData powerupData, IPhysicsManager physicsManager) {
		final float width = powerupData.width;
		final float x = X_PHYSICS_OFFSET + (width / 2f);
		final float y = Y_PHYSICS_OFFSET + (powerupData.height / 2f);
		return physicsManager.getBuilder()
				.addCircle(width / 2f , x, y)
				.addCircleSensor(width / 2f, x, y, powerupData.powerupId)
				.setStatic()
				.density(0)
				.friction(0)
				.build();
	}
	//@formatter:on

	private IEntitySprite buildSprite(PowerupData powerupData, AssetManager assetManager) {
		final Image image = assetManager.getImage(POWERUP + powerupData.image);
		final float width = powerupData.width;
		final float height = powerupData.height;
		final Rectangle bounds = new Rectangle(0, 0, width, height);
		return new EntitySprite(image, bounds);
	}

}
