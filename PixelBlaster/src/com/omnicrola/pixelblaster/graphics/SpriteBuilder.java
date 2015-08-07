package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.map.EntityData;
import com.omnicrola.pixelblaster.map.io.PowerupData;
import com.omnicrola.pixelblaster.util.AssetManager;

public class SpriteBuilder {
	private static final String POWERUP = "sprites/powerups/";

	private static final String ENTITY = "sprites/entities/";

	private final AssetManager assetManager;

	public SpriteBuilder(AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	public IEntitySprite build(PowerupData powerupData) {
		final Image image = this.assetManager.getImage(POWERUP + powerupData.image);
		final float width = powerupData.width;
		final float height = powerupData.height;
		final Rectangle bounds = new Rectangle(0, 0, width, height);
		return new EntitySprite(image, bounds);
	}

	public IEntitySprite build(EntityData entityData) {
		final String imageSet = entityData.imageSet;
		final String basePath = ENTITY + imageSet + "/" + imageSet;
		final Image[] images = new Image[2];
		images[0] = this.assetManager.getImage(basePath + ".png");
		images[1] = this.assetManager.getImage(basePath + "_move.png");

		final float width = entityData.width;
		final float height = entityData.height;
		final Rectangle bounds = new Rectangle(0, 0, width, height);
		return new AnimatedSprite(images, bounds, 5);
	}

}
