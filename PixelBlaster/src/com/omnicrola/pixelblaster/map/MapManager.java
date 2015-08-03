package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.util.AssetManager;

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
			final AssetManager assetManager = context.getAssetManager();
			final IPhysicsManager physicsManager = context.getSubsystem(IPhysicsManager.class);
			final IEntityManager entityManager = context.getSubsystem(IEntityManager.class);
			final MapTools mapTools = new MapTools(physicsManager, entityManager, assetManager);

			this.mapLoader = new MapLoader(assetManager, new MapTileLoader(assetManager));
			loadMapForCurrentLevel(mapTools);
			this.initialized = true;
		}
	}

	private void loadMapForCurrentLevel(MapTools mapTools) {
		this.currentMap = this.mapLoader.load(this.currentLevel);
		this.currentMap.load(mapTools);
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
