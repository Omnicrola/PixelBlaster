package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.geom.Vector2f;

public interface IMapManager {

	public abstract Vector2f getPlayerSpawn();

	public abstract MapBounds getMapBounds();

}
