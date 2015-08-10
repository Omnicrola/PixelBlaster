package com.omnicrola.pixelblaster.physics.contact;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.behavior.BinaryBehaviorController;
import com.omnicrola.pixelblaster.entity.behavior.DelayedAlternateBehaviorSwitch;
import com.omnicrola.pixelblaster.entity.behavior.DelayedPrimaryBehaviorSwitch;
import com.omnicrola.pixelblaster.physics.IPhysicsCollision;

public class KnockbackAndStunContactHandler implements IPhysicsContactHandler {

	private final IGameEntity gameEntity;
	private final BinaryBehaviorController binaryBehaviorController;

	public KnockbackAndStunContactHandler(IGameEntity gameEntity, BinaryBehaviorController binaryBehaviorController) {
		this.gameEntity = gameEntity;
		this.binaryBehaviorController = binaryBehaviorController;
	}

	@Override
	public void contactOccured(IPhysicsCollision physicsCollision) {
		final Vector2f impactVector = physicsCollision.getImpactVector();
		this.gameEntity.applyImpulseAtCenter(impactVector.scale(2f));

		this.gameEntity.addUpdateBehavior(new DelayedAlternateBehaviorSwitch(this.binaryBehaviorController, 500));
		this.gameEntity.addUpdateBehavior(new DelayedPrimaryBehaviorSwitch(this.binaryBehaviorController, 2000));
	}

}
