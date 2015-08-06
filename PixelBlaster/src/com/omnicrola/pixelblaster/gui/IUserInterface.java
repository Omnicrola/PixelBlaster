package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public interface IUserInterface {

	public abstract void setScore(int score);

	public abstract void setBubbleMeter(float percentage);

	public abstract void addChild(IScreenElement child);

	public abstract void render(IGraphicsWrapper guiGraphics, int offX, int offY) throws SlickException;

}
