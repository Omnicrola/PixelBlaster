package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import com.omnicrola.pixelblaster.graphics.Camera;
import com.omnicrola.pixelblaster.util.AssetManager;

public interface IGameContext {

	<T> T getSubsystem(Class<T> key);

	Input getInput();

	AssetManager getAssetManager();

	Camera getCamera();

	GameContainer getGameContainer();

}
