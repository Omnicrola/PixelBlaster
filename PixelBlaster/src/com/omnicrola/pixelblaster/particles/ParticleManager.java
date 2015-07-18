package com.omnicrola.pixelblaster.particles;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class ParticleManager implements IGameSubsystem, IParticleManager {

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IParticleManager.class, this);
	}

	@Override
	public void init(IGameContext context) {
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

}
