package com.omnicrola.pixelblaster.gui.fx;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.gui.IScreenElement;

public class CenterHorizontal implements IElementAffector {

	private final int verticalOffset;
	private final IGraphicsWrapper graphicsWrapper;

	public CenterHorizontal(int verticalOffset, IGraphicsWrapper graphicsWrapper) {
		this.verticalOffset = verticalOffset;
		this.graphicsWrapper = graphicsWrapper;
	}

	@Override
	public void update(IScreenElement screenElement) {
		final int screenWidth = (int) this.graphicsWrapper.getWidth();
		final int screenHeight = (int) this.graphicsWrapper.getHeight();
		final int elementWidth = screenElement.getWidth();
		final int elementHeight = screenElement.getHeight();
		final int pX = (screenWidth - elementWidth) / 2;
		final int pY = ((screenHeight - elementHeight) / 2) + this.verticalOffset;
		screenElement.setPosition(pX, pY);
	}

}
