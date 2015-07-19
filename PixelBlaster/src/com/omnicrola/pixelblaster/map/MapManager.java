package com.omnicrola.pixelblaster.map;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class MapManager implements IGameSubsystem, IMapManager {

	private final int currentLevel;
	private MapLoader mapLoader;
	private ILevelMap currentMap;
	private boolean initialized;

	public MapManager() {
		this.currentLevel = 1;
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IMapManager.class, this);
		this.initialized = false;
	}

	@Override
	public void init(IGameContext context) {
		if (!this.initialized) {
			this.mapLoader = new MapLoader(context.getAssetManager());
			this.currentMap = this.mapLoader.load(this.currentLevel);
			this.initialized = true;
		}
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		this.currentMap.render(graphics);
	}

}
