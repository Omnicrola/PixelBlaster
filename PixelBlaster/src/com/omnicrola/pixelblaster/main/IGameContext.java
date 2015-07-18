package com.omnicrola.pixelblaster.main;


public interface IGameContext {

	<T> T getSubsystem(Class<T> key);

}
