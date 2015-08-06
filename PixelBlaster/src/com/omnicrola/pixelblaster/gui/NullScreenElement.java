package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.gui.fx.IElementAffector;

public class NullScreenElement implements IScreenElement {
	public static final NullScreenElement NULL = new NullScreenElement();

	private NullScreenElement() {
	}

	@Override
	public void setPosition(int x, int y) {

	}

	@Override
	public void render(IGraphicsWrapper graphics, int offX, int offY) throws SlickException {

	}

	@Override
	public void trigger() {
	}

	@Override
	public boolean isTransparent() {
		return false;
	}

	@Override
	public void setTransparent(boolean isTransparent) {
	}

	@Override
	public void setDimensions(int width, int height) {
	}

	@Override
	public void setBackground(Color background) {
	}

	@Override
	public void addEffect(IElementAffector effect) {
	}

	@Override
	public void remove() {
	}

	@Override
	public void addChild(IScreenElement child) {
	}

	@Override
	public void setParent(IScreenElement screenElement) {
	}

	@Override
	public void removeChild(IScreenElement screenElement) {
	}

}
