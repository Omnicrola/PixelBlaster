package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public interface IGraphicsWrapper {

	void drawImage(Image image, Rectangle bounds, Color drawColor);

	void drawImage(Image image, Rectangle bounds);

	void drawImageFullScreen(Image image);

}
