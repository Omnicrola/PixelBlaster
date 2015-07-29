package com.omnicrola.pixelblaster.map;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.util.PointSet;

public interface IMapTile {

	void render(float x, float y, IGraphicsWrapper graphics);

	public abstract PointSet getShape();

}
