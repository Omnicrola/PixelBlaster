package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class GLabel extends ScreenElement {
	private String text;
	private boolean isShadowed = false;
	private Color shadowColor;
	private Color textColor;
	private Font font;

	public GLabel(String text) {
		super();
		this.font = FontRepository.get(FontResource.KEN_VECTOR_FUTURE_THIN, 18);
		setText(text);
		this.textColor = Color.white;
		this.shadowColor = Color.darkGray;
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
		graphics.setFont(this.font);
		if (this.isShadowed) {
			graphics.setColor(this.shadowColor);
			graphics.drawString(this.text, this.x + offX + 2, this.y + offY + 2);
		}
		graphics.setColor(this.textColor);
		graphics.drawString(this.text, this.x + offX, this.y + offY);
	}

	public void setText(String text) {
		this.text = text;
		this.width = this.font.getWidth(text);
		this.height = this.font.getLineHeight();
	}

	public void setFont(Font font) {
		this.font = font;
		setText(this.text);
	}

	public Color getColor() {
		return new Color(this.textColor);
	}

	public Color getShadowColor() {
		return new Color(this.shadowColor);
	}
}
