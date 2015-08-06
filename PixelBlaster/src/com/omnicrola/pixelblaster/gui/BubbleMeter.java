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
	public void renderSelf(IGraphicsWrapper graphics, int offX, int offY) {
		final int spacing = calculateSpacing();
		final float totalIcons = (float) this.meterLength / (float) this.fullIcon.getWidth();
		final float filledIcons = totalIcons * this.percentageFull;
		for (int i = 0; i <= totalIcons; i++) {
			final int pX = offX + (i * spacing) + this.x;
			final int pY = offY + this.y;
			if (i <= filledIcons) {
				drawFilledIcon(graphics, pX, pY);
			} else {
				drawEmptyIcon(graphics, pX, pY);
			}
		}
	}

	private void drawFilledIcon(IGraphicsWrapper graphics, int x, int y) {
		graphics.drawImage(this.fullIcon, x, y);
	}

	private void drawEmptyIcon(IGraphicsWrapper graphics, int x, int y) {
		graphics.drawImage(this.emptyIcon, x, y);
	}

	public void setPercentageFull(float percentageFull) {
		this.percentageFull = percentageFull;
	}

	private int calculateSpacing() {
		return this.fullIcon.getWidth() + PADDING;
	}

}
