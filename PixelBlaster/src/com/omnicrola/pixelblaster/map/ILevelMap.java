package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.physics.IEntityPhysics;

public interface ILevelMap extends IEntityPhysics {

	void render(IGraphicsWrapper graphics);

	Vector2f getPlayerSpawn();

}
