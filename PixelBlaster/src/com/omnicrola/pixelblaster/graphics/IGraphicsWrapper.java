package com.omnicrola.pixelblaster.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public interface IGraphicsWrapper {

	void drawImage(Image image, Rectangle bounds, Color drawColor);

	void drawImage(Image image, int x, int y);

	void drawImage(Image image, Rectangle bounds);

	void drawImageFullScreen(Image image);

	void setColor(Color backgroundColor);

	void drawRect(int x, int y, int width, int height);

	void fillRect(int x, int y, int width, int height);

	void drawString(String text, int x, int y);

}
