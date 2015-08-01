package com.omnicrola.pixelblaster.physics.jbox2d;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;

import com.omnicrola.pixelblaster.physics.IModifierToken;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsModifier;

public class JBox2DPhysicsModifier implements IPhysicsModifier {
	public static class ModifierToken implements IModifierToken {

		private final Fixture fixture;

		public ModifierToken(Fixture fixture) {
			this.fixture = fixture;
		}

		@Override
		public void destroy() {
			this.fixture.m_body.destroyFixture(this.fixture);
		}

	}

	private FixtureDef fixtureDef;
	private final JBox2dPhysicsEntity physicsEntity;

	public JBox2DPhysicsModifier(IPhysicsEntity physicsEntity) {
		assert (physicsEntity instanceof JBox2dPhysicsEntity);
		this.physicsEntity = (JBox2dPhysicsEntity) physicsEntity;
	}

	@Override
	public IPhysicsModifier addCircleShape(float radius, float x, float y) {
		this.fixtureDef = new FixtureDef();
		final CircleShape circleShape = new CircleShape();
		circleShape.m_radius = radius;
		circleShape.m_p.x = x;
		circleShape.m_p.y = y;
		this.fixtureDef.shape = circleShape;
		return this;
	}

	@Override
	public IPhysicsModifier density(float density) {
		this.fixtureDef.density = density;
		return this;
	}

	@Override
	public IPhysicsModifier friction(float friction) {
		this.fixtureDef.friction = friction;
		return this;
	}

	@Override
	public IPhysicsModifier collisionId(int id) {
		this.fixtureDef.userData = id;
		return this;
	}

	@Override
	public IModifierToken modify() {
		assert (this.fixtureDef != null);
		final Fixture fixture = this.physicsEntity.addFixture(this.fixtureDef);
		return new ModifierToken(fixture);
	}

}
