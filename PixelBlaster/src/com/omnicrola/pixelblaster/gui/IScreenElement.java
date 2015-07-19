package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public interface IScreenElement {
	void setPosition(int x, int y);

	void render(Graphics graphics, int offX, int offY);

	void trigger();

	public abstract boolean isTransparent();

	public abstract void setTransparent(boolean isTransparent);

	public abstract void setDimensions(int width, int height);

	public abstract void setBackground(Color background);

}
