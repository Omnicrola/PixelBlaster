package com.omnicrola.pixelblaster.gui;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public interface IUserInterface {

	public abstract void setScore(int score);

	public abstract void setBubbleMeter(float percentage);

	public abstract void render(IGraphicsWrapper guiGraphics);

}
