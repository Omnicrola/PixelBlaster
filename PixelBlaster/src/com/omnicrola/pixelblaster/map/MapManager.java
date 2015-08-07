package com.omnicrola.pixelblaster.map;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;
import com.omnicrola.pixelblaster.map.io.MapTemplateReader;
import com.omnicrola.pixelblaster.map.io.MapTemplateReaderBuilder;

public class MapManager implements IGameSubsystem, IMapManager {

	private final int currentLevel;
	private MapLoader mapLoader;
	private boolean initialized;
	private final MapTemplateReaderBuilder mapTemplateReaderBuilder;
	private MapController mapController;
	private boolean mapIsLoaded;

	public MapManager(MapTemplateReaderBuilder mapTemplateReaderBuilder) {
		this.mapTemplateReaderBuilder = mapTemplateReaderBuilder;
		this.currentLevel = 1;
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IMapManager.class, this);
		this.mapController = new MapController(NullMap.NULL);
		this.initialized = false;
		this.mapIsLoaded = false;
	}

	@Override
	public IMapController getMapController() {
		return this.mapController;
	}

	@Override
	public void init(IGameContext context) {
		if (!this.initialized) {
			buildMapLoader(context);
			this.initialized = true;
		}
	}

	private void buildMapLoader(IGameContext context) {
		final MapTemplateReader mapTempateReader = this.mapTemplateReaderBuilder.build(context);
		this.mapLoader = mapTempateReader.loadTemplates();
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		this.mapController.render(graphics);
	}

	@Override
	public void enter(IGameContext context) {
		if (!this.mapIsLoaded) {
			this.mapIsLoaded = true;
			loadMapForCurrentLevel();
		}
	}

	@Override
	public void leave(IGameContext context) {
	}

	private void loadMapForCurrentLevel() {
		final ILevelMap currentMap = this.mapLoader.load(this.currentLevel);
		this.mapController.loadMap(currentMap);
	}
}
