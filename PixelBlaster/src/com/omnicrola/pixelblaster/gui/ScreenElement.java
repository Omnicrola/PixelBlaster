package com.omnicrola.pixelblaster.gui;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class ScreenElement implements IScreenElement {
	protected final ArrayList<IScreenElement> children;
	private final ArrayList<IEventListener> listeners;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean isTransparent;
	protected Color backgroundColor;

	public ScreenElement() {
		this.children = new ArrayList<>();
		this.listeners = new ArrayList<>();
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.isTransparent = true;
		this.backgroundColor = Color.black;
	}

	@Override
	public void setBackground(Color background) {
		this.backgroundColor = background;
	}

	@Override
	public void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void setTransparent(boolean isTransparent) {
		this.isTransparent = isTransparent;
	}

	@Override
	public boolean isTransparent() {
		return this.isTransparent;
	}

	public void addChild(IScreenElement element) {
		this.children.add(element);
	}

	@Override
	public void render(IGraphicsWrapper graphics, int offX, int offY) {
		renderSelf(graphics, offX, offY);
		renderChildren(graphics, offX, offY);
	}

	protected void renderSelf(IGraphicsWrapper graphics, int offX, int offY) {
		if (!this.isTransparent) {
			graphics.setColor(this.backgroundColor);
			graphics.drawRect(this.x + offX, this.y + offY, this.width, this.height);
		}
	}

	protected void renderChildren(IGraphicsWrapper graphics, int offX, int offY) {
		for (final IScreenElement element : this.children) {
			element.render(graphics, offX + this.x, offY + this.y);
		}
	}

	public void addEventListener(IEventListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void trigger() {
		for (final IEventListener listener : this.listeners) {
			listener.trigger();
		}
	}

	@Override
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

}