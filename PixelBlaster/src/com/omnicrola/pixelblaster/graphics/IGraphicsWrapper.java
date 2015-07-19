package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.entity.IEntitySprite;

public interface IGraphicsWrapper {

	void drawLine(float x1, float y1, float x2, float y2);

	void setColor(Color color);

	void drawShape(IEntitySprite shape);

	void drawImage(Image image, float x, float y);

}
