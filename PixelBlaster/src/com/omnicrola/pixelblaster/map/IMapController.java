package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.geom.Vector2f;

public interface IMapController {
	public abstract Vector2f getPlayerSpawn();

	public abstract MapBounds getMapBounds();

	void addObserver(ILevelObserver levelObserver);

	public abstract String getTitle();

	public abstract String getSubtitle();
}
