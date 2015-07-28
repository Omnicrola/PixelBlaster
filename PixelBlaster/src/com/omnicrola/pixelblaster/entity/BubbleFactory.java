package com.omnicrola.pixelblaster.entity;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.graphics.EntitySprite;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.graphics.ISpriteState;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.graphics.NullSprite;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.physics.NullPhysicsEntity;
import com.omnicrola.pixelblaster.player.Bubble;
import com.omnicrola.pixelblaster.player.BubbleState;
import com.omnicrola.pixelblaster.util.AssetManager;

public class BubbleFactory {
	private static final String BASE_PATH = "sprites/bubbles/bubble";
	private final AssetManager assetManager;
	private final IPhysicsManager physicsManager;

	public BubbleFactory(AssetManager assetManager, IPhysicsManager physicsManager) {
		this.assetManager = assetManager;
		this.physicsManager = physicsManager;
	}

	private Bubble createBubble(IGameEntity entityInBubble) {
		final Rectangle bounds = new Rectangle(0, 0, 2, 2);
		final Map<ISpriteState, IEntitySprite> sprites = new HashMap<>();
		sprites.put(BubbleState.NONE, NullSprite.NULL);
		sprites.put(BubbleState.BLACK, sprite(bounds, "Black"));
		sprites.put(BubbleState.BLUE, sprite(bounds, "Blue"));
		sprites.put(BubbleState.GREY, sprite(bounds, "Grey"));
		sprites.put(BubbleState.YELLOW, sprite(bounds, "Yellow"));
		final MultiStateSprite sprite = new MultiStateSprite(sprites, bounds, BubbleState.NONE);
		sprite.setTransparency(0.5f);

		final Bubble bubble = new Bubble(sprite, NullPhysicsEntity.NULL);
		bubble.containEntity(entityInBubble);
		return bubble;
	}

	private EntitySprite sprite(final Rectangle bounds, String color) {
		return new EntitySprite(getBubbleImage(color), bounds);
	}

	private Image getBubbleImage(String string) {
		return this.assetManager.getImage(BASE_PATH + string + ".png");
	}

}
