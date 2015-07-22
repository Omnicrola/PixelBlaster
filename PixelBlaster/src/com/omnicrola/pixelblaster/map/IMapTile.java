package com.omnicrola.pixelblaster.map;

import org.jbox2d.collision.shapes.Shape;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public interface IMapTile {

	void render(float x, float y, IGraphicsWrapper graphics);

	public abstract Shape getShape();

}
