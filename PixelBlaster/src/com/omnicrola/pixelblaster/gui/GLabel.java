package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Color;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class GLabel extends ScreenElement {
	private String text;
	private boolean isShadowed = false;
	private Color shadowColor;
	private Color textColor;

	public GLabel(String text) {
		super();
		this.text = text;
		this.textColor = Color.white;
		this.shadowColor = Color.black;
	}

	public void setShadowed(boolean isShadowed) {
		this.isShadowed = isShadowed;
	}

	public void setShadowColor(Color shadowColor) {
		this.shadowColor = shadowColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	@Override
	public void renderSelf(IGraphicsWrapper graphics, int offX, int offY) {
		if (this.isShadowed) {
			graphics.setColor(this.shadowColor);
			graphics.drawString(this.text, this.x + offX + 1, this.y + offY + 1);
		}
		graphics.setColor(this.textColor);
		graphics.drawString(this.text, this.x + offX, this.y + offY);
	}

	public void setText(String text) {
		this.text = text;
	}
}
