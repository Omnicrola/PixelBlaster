package com.omnicrola.pixelblaster.main;

import com.omnicrola.pixelblaster.collision.CollisionManager;
import com.omnicrola.pixelblaster.entity.EntityManager;
import com.omnicrola.pixelblaster.map.MapManager;
import com.omnicrola.pixelblaster.particles.ParticleManager;
import com.omnicrola.pixelblaster.player.PlayerManager;

public class PixelBlasterFactory {

	public PixelBlasterGame build() {
		final PixelBlasterGame pixelBlaster = new PixelBlasterGame();
		pixelBlaster.setState(createMainGameState());

		return pixelBlaster;
	}

	private MainGameState createMainGameState() {
		final MainGameState mainGameState = new MainGameState();
		mainGameState.addSubsystem(new CollisionManager());
		mainGameState.addSubsystem(new MapManager());
		mainGameState.addSubsystem(new EntityManager());
		mainGameState.addSubsystem(new ParticleManager());
		mainGameState.addSubsystem(new PlayerManager());
		return mainGameState;
	}

}
