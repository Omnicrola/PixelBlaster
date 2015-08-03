package com.omnicrola.pixelblaster.physics.jbox2d;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.FixtureDef;

import com.omnicrola.pixelblaster.physics.CircleSensor;
import com.omnicrola.pixelblaster.physics.ISensorInspector;
import com.omnicrola.pixelblaster.physics.RectangleSensor;

public class JBox2DSensorInspector implements ISensorInspector {
	private final Body body;

	public JBox2DSensorInspector(Body body) {
		this.body = body;
	}

	@Override
	public void iAm(CircleSensor circleSensor) {
		final CircleShape circleShape = new CircleShape();
		circleShape.m_radius = circleSensor.getRadius();
		circleShape.m_p.set(circleSensor.getX(), circleSensor.getY());
		final FixtureDef sensorDef = new FixtureDef();
		sensorDef.isSensor = true;
		sensorDef.shape = circleShape;
		sensorDef.userData = circleSensor.getCollisionPair().getPrimary();
		this.body.createFixture(sensorDef);
	}

	@Override
	public void iAm(RectangleSensor rectangleSensor) {
		final PolygonShape polygonShape = JBox2DPhysicsBuilder.convertRectangle(rectangleSensor.getRectangle());
		final FixtureDef sensorDef = new FixtureDef();
		sensorDef.isSensor = true;
		sensorDef.shape = polygonShape;
		sensorDef.userData = rectangleSensor.getCollisionPair().getPrimary();
		this.body.createFixture(sensorDef);
	}

}
