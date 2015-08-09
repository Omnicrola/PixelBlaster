package com.omnicrola.pixelblaster.entity.behavior;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.IUpdateBehavior;
import com.omnicrola.pixelblaster.player.PlayerController;

public class SeekPlayerBehavior implements IUpdateBehavior {
	private final PlayerController playerController;
	private final float maxVelocity;
	private final float seekRadius;

	public SeekPlayerBehavior(PlayerController playerController, float seekRadius, float maxVelocity) {
		this.seekRadius = seekRadius;
		this.maxVelocity = maxVelocity;
		this.playerController = playerController;
	}

	@Override
	public void update(IGameEntity entity, float delta) {
		final Vector2f targetPosition = this.playerController.getPlayerPosition();
		final Vector2f position = entity.getPosition();
		final float distance = targetPosition.distance(position);
		if (distance <= this.seekRadius) {
			targetPosition.sub(position).normalise().scale(this.maxVelocity);
			entity.setVelocity(targetPosition);
		}
	}

}
