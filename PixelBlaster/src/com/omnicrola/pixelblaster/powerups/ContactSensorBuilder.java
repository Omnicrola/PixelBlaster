package com.omnicrola.pixelblaster.powerups;

import com.omnicrola.pixelblaster.audio.IAudioManager;
import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.map.io.PowerupData;
import com.omnicrola.pixelblaster.physics.CircleSensor;
import com.omnicrola.pixelblaster.physics.CollisionIdentifier;
import com.omnicrola.pixelblaster.physics.CollisionPair;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.player.IPlayerManager;

public class ContactSensorBuilder {
	private static final float Y_PHYSICS_OFFSET = -1f;
	private static final float X_PHYSICS_OFFSET = -0.5f;
	private final IAudioManager audioManager;
	private final IPlayerManager playerManager;

	public ContactSensorBuilder(IAudioManager audioManager, IPlayerManager playerManager) {
		this.audioManager = audioManager;
		this.playerManager = playerManager;
	}

	public void addPowerupSensor(PowerupData powerupData, GameEntity gameEntity, IPhysicsEntity physics) {
		final float width = powerupData.width;
		final float x = X_PHYSICS_OFFSET + (width / 2f);
		final float y = Y_PHYSICS_OFFSET + (powerupData.height / 2f);

		final CollisionPair collisionPair = new CollisionPair(new CollisionIdentifier(),
				CollisionIdentifier.PLAYER_BODY);
		final CircleSensor circleSensor = new CircleSensor(width / 2f, x, y, collisionPair);
		final BubbleEnergyPowerupContactHandler contactHandler = new BubbleEnergyPowerupContactHandler(gameEntity,
				this.playerManager, this.audioManager.getAudioController());
		circleSensor.addContactHandler(contactHandler);
		physics.addSensor(circleSensor);
	}

}
