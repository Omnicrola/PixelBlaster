package com.omnicrola.pixelblaster.physics.jbox2d;

import org.jbox2d.dynamics.Fixture;

import com.omnicrola.pixelblaster.physics.IPhysicsSensor;

public class JBox2dPhysicsSensor implements IPhysicsSensor {

	private final Fixture fixture;

	public JBox2dPhysicsSensor(Fixture fixture) {
		this.fixture = fixture;
	}

}
