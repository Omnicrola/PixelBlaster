package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class ButtonElement extends ScreenElement {

	private static final int PADDING = 5;
	private final String text;
	private Color highlightColor;
	private boolean isSelected;
	private final Font font;

	public ButtonElement(String text) {
		super();
		this.text = text;
		this.font = FontRepository.get(FontResource.KEN_VECTOR_FUTURE_THIN, 24);
		this.backgroundColor = Color.darkGray;
		this.highlightColor = Color.green;
		this.isTransparent = false;
		this.isSelected = false;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public void setHighlightColor(Color highlightColor) {
		this.highlightColor = highlightColor;
	}

	@Override
	public void renderSelf(IGraphicsWrapper graphics, int offX, int offY) {
		if (this.isSelected) {
			graphics.setColor(this.highlightColor);
		} else {
			graphics.setColor(this.backgroundColor);
		}

		graphics.fillRect(this.x + offX, this.y + offY, this.width, this.height);
		graphics.setColor(Color.white);
		// graphics.setFont(this.font);
		graphics.drawString(this.text, this.x + offX + PADDING, this.y + offY + PADDING);
	}

}
