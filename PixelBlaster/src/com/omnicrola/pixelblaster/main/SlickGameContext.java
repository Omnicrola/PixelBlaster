package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import com.omnicrola.pixelblaster.graphics.Camera;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.graphics.SlickGraphicsWrapper;
import com.omnicrola.pixelblaster.util.AssetManager;

public class SlickGameContext implements IGameContext {

	private final GameSubsystemInterlink interlink;
	private final GameContainer container;
	private final AssetManager assetManager;
	private final Camera camera;
	private final Camera guiCamera;

	public SlickGameContext(GameSubsystemInterlink interlink, GameContainer container, AssetManager assetManager,
			Camera gameCamera, Camera guiCamera) {
		this.interlink = interlink;
		this.container = container;
		this.assetManager = assetManager;
		this.camera = gameCamera;
		this.guiCamera = guiCamera;
	}

	@Override
	public GameContainer getGameContainer() {
		return this.container;
	}

	@Override
	public <T> T getSubsystem(Class<T> key) {
		return this.interlink.getSubsystem(key);
	}

	@Override
	public Input getInput() {
		return this.container.getInput();
	}

	@Override
	public AssetManager getAssetManager() {
		return this.assetManager;
	}

	@Override
	public Camera getCamera() {
		return this.camera;
	}

	@Override
	public IGraphicsWrapper getGuiGraphics() {
		return new SlickGraphicsWrapper(this.guiCamera, this.container.getGraphics());
	}

}
