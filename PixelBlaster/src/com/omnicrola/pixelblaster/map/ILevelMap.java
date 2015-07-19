package com.omnicrola.pixelblaster.map;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.physics.IEntityPhysics;

public interface ILevelMap extends IEntityPhysics {

	void render(IGraphicsWrapper graphics);

}
