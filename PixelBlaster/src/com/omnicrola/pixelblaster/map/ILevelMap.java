package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.physics.IGamePhysics;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;

public interface ILevelMap extends IGamePhysics {

	void render(IGraphicsWrapper graphics);

	Vector2f getPlayerSpawn();

	MapBounds getMapBounds();

	void loadPhysics(IPhysicsManager physicsManager);

}
