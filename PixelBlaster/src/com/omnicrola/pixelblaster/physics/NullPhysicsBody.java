package com.omnicrola.pixelblaster.physics;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;

public class NullPhysicsBody extends Body {

	public NullPhysicsBody() {
		super(new BodyDef(), null);
	}

	public static Body NULL = new NullPhysicsBody();

}
