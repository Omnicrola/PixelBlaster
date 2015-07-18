package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;

import com.omnicrola.pixelblaster.entity.IEntityShape;

public interface IGraphicsWrapper {

	void drawLine(float x1, float y1, float x2, float y2);

	void setColor(Color color);

	void drawShape(IEntityShape shape);

}
