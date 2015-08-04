package com.omnicrola.pixelblaster.map;

import com.omnicrola.pixelblaster.audio.IAudioManager;
import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.player.IPlayerManager;
import com.omnicrola.pixelblaster.util.AssetManager;

public class MapTools {

	private final IGameContext context;

	public MapTools(IGameContext context) {
		this.context = context;
	}

	public IPhysicsManager getPhysicsManager() {
		return this.context.getSubsystem(IPhysicsManager.class);
	}

	public IEntityManager getEntityManager() {
		return this.context.getSubsystem(IEntityManager.class);
	}

	public AssetManager getAssetManager() {
		return this.context.getAssetManager();
	}

	public IPlayerManager getPlayerManager() {
		return this.context.getSubsystem(IPlayerManager.class);
	}

	public IAudioManager getAudioManager() {
		return this.context.getSubsystem(IAudioManager.class);
	}
}
