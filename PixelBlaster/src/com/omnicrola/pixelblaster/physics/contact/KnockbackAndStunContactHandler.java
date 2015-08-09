package com.omnicrola.pixelblaster.physics.contact;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.behavior.StunBehavior;
import com.omnicrola.pixelblaster.physics.IPhysicsCollision;

public class KnockbackAndStunContactHandler implements IPhysicsContactHandler {

	private final IGameEntity gameEntity;

	public KnockbackAndStunContactHandler(IGameEntity gameEntity) {
		this.gameEntity = gameEntity;
	}

	@Override
	public void contactOccured(IPhysicsCollision physicsCollision) {
		final Vector2f impactVector = physicsCollision.getImpactVector();
		this.gameEntity.applyImpulseAtCenter(impactVector);
		this.gameEntity.addUpdateBehavior(new StunBehavior(2000));
	}

}
