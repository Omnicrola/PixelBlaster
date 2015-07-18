package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.Input;

public interface IGameContext {

	<T> T getSubsystem(Class<T> key);

	Input getInput();

}
