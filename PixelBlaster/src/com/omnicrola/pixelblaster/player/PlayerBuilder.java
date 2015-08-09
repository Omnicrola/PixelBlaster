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
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.physics.RectangleSensor;
import com.omnicrola.pixelblaster.physics.contact.CollisionIdentifier;
import com.omnicrola.pixelblaster.physics.contact.CollisionPair;
import com.omnicrola.pixelblaster.util.AssetManager;

public class PlayerBuilder {
	private static final float CHARACTER_HEIGHT = 0.7f;
	private static final float CHARACTER_WIDTH = 0.3f;
	private static final String PLAYER = "sprites/PlayerGreen/alienGreen_";
	private static final String BUBBLE = "sprites/bubbles/bubble";
	private final AssetManager assetManager;
	private final IPhysicsManager physicsManager;

	public PlayerBuilder(AssetManager assetManager, IPhysicsManager physicsManager) {
		this.assetManager = assetManager;
		this.physicsManager = physicsManager;
	}

	public MultiStateEntity build(PlayerController playerController) {
		final IPhysicsEntity physicsEntity = createPlayerPhysics(playerController);
		final MultiStateSprite multiStateSprite = createSprite();
		final MultiStateEntity player = new MultiStateEntity(multiStateSprite, physicsEntity);
		return player;
	}

	private MultiStateSprite createSprite() {
		final Rectangle bounds = new Rectangle(0, 0, 1f, 2f);
		final Map<ISpriteState, IEntitySprite> sprites = createSprites(bounds);
		final MultiStateSprite multiStateSprite = new MultiStateSprite(sprites, bounds, PlayerState.STAND);
		return multiStateSprite;
	}

	private Map<ISpriteState, IEntitySprite> createSprites(Rectangle bounds) {
		final HashMap<ISpriteState, IEntitySprite> sprites = new HashMap<>();
		sprites.put(PlayerState.STAND, playerImage("stand", bounds));
		sprites.put(PlayerState.WALK, createWalkSprite(bounds));
		sprites.put(PlayerState.JUMP, playerImage("jump", bounds));
		sprites.put(PlayerState.DUCK, playerImage("duck", bounds));
		sprites.put(PlayerState.HIT, playerImage("hit", bounds));

		final Rectangle bubbleBounds = new Rectangle(-0.5f, 0, 2, 2);
		sprites.put(PlayerState.BUBBLE_BLUE, bubbleImage("Blue", bubbleBounds));
		return sprites;
	}

	private IEntitySprite bubbleImage(String imageName, Rectangle bubbleBounds) {
		final Image image = this.assetManager.getImage(BUBBLE + imageName + ".png");
		final EntitySprite entitySprite = new EntitySprite(image, bubbleBounds);
		entitySprite.setTransparency(0.5f);
		return entitySprite;
	}

	private IEntitySprite playerImage(String imageName, Rectangle bounds) {
		final Image image = this.assetManager.getImage(PLAYER + imageName + ".png");
		return new EntitySprite(image, bounds);
	}

	private AnimatedSprite createWalkSprite(Rectangle bounds) {
		final Image[] images = new Image[2];
		images[0] = getImage(PLAYER + "walk1.png");
		images[1] = getImage(PLAYER + "walk2.png");
		return new AnimatedSprite(images, bounds, 8.0f);
	}

	private Image getImage(String path) {
		return this.assetManager.getImage(path);
	}

	//@formatter:off
	private  IPhysicsEntity createPlayerPhysics(PlayerController playerController) {
		final float width = CHARACTER_WIDTH;
		final float height = CHARACTER_HEIGHT;
		final float maxVelocity = GameSettings.PLAYER_MAXIMUM_VELOCITY;

		final float bottomOfCapsule = CHARACTER_HEIGHT + CHARACTER_WIDTH - 0.01f;
		final float sensorWidth = CHARACTER_WIDTH / 2f;
		final IPhysicsEntity physicsEntity = this.physicsManager.getBuilder()
				.collisionId(CollisionIdentifier.PLAYER_BODY)
				.setDynamic()
				.addCircle(width)
				.addRectangle(new Rectangle(-width,0,width*2,height))
				.addCircle(width, 0, CHARACTER_HEIGHT)
				.disableRotation()
				.disableSleep()
				.limitVelocity(maxVelocity)
				.build();

		final Rectangle footShape = new Rectangle(-sensorWidth, bottomOfCapsule, sensorWidth * 2f, 0.02f);
		final RectangleSensor sensor = new RectangleSensor(footShape, new CollisionPair(CollisionIdentifier.PLAYER_FOOT, CollisionIdentifier.MAP_TILE));
		sensor.addContactHandler(new ClearPlayerJumpContactHandler(playerController));
		physicsEntity.addSensor(sensor);

		return physicsEntity;
	}
	//@formatter:on

}
