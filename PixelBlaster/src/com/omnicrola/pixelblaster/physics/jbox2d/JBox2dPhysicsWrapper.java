package com.omnicrola.pixelblaster.physics.jbox2d;

import java.util.ArrayList;

import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import com.omnicrola.pixelblaster.physics.IPhysicsBody;
import com.omnicrola.pixelblaster.physics.IPhysicsWrapper;
import com.omnicrola.pixelblaster.physics.PhysicsDefinition;
import com.omnicrola.pixelblaster.physics.PhysicsType;

public class JBox2dPhysicsWrapper implements IPhysicsWrapper {

	private final World world;

	public JBox2dPhysicsWrapper(World world) {
		this.world = world;
	}

	@Override
	public void destroyBody(IPhysicsBody body) {
	}

	@Override
	public IPhysicsBody createBody(PhysicsDefinition physicsDefinition) {
		final BodyDef def = new BodyDef();
		def.position = physicsDefinition.getPosition();
		def.fixedRotation = physicsDefinition.allowRotation();
		def.allowSleep = physicsDefinition.allowRotation();
		def.type = translateType(physicsDefinition);
		final Body body = this.world.createBody(def);

		final ArrayList<Fixture> fixtures = createFixtures(physicsDefinition, body);

		return new JBox2dPhysicsBody(body, fixtures);
	}

	private ArrayList<Fixture> createFixtures(PhysicsDefinition physicsDefinition, final Body body) {
		final Shape[] shapes = physicsDefinition.getShapes();
		final ArrayList<Fixture> fixtures = new ArrayList<>();

		for (final Shape shape : shapes) {
			final FixtureDef fixtureDefinition = new FixtureDef();
			fixtureDefinition.friction = physicsDefinition.getFriction();
			fixtureDefinition.shape = shape;
			fixtures.add(body.createFixture(fixtureDefinition));
		}
		return fixtures;
	}

	private BodyType translateType(PhysicsDefinition physicsDefinition) {
		final PhysicsType type = physicsDefinition.getType();
		if (type.equals(PhysicsType.STATIC)) {
			return BodyType.STATIC;
		} else if (type.equals(PhysicsType.DYNAMIC)) {
			return BodyType.DYNAMIC;
		}
		return BodyType.STATIC;
	}

	public void step(float delta, int velocityIterations, int positionIterations) {
		this.world.step(delta, velocityIterations, positionIterations);
	}

}
