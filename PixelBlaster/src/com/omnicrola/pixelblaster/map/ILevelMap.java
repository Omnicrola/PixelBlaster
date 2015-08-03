package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public interface ILevelMap {

	void render(IGraphicsWrapper graphics);

	Vector2f getPlayerSpawn();

	MapBounds getMapBounds();

	void load(MapTools mapTools);

}
