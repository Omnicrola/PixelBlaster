package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.map.PowerupData;
import com.omnicrola.pixelblaster.util.AssetManager;

public class SpriteBuilder {
	private static final String POWERUP = "sprites/powerups/";

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

}
