package com.omnicrola.pixelblaster.gui;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class GuiRoot extends ScreenElement implements IUserInterface {
	private final BubbleMeter bubbleMeter;
	private final GLabel scoreLabel;

	public GuiRoot(BubbleMeter bubbleMeter, GLabel scoreLabel) {
		this.bubbleMeter = bubbleMeter;
		this.scoreLabel = scoreLabel;
		addChild(bubbleMeter);
		addChild(scoreLabel);
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
	public void renderSelf(IGraphicsWrapper graphics, int offX, int offY) {
	}

}
