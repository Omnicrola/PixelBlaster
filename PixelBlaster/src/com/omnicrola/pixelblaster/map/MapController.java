package com.omnicrola.pixelblaster.map;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class MapController implements IMapController {
	private ILevelMap map;
	private final List<ILevelObserver> observers;

	public MapController(ILevelMap map) {
		this.observers = new ArrayList<>();
		this.map = map;
	}

	@Override
	public void addObserver(ILevelObserver levelObserver) {
		this.observers.add(levelObserver);
	}

	@Override
	public MapBounds getMapBounds() {
		return this.map.getMapBounds();
	}

	@Override
	public Vector2f getPlayerSpawn() {
		return this.map.getPlayerSpawn();
	}

	public void render(IGraphicsWrapper graphics) {
		this.map.render(graphics);
	}

	public void loadMap(ILevelMap currentMap) {
		this.map = currentMap;
		notifyObservers();
	}

	private void notifyObservers() {
		for (final ILevelObserver observer : this.observers) {
			observer.newLevelLoaded(this);
		}
	}

	@Override
	public String getTitle() {
		return this.map.getTitle();
	}

	@Override
	public String getSubtitle() {
		return this.map.getSubtitle();
	}
}
