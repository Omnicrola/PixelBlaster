package com.omnicrola.pixelblaster.gui.fx;

import org.newdawn.slick.Color;

import com.omnicrola.pixelblaster.gui.GLabel;
import com.omnicrola.pixelblaster.gui.IScreenElement;

public class FadeTextEffect implements IElementAffector {

	private final int fadeTime;
	private final GLabel textElement;
	private final long startTime;
	private final int delay;

	public FadeTextEffect(GLabel textElement, int delay, int fadeTime) {
		this.textElement = textElement;
		this.delay = delay;
		this.fadeTime = fadeTime;
		this.startTime = System.currentTimeMillis();
	}

	@Override
	public void update(IScreenElement screenElement) {
		final long elapsedTime = System.currentTimeMillis() - this.startTime;
		if (elapsedTime >= this.delay) {
			final float alpha = 1f - ((float) (elapsedTime - this.delay) / (float) this.fadeTime);
			setTextAlpha(alpha);
		}
	}

	private void setTextAlpha(final float alpha) {
		final Color textColor = this.textElement.getColor();
		final Color shadowColor = this.textElement.getShadowColor();
		textColor.a = alpha;
		shadowColor.a = alpha;
		this.textElement.setTextColor(textColor);
		this.textElement.setShadowColor(shadowColor);
	}

}
