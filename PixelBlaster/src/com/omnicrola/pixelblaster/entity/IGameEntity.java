package com.omnicrola.pixelblaster.entity;

public interface IGameEntity {

	boolean isAlive();

	void update(float delta);

	IEntityShape getShape();

}
