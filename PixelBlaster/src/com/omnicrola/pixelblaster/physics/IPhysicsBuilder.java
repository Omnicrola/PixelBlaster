package com.omnicrola.pixelblaster.physics;

import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.util.PointSet;

public interface IPhysicsBuilder {

	IPhysicsBuilder setDynamic();

	IPhysicsEntity build();

	IPhysicsBuilder friction(float friction);

	IPhysicsBuilder density(float density);

	IPhysicsBuilder addRectangle(Rectangle rectangle);

	IPhysicsBuilder addCircle(float radius);

	IPhysicsBuilder addPolygon(PointSet pointSet);

	IPhysicsBuilder disableRotation();

	IPhysicsBuilder disableSleep();

	IPhysicsBuilder limitVelocity(float maxVelocity);

	IPhysicsBuilder setStatic();

	IPhysicsBuilder position(float x, float y);

	public abstract IPhysicsBuilder addCircle(float radius, float x, float y);

	IPhysicsBuilder collisionId(CollisionIdentifier collisionId);

}
