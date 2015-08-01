package com.omnicrola.pixelblaster.physics.jbox2d;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Settings;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.physics.CollisionGroup;
import com.omnicrola.pixelblaster.physics.CollisionIds;
import com.omnicrola.pixelblaster.physics.IPhysicsBuilder;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.util.PointSet;

public class JBox2DPhysicsBuilder implements IPhysicsBuilder {

	private final World world;
	private final ArrayList<FixtureDef> fixtures;
	private final List<FixtureDef> sensors;
	private final BodyDef bodyDef;
	private float friction;
	private float density;
	private float maximumVelocity;
	private final JBox2dContactListener contactListener;
	private int collisionId;

	public JBox2DPhysicsBuilder(World world, JBox2dContactListener contactListener) {
		this.world = world;
		this.contactListener = contactListener;
		this.bodyDef = new BodyDef();
		this.friction = 0.2f;
		this.density = 1.0f;
		this.maximumVelocity = 1.0f;
		this.collisionId = CollisionIds.NONE;
		this.fixtures = new ArrayList<>();
		this.sensors = new ArrayList<>();
	}

	@Override
	public IPhysicsEntity build() {
		final Body body = this.world.createBody(this.bodyDef);
		final List<Fixture> fixtures = createFixtures(body);
		final List<JBox2dPhysicsSensor> sensors = createSensors(body);
		final JBox2dPhysicsEntity jBox2dPhysicsEntity = new JBox2dPhysicsEntity(this.contactListener, body, fixtures,
				sensors);
		jBox2dPhysicsEntity.setMaximumVelocity(this.maximumVelocity);
		return jBox2dPhysicsEntity;
	}

	private List<Fixture> createFixtures(Body body) {
		final ArrayList<Fixture> fixtures = new ArrayList<>();
		for (final FixtureDef fixtureDef : this.fixtures) {
			fixtureDef.friction = this.friction;
			fixtureDef.density = this.density;
			fixtureDef.filter.groupIndex = CollisionGroup.WORLD;
			final Fixture fixture = body.createFixture(fixtureDef);
			fixtures.add(fixture);
		}
		return fixtures;
	}

	private List<JBox2dPhysicsSensor> createSensors(Body body) {
		final ArrayList<JBox2dPhysicsSensor> sensors = new ArrayList<>();
		for (final FixtureDef fixtureDefinition : this.sensors) {
			final Fixture fixture = body.createFixture(fixtureDefinition);
			sensors.add(new JBox2dPhysicsSensor(fixture));
		}
		return sensors;
	}

	@Override
	public IPhysicsBuilder setDynamic() {
		this.bodyDef.type = BodyType.DYNAMIC;
		return this;
	}

	@Override
	public IPhysicsBuilder setStatic() {
		this.bodyDef.type = BodyType.STATIC;
		return this;
	}

	@Override
	public IPhysicsBuilder friction(float friction) {
		this.friction = friction;
		return this;
	}

	@Override
	public IPhysicsBuilder density(float density) {
		this.density = density;
		return this;
	}

	@Override
	public IPhysicsBuilder addCircle(float radius) {
		return addCircle(radius, 0, 0);
	}

	@Override
	public IPhysicsBuilder addCircle(float radius, float x, float y) {
		final FixtureDef fixtureDef = createFixtureDef();
		final CircleShape circleShape = new CircleShape();
		circleShape.m_radius = radius;
		circleShape.m_p.set(x, y);
		fixtureDef.shape = circleShape;
		this.fixtures.add(fixtureDef);
		return this;
	}

	@Override
	public IPhysicsBuilder addRectangle(Rectangle rectangle) {
		final FixtureDef fixtureDef = createFixtureDef();
		final PolygonShape polygonShape = convertRectangle(rectangle);
		fixtureDef.shape = polygonShape;
		this.fixtures.add(fixtureDef);
		return this;
	}

	private FixtureDef createFixtureDef() {
		final FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.userData = this.collisionId;
		return fixtureDef;
	}

	@Override
	public IPhysicsBuilder addPolygon(PointSet pointSet) {
		assert (pointSet.size() <= Settings.maxPolygonVertices);
		if (pointSet.size() == 0) {
			return this;
		}
		final PolygonShape polygonShape = new PolygonShape();
		final Vec2[] vertices = new Vec2[pointSet.size()];
		final Vector2f[] points = pointSet.getPoints();
		for (int i = 0; i < points.length; i++) {
			vertices[i] = new Vec2(points[i].x, points[i].y);
		}

		polygonShape.set(vertices, vertices.length);
		final FixtureDef fixtureDef = createFixtureDef();
		fixtureDef.shape = polygonShape;
		this.fixtures.add(fixtureDef);
		return this;
	}

	@Override
	public IPhysicsBuilder disableRotation() {
		this.bodyDef.fixedRotation = true;
		return this;
	}

	@Override
	public IPhysicsBuilder disableSleep() {
		this.bodyDef.allowSleep = false;
		return this;
	}

	@Override
	public IPhysicsBuilder limitVelocity(float maxVelocity) {
		this.maximumVelocity = maxVelocity;
		return this;
	}

	@Override
	public IPhysicsBuilder position(float x, float y) {
		this.bodyDef.position.set(x, y);
		return this;
	}

	@Override
	public IPhysicsBuilder collisionId(int collisionId) {
		this.collisionId = collisionId;
		return this;
	}

	@Override
	public IPhysicsBuilder rectangleSensor(int sensorId, Rectangle rectangle) {
		final PolygonShape polygonShape = convertRectangle(rectangle);
		final FixtureDef fixtureDef = createFixtureDef();
		fixtureDef.isSensor = true;
		fixtureDef.shape = polygonShape;
		fixtureDef.userData = sensorId;
		this.sensors.add(fixtureDef);
		return this;
	}

	private PolygonShape convertRectangle(Rectangle r) {
		final PolygonShape polygonShape = new PolygonShape();
		final Vec2[] vertices = new Vec2[4];
		vertices[0] = new Vec2(r.getMinX(), r.getMinY());
		vertices[1] = new Vec2(r.getMaxX(), r.getMinY());
		vertices[2] = new Vec2(r.getMaxX(), r.getMaxY());
		vertices[3] = new Vec2(r.getMinX(), r.getMaxY());
		polygonShape.set(vertices, 4);
		return polygonShape;
	}
}
