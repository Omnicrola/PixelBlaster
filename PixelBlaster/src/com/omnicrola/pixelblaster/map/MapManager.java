package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;

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
			this.mapLoader = new MapLoader(context.getAssetManager(), new MapTileLoader(context.getAssetManager()));
			loadMapForCurrentLevel(context.getSubsystem(IPhysicsManager.class));
			this.initialized = true;
		}
	}

	private void loadMapForCurrentLevel(IPhysicsManager physicsManager) {
		this.currentMap = this.mapLoader.load(this.currentLevel);
		this.currentMap.loadPhysics(physicsManager);
	}

	@Override
	public Vector2f getPlayerSpawn() {
		return this.currentMap.getPlayerSpawn();
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
	}

	@Override
	public MapBounds getMapBounds() {
		return this.currentMap.getMapBounds();
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		this.currentMap.render(graphics);
	}

}
