package com.omnicrola.pixelblaster.player;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.entity.MultiStateSprite;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.physics.CollisionIds;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.physics.PhysicsDefinition;
import com.omnicrola.pixelblaster.physics.PhysicsType;
import com.omnicrola.pixelblaster.physics.PhysicsWrapper;
import com.omnicrola.pixelblaster.physics.SensorDefinition;
import com.omnicrola.pixelblaster.util.AssetManager;

public class PlayerBuilder {
	private static final float CHARACTER_HEIGHT = 0.7f;
	private static final float CHARACTER_WIDTH = 0.3f;

	public Player build(AssetManager assetManager, IPhysicsManager physicsManager) {
		final PhysicsWrapper physicsWrapper = createPhysics(physicsManager);
		final MultiStateSprite multiStateSprite = createSprite(assetManager);
		final Player player = new Player(multiStateSprite, physicsWrapper);
		physicsWrapper.addCollisionListener(new PlayerFootCollisionDetector(CollisionIds.PLAYER_FOOT, player));
		return player;
	}

	private static PhysicsWrapper createPhysics(IPhysicsManager physicsManager) {
		final PhysicsDefinition playerPhysicsDefinition = createPlayerPhysics();
		final IPhysicsEntity physicsEntity = physicsManager.createPhysics(playerPhysicsDefinition);
		final PhysicsWrapper physicsWrapper = new PhysicsWrapper(physicsEntity);
		physicsWrapper.setMaximumVelocity(GameSettings.PLAYER_MAXIMUM_VELOCITY);
		return physicsWrapper;
	}

	private static MultiStateSprite createSprite(AssetManager assetManager) {
		final Image[] images = getImages(assetManager);
		final MultiStateSprite multiStateSprite = new MultiStateSprite(images, new Rectangle(0, 0, 1f, 2f));
		return multiStateSprite;
	}

	private static Image[] getImages(AssetManager assetManager) {
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
		//@formatter:off
		final Rectangle shape = new Rectangle(
				-CHARACTER_WIDTH,
				CHARACTER_WIDTH - 5,
				CHARACTER_WIDTH,
				CHARACTER_HEIGHT + 5);
		//@formatter:on
		physicsDefinition.addSensor(new SensorDefinition(CollisionIds.PLAYER_FOOT, shape));
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
