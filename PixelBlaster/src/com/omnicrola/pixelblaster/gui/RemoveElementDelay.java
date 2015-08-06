package com.omnicrola.pixelblaster.gui;

import com.omnicrola.pixelblaster.gui.fx.IElementAffector;

public class RemoveElementDelay implements IElementAffector {

	private final int delay;
	private final long startTime;

	public RemoveElementDelay(int delay) {
		this.delay = delay;
		this.startTime = System.currentTimeMillis();
	}

	@Override
	public void update(IScreenElement screenElement) {
		final long elapsed = System.currentTimeMillis() - this.startTime;
		if (elapsed > this.delay) {
			screenElement.remove();
		}
	}

}
