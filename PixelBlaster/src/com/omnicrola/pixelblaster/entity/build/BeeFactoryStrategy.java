package com.omnicrola.pixelblaster.entity.build;

import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.behavior.BinaryBehaviorController;
import com.omnicrola.pixelblaster.entity.behavior.DampenVelocityBehavior;
import com.omnicrola.pixelblaster.entity.behavior.SeekPlayerBehavior;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.graphics.SpriteBuilder;
import com.omnicrola.pixelblaster.graphics.SpriteData;
import com.omnicrola.pixelblaster.map.EntityData;
import com.omnicrola.pixelblaster.physics.CircleSensor;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.physics.contact.CollisionIdentifier;
import com.omnicrola.pixelblaster.physics.contact.CollisionPair;
import com.omnicrola.pixelblaster.physics.contact.KnockbackAndStunContactHandler;
import com.omnicrola.pixelblaster.player.IPlayerManager;
import com.omnicrola.pixelblaster.player.PlayerController;

public class BeeFactoryStrategy implements IEntityFactoryStrategy {
	private static final float VELOCITY_DAMPEN = 0.95f;
	private static final float SEEK_RADIUS = 4.0f;
	private static final float MAX_VELOCITY = 0.05f;

	private final SpriteData spriteData;
	private final IPlayerManager playerManager;

	public BeeFactoryStrategy(IPlayerManager playerManager) {
		this.playerManager = playerManager;
		this.spriteData = new SpriteData("bee", new Rectangle(0, 0, 1f, 1f));
	}

	@Override
	public IGameEntity buildEntity(EntityData entityData, SpriteBuilder spriteBuilder, IPhysicsManager physicsManager) {
		final IEntitySprite sprite = spriteBuilder.build(this.spriteData);
		final float radius = 0.25f;

		//@formatter:off
		final IPhysicsEntity physicsEntity = physicsManager
				.getBuilder()
				.setDynamic()
				.disableRotation()
				.affectedByGravity(false)
				.addCircle(radius, 0, -0.5f)
				.build();
		//@formatter:on

		final CollisionPair collisionPair = new CollisionPair(new CollisionIdentifier(),
				CollisionIdentifier.PLAYER_BODY);
		final CircleSensor physicsSensor = new CircleSensor(radius + 0.01f, 0, -0.5f, collisionPair);
		physicsEntity.addSensor(physicsSensor);
		final GameEntity gameEntity = new GameEntity(sprite, physicsEntity);

		final BinaryBehaviorController binaryBehaviorController = new BinaryBehaviorController();
		gameEntity.addUpdateBehavior(binaryBehaviorController);

		addBehaviors(binaryBehaviorController);

		physicsSensor.addContactHandler(new KnockbackAndStunContactHandler(gameEntity, binaryBehaviorController));

		return gameEntity;
	}

	private void addBehaviors(final BinaryBehaviorController binaryBehaviorController) {
		final PlayerController playerController = this.playerManager.getPlayerController();
		final SeekPlayerBehavior seekPlayerBehavior = new SeekPlayerBehavior(playerController, SEEK_RADIUS,
				MAX_VELOCITY);
		final DampenVelocityBehavior dapenVelocityBehavior = new DampenVelocityBehavior(VELOCITY_DAMPEN);
		binaryBehaviorController.addPrimaryBehavior(seekPlayerBehavior);
		binaryBehaviorController.addPrimaryBehavior(dapenVelocityBehavior);

		binaryBehaviorController.addAlternateBehavior(new DampenVelocityBehavior(0.5f));
	}

}
