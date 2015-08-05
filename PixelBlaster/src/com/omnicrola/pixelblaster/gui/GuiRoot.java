package com.omnicrola.pixelblaster.gui;

import java.util.Arrays;
import java.util.List;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class GuiRoot implements IUserInterface {
	private final BubbleMeter bubbleMeter;
	private final GLabel scoreLabel;
	private final List<ScreenElement> screenElements;

	public GuiRoot(BubbleMeter bubbleMeter, GLabel scoreLabel) {
		this.bubbleMeter = bubbleMeter;
		this.scoreLabel = scoreLabel;
		this.screenElements = Arrays.asList(bubbleMeter, scoreLabel);
	}

	@Override
	public void setBubbleMeter(float percentage) {
		this.bubbleMeter.setPercentageFull(percentage);
	}

	@Override
	public void setScore(int score) {
		this.scoreLabel.setText("Score: " + score);
	}

	@Override
	public void render(IGraphicsWrapper guiGraphics) {
		for (final ScreenElement screenElement : this.screenElements) {
			screenElement.render(guiGraphics, 0, 0);
		}

	}

}
