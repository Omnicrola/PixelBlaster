package com.omnicrola.pixelblaster.player;

import java.util.HashMap;
import java.util.Map;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.behavior.SynchEntityPosition;
import com.omnicrola.pixelblaster.graphics.AnimatedSprite;
import com.omnicrola.pixelblaster.graphics.EntitySprite;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.graphics.ISpriteState;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.graphics.NullSprite;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.physics.CollisionIds;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.physics.NullPhysicsEntity;
import com.omnicrola.pixelblaster.physics.PhysicsDefinition;
import com.omnicrola.pixelblaster.physics.PhysicsType;
import com.omnicrola.pixelblaster.physics.SensorDefinition;
import com.omnicrola.pixelblaster.util.AssetManager;

public class PlayerBuilder {
	private static final float CHARACTER_HEIGHT = 0.7f;
	private static final float CHARACTER_WIDTH = 0.3f;
	private static final String BASE = "sprites/PlayerGreen/alienGreen_";

	public Player build(AssetManager assetManager, IPhysicsManager physicsManager) {
		final IPhysicsEntity physicsEntity = createPhysics(physicsManager);
		final MultiStateSprite multiStateSprite = createSprite(assetManager);
		final Bubble bubble = createBubble(physicsManager, assetManager);
		final Player player = new Player(bubble, multiStateSprite, physicsEntity);
		player.addUpdateBehavior(new SynchEntityPosition(bubble, new Vector2f(-0.5f, 0.1f)));
		physicsEntity.addCollisionDetector(new PlayerFootCollisionDetector(CollisionIds.PLAYER_FOOT, player));
		return player;
	}

	private static Bubble createBubble(IPhysicsManager physicsManager, AssetManager assetManager) {
		final Rectangle bounds = new Rectangle(0, 0, 2, 2);
		final Map<ISpriteState, IEntitySprite> sprites = new HashMap<>();
		sprites.put(BubbleState.NONE, NullSprite.NULL);
		sprites.put(BubbleState.BLACK, new EntitySprite(getBubbleImage(assetManager, "Black"), bounds));
		sprites.put(BubbleState.BLUE, new EntitySprite(getBubbleImage(assetManager, "Blue"), bounds));
		sprites.put(BubbleState.GREY, new EntitySprite(getBubbleImage(assetManager, "Grey"), bounds));
		sprites.put(BubbleState.YELLOW, new EntitySprite(getBubbleImage(assetManager, "Yellow"), bounds));
		final MultiStateSprite sprite = new MultiStateSprite(sprites, bounds, BubbleState.NONE);
		sprite.setTransparency(0.5f);

		return new Bubble(sprite, NullPhysicsEntity.NULL);
	}

	private static Image getBubbleImage(AssetManager assetManager, String string) {
		return assetManager.getImage("sprites/bubbles/bubble" + string + ".png");
	}

	private static IPhysicsEntity createPhysics(IPhysicsManager physicsManager) {
		final PhysicsDefinition playerPhysicsDefinition = createPlayerPhysics();
		final IPhysicsEntity physicsEntity = physicsManager.createPhysics(playerPhysicsDefinition);
		physicsEntity.setMaximumVelocity(GameSettings.PLAYER_MAXIMUM_VELOCITY);
		return physicsEntity;
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

	private static PhysicsDefinition createPlayerPhysics() {

		final PhysicsDefinition physicsDefinition = createCapsuleShape();
		addSensors(physicsDefinition);
		physicsDefinition.setType(PhysicsType.DYNAMIC);
		physicsDefinition.allowRotation(false);
		physicsDefinition.allowSleep(false);
		physicsDefinition.setMaxVelocity(GameSettings.PLAYER_MAXIMUM_VELOCITY);
		return physicsDefinition;
	}

	private static void addSensors(PhysicsDefinition physicsDefinition) {
		final PolygonShape polygonShape = new PolygonShape();

		final Vec2[] vertices = new Vec2[4];
		vertices[0] = new Vec2(-CHARACTER_WIDTH, CHARACTER_HEIGHT - 0.1f);
		vertices[1] = new Vec2(CHARACTER_WIDTH, CHARACTER_HEIGHT - 0.1f);
		vertices[2] = new Vec2(CHARACTER_WIDTH, CHARACTER_HEIGHT + 0.1f);
		vertices[3] = new Vec2(-CHARACTER_WIDTH, CHARACTER_HEIGHT + 0.1f);
		polygonShape.set(vertices, 4);
		physicsDefinition.addSensor(new SensorDefinition(CollisionIds.PLAYER_FOOT, polygonShape));
	}

	private static PhysicsDefinition createCapsuleShape() {
		final CircleShape topCircle = new CircleShape();
		topCircle.m_radius = CHARACTER_WIDTH;

		final CircleShape bottomCircle = new CircleShape();
		bottomCircle.m_radius = CHARACTER_WIDTH;
		bottomCircle.m_p.y = CHARACTER_HEIGHT;

		final PolygonShape center = new PolygonShape();
		final Vec2[] vertices = new Vec2[4];
		vertices[0] = new Vec2(-CHARACTER_WIDTH, 0);
		vertices[1] = new Vec2(CHARACTER_WIDTH, 0);
		vertices[2] = new Vec2(CHARACTER_WIDTH, CHARACTER_HEIGHT);
		vertices[3] = new Vec2(-CHARACTER_WIDTH, CHARACTER_HEIGHT);
		center.set(vertices, 4);

		final PhysicsDefinition physicsDefinition = new PhysicsDefinition(topCircle, bottomCircle, center);
		return physicsDefinition;
	}

}
