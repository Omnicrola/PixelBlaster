package com.omnicrola.pixelblaster.gui.fx;

public class FadeEffect implements IElementAffector {

	private final int fadeTime;
	private final long startTime;

	public FadeEffect(int fadeTime) {
		this.fadeTime = fadeTime;
		this.startTime = System.currentTimeMillis();
	}

}
