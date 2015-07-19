package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.entity.IEntitySprite;

public interface IGraphicsWrapper {

	void setColor(Color color);

	void drawShape(IEntitySprite shape);

	void drawImage(Image image, Rectangle bounds);

}
