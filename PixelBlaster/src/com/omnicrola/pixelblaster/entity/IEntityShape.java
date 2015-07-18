package com.omnicrola.pixelblaster.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public interface IEntityShape {

	Image getImage();

	float getX();

	float getY();

	Rectangle getBounds();

}
