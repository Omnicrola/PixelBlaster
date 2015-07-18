package com.omnicrola.pixelblaster.main;

public class Bootstrapper {

	public static PixelBlasterLauncher boot() {
		return new PixelBlasterLauncher(new PixelBlasterFactory());
	}

}
