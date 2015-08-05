package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class PixelBlasterLauncher {
	private final PixelBlasterFactory factory;

	public static void main(String[] args) {
		final PixelBlasterLauncher launcher = Bootstrapper.boot();
		launcher.start();
	}

	public PixelBlasterLauncher(PixelBlasterFactory factory) {
		this.factory = factory;
	}

	private void start() {
		try {
			final PixelBlasterGame game = this.factory.build();
			final AppGameContainer appGameContainer = new AppGameContainer(game);
			appGameContainer.setDisplayMode(800, 600, false);
			appGameContainer.setVSync(true);
			appGameContainer.setTargetFrameRate(GameSettings.GAME_FPS);
			appGameContainer.start();
		} catch (final SlickException e) {
			e.printStackTrace();
		}
	}
}
