package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.gui.fx.IElementAffector;

public interface IScreenElement {
	void setPosition(int x, int y);

	void render(IGraphicsWrapper graphics, int offX, int offY) throws SlickException;

	void trigger();

	public abstract boolean isTransparent();

	public abstract void setTransparent(boolean isTransparent);

	public abstract void setDimensions(int width, int height);

	public abstract void setBackground(Color background);

	void addEffect(IElementAffector effect);

	void addChild(IScreenElement child);

	void remove();

	void setParent(IScreenElement screenElement);

	void removeChild(IScreenElement screenElement);

	int getWidth();

	int getHeight();

}
