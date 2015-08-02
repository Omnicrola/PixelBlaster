package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class BubbleMeter extends ScreenElement {
	private static final int PADDING = 2;
	private final Image fullIcon;
	private final int meterLength;
	private float percentageFull;
	private final Image emptyIcon;

	public BubbleMeter(Image fullIcon, Image emptyIcon) {
		this.fullIcon = fullIcon;
		this.emptyIcon = emptyIcon;
		this.meterLength = 200;
		this.percentageFull = 0.25f;
		this.isTransparent = true;
	}

	@Override
	public void render(IGraphicsWrapper graphics, int offX, int offY) {
		final int spacing = calculateSpacing();
		final int totalIcons = this.meterLength / this.fullIcon.getWidth();
		for (int i = 0; i <= totalIcons; i++) {
			final int pX = offX + (i * spacing) + this.x;
			final int pY = offY + this.y;
			drawIcon(graphics, pX, pY);
		}
	}

	private void drawIcon(IGraphicsWrapper graphics, int x, int y) {
		graphics.drawImage(this.fullIcon, x, y);
	}

	public void setPercentageFull(float percentageFull) {
		this.percentageFull = percentageFull;
	}

	private int calculateSpacing() {
		return this.fullIcon.getWidth() + PADDING;
	}

}
