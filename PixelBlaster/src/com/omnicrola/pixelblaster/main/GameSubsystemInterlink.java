package com.omnicrola.pixelblaster.main;

import java.util.HashMap;

public class GameSubsystemInterlink {
	private final HashMap<Class<?>, IGameSubsystem> systems;

	public GameSubsystemInterlink() {
		this.systems = new HashMap<>();
	}

	public void setSubsystem(Class<?> key, IGameSubsystem subsystem) {
		this.systems.put(key, subsystem);
	}

	@SuppressWarnings("unchecked")
	public <T> T getSubsystem(Class<T> key) {
		return (T) this.systems.get(key);
	}
}
