package com.omnicrola.pixelblaster.player;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.entity.MultiStateSprite;
import com.omnicrola.pixelblaster.util.AssetManager;

public class PlayerBuilder {

	public Player build(AssetManager assetManager) {
		final Image[] images = getImages(assetManager);
		final MultiStateSprite multiStateSprite = new MultiStateSprite(images, new Rectangle(0, 0, 1f, 2f));
		final Player player = new Player(multiStateSprite);
		return player;
	}

	private Image[] getImages(AssetManager assetManager) {
		final Image[] images = new Image[11];
		final String base = "sprites/PlayerGreen/alienGreen_";
		images[MultiStateSprite.STAND] = assetManager.getImage(base + "stand.png");
		images[MultiStateSprite.FRONT] = assetManager.getImage(base + "front.png");
		images[MultiStateSprite.WALK1] = assetManager.getImage(base + "walk1.png");
		images[MultiStateSprite.WALK2] = assetManager.getImage(base + "walk2.png");
		images[MultiStateSprite.SWIM1] = assetManager.getImage(base + "swim1.png");
		images[MultiStateSprite.SWIM2] = assetManager.getImage(base + "swim2.png");
		images[MultiStateSprite.JUMP] = assetManager.getImage(base + "jump.png");
		images[MultiStateSprite.HIT] = assetManager.getImage(base + "hit.png");
		images[MultiStateSprite.DUCK] = assetManager.getImage(base + "duck.png");
		images[MultiStateSprite.CLIMB1] = assetManager.getImage(base + "climb1.png");
		images[MultiStateSprite.CLIMB2] = assetManager.getImage(base + "climb2.png");

		return images;
	}

}
