package com.omnicrola.pixelblaster.gui;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.gui.fx.IElementAffector;

public abstract class ScreenElement implements IScreenElement {
	protected final ArrayList<IScreenElement> children;
	protected final ArrayList<IScreenElement> childrenCopy;
	private final ArrayList<IEventListener> listeners;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean isTransparent;
	protected Color backgroundColor;
	private final List<IElementAffector> effects;
	private IScreenElement parent;

	public ScreenElement() {
		this.childrenCopy = new ArrayList<>();
		this.children = new ArrayList<>();
		this.listeners = new ArrayList<>();
		this.effects = new ArrayList<>();
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.isTransparent = true;
		this.parent = null;
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

	@Override
	public void addChild(IScreenElement element) {
		this.children.add(element);
		element.setParent(this);
	}

	@Override
	public void removeChild(IScreenElement screenElement) {
		this.children.remove(screenElement);
	}

	@Override
	public void setParent(IScreenElement screenElement) {
		this.parent = screenElement;
	}

	@Override
	public void remove() {
		if (this.parent != null) {
			this.parent.removeChild(this);
		}
	}

	@Override
	final public void render(IGraphicsWrapper graphics, int offX, int offY) throws SlickException {
		updateEffects();
		renderBackground(graphics, offX, offY);
		renderSelf(graphics, offX, offY);
		renderChildren(graphics, offX, offY);
	}

	private void updateEffects() {
		for (final IElementAffector effect : this.effects) {
			effect.update(this);
		}
	}

	public abstract void renderSelf(IGraphicsWrapper graphics, int offX, int offY);

	protected void renderBackground(IGraphicsWrapper graphics, int offX, int offY) {
		if (!this.isTransparent) {
			graphics.setColor(this.backgroundColor);
			graphics.drawRect(this.x + offX, this.y + offY, this.width, this.height);
		}
	}

	protected void renderChildren(IGraphicsWrapper graphics, int offX, int offY) throws SlickException {
		this.childrenCopy.clear();
		this.childrenCopy.addAll(this.children);
		for (final IScreenElement element : this.childrenCopy) {
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

	@Override
	public void addEffect(IElementAffector effect) {
		this.effects.add(effect);
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

}