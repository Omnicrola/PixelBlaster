package com.omnicrola.pixelblaster.physics.jbox2d;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.physics.IPhysicsBody;
import com.omnicrola.pixelblaster.physics.IPhysicsWrapper;
import com.omnicrola.pixelblaster.physics.PhysicsDefinition;
import com.omnicrola.pixelblaster.physics.PhysicsType;
import com.omnicrola.pixelblaster.physics.SensorDefinition;

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
		def.allowSleep = physicsDefinition.allowSleep();
		def.type = translateType(physicsDefinition);
		final Body body = this.world.createBody(def);

		final ArrayList<Fixture> fixtures = createFixtures(physicsDefinition, body);
		final List<JBox2dPhysicsSensor> sensors = createSensors(physicsDefinition.getSensors(), body);
		return new JBox2dPhysicsBody(body, fixtures, sensors);
	}

	private ArrayList<Fixture> createFixtures(PhysicsDefinition physicsDefinition, final Body body) {
		final Shape[] shapes = physicsDefinition.getShapes();
		final ArrayList<Fixture> fixtures = new ArrayList<>();

		for (final Shape shape : shapes) {
			final FixtureDef fixtureDefinition = new FixtureDef();
			fixtureDefinition.friction = physicsDefinition.getFriction();
			fixtureDefinition.shape = shape;
			fixtureDefinition.userData = physicsDefinition.getDetectionType();
			fixtures.add(body.createFixture(fixtureDefinition));
		}

		return fixtures;
	}

	private List<JBox2dPhysicsSensor> createSensors(List<SensorDefinition> sensorDefinitions, Body body) {
		final ArrayList<JBox2dPhysicsSensor> sensors = new ArrayList<>();
		for (final SensorDefinition sensorDefinition : sensorDefinitions) {
			final FixtureDef def = new FixtureDef();
			def.isSensor = true;
			def.userData = sensorDefinition.getDetectionType();
			def.shape = createRectangleShape(sensorDefinition.getBounds());
			final Fixture fixture = body.createFixture(def);
			sensors.add(new JBox2dPhysicsSensor(fixture));
		}
		return sensors;
	}

	private Shape createRectangleShape(Rectangle bounds) {
		final PolygonShape polygonShape = new PolygonShape();
		final Vec2[] vertices = new Vec2[4];
		vertices[0] = new Vec2(bounds.getMinX(), bounds.getMinY());
		vertices[1] = new Vec2(bounds.getMaxX(), bounds.getMinY());
		vertices[2] = new Vec2(bounds.getMaxX(), bounds.getMaxY());
		vertices[3] = new Vec2(bounds.getMinX(), bounds.getMaxY());
		polygonShape.set(vertices, 4);
		return polygonShape;
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
