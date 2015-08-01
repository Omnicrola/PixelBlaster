package com.omnicrola.pixelblaster.player;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.graphics.AnimatedSprite;
import com.omnicrola.pixelblaster.graphics.EntitySprite;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.graphics.ISpriteState;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.physics.CollisionIds;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.util.AssetManager;

public class PlayerBuilder {
	private static final float CHARACTER_HEIGHT = 0.7f;
	private static final float CHARACTER_WIDTH = 0.3f;
	private static final String BASE = "sprites/PlayerGreen/alienGreen_";
	private final AssetManager assetManager;
	private final IPhysicsManager physicsManager;

	public PlayerBuilder(AssetManager assetManager, IPhysicsManager physicsManager) {
		this.assetManager = assetManager;
		this.physicsManager = physicsManager;
	}

	public MultiStateEntity build() {
		final IPhysicsEntity physicsEntity = createPlayerPhysics(this.physicsManager);
		final MultiStateSprite multiStateSprite = createSprite(this.assetManager);
		final MultiStateEntity player = new MultiStateEntity(multiStateSprite, physicsEntity);
		return player;
	}

	private static MultiStateSprite createSprite(AssetManager assetManager) {
		final Rectangle bounds = new Rectangle(0, 0, 1f, 2f);
		final Map<ISpriteState, IEntitySprite> sprites = createSprites(assetManager, bounds);
		final MultiStateSprite multiStateSprite = new MultiStateSprite(sprites, bounds, PlayerState.STAND);
		return multiStateSprite;
	}

	private static Map<ISpriteState, IEntitySprite> createSprites(AssetManager assetManager, Rectangle bounds) {
		final HashMap<ISpriteState, IEntitySprite> sprites = new HashMap<>();
		sprites.put(PlayerState.STAND, new EntitySprite(getPlayerImage(assetManager, "stand"), bounds));
		sprites.put(PlayerState.WALK, createWalkSprite(assetManager, bounds));
		sprites.put(PlayerState.JUMP, new EntitySprite(getPlayerImage(assetManager, "jump"), bounds));
		sprites.put(PlayerState.DUCK, new EntitySprite(getPlayerImage(assetManager, "duck"), bounds));
		sprites.put(PlayerState.HIT, new EntitySprite(getPlayerImage(assetManager, "hit"), bounds));
		return sprites;
	}

	private static AnimatedSprite createWalkSprite(AssetManager assetManager, Rectangle bounds) {
		final Image[] images = new Image[2];
		images[0] = getPlayerImage(assetManager, "walk1");
		images[1] = getPlayerImage(assetManager, "walk2");
		return new AnimatedSprite(images, bounds, 8.0f);
	}

	private static Image getPlayerImage(AssetManager assetManager, String imageName) {
		return assetManager.getImage(BASE + imageName + ".png");
	}

	//@formatter:off
	private static IPhysicsEntity createPlayerPhysics(IPhysicsManager physicsManager) {
		final float width = CHARACTER_WIDTH;
		final float height = CHARACTER_HEIGHT;
		final float maxVelocity = GameSettings.PLAYER_MAXIMUM_VELOCITY;

		final float bottomOfCapsule = CHARACTER_HEIGHT + CHARACTER_WIDTH - 0.01f;
		final float sensorWidth = CHARACTER_WIDTH / 2f;
		final Rectangle footShape = new Rectangle(-sensorWidth,bottomOfCapsule,sensorWidth*2,0.02f);

		return physicsManager.getBuilder()
				.collisionId(CollisionIds.PLAYER_BODY)
				.setDynamic()
				.addCircle(width)
				.addRectangle(new Rectangle(-width,0,width*2,height))
				.addCircle(width, 0, CHARACTER_HEIGHT)
				.disableRotation()
				.disableSleep()
				.limitVelocity(maxVelocity)
				.rectangleSensor(CollisionIds.PLAYER_FOOT, footShape)
				.build();
	}
	//@formatter:on

}
