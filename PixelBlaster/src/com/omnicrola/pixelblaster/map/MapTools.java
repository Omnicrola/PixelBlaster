package com.omnicrola.pixelblaster.map;

import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.player.IPlayerManager;
import com.omnicrola.pixelblaster.util.AssetManager;

public class MapTools {

	private final IPhysicsManager physicsManager;
	private final IEntityManager entityManager;
	private final AssetManager assetManager;
	private final IPlayerManager playerManager;

	public MapTools(IPhysicsManager physicsManager, IEntityManager entityManager, AssetManager assetManager,
			IPlayerManager playerManager) {
		this.physicsManager = physicsManager;
		this.entityManager = entityManager;
		this.assetManager = assetManager;
		this.playerManager = playerManager;
	}

	public IPhysicsManager getPhysicsManager() {
		return this.physicsManager;
	}

	public IEntityManager getEntityManager() {
		return this.entityManager;
	}

	public AssetManager getAssetManager() {
		return this.assetManager;
	}

	public IPlayerManager getPlayerManager() {
		return this.playerManager;
	}

}
