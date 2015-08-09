package com.omnicrola.pixelblaster.entity.build;

import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.behavior.DampenVelocityBehavior;
import com.omnicrola.pixelblaster.entity.behavior.SeekPlayerBehavior;
import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.graphics.SpriteBuilder;
import com.omnicrola.pixelblaster.graphics.SpriteData;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
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
	public IEntitySprite buildSprite(SpriteBuilder spriteBuilder) {
		return spriteBuilder.build(this.spriteData);
	}

	@Override
	//@formatter:off
	public IPhysicsEntity buildPhysics(IPhysicsManager physicsManager) {
		return physicsManager.getBuilder()
				.setDynamic()
				.disableRotation()
				.affectedByGravity(false)
				.addCircle(0.25f, 0, -0.5f)
				.build();
	}
	//@formatter:on

	@Override
	public void addBehaviors(IGameEntity gameEntity) {
		final PlayerController playerController = this.playerManager.getPlayerController();
		gameEntity.addUpdateBehavior(new SeekPlayerBehavior(playerController, SEEK_RADIUS, MAX_VELOCITY));
		gameEntity.addUpdateBehavior(new DampenVelocityBehavior(VELOCITY_DAMPEN));
	}

}
