package com.omnicrola.pixelblaster.entity;

import com.omnicrola.pixelblaster.physics.IModifierToken;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.physics.IPhysicsModifier;
import com.omnicrola.pixelblaster.physics.contact.CollisionIdentifier;
import com.omnicrola.pixelblaster.player.MultiStateEntity;

public class BubbleBuilder {
	private static final float RADIUS = 1.0f;
	private final IPhysicsManager physicsManager;

	public BubbleBuilder(IPhysicsManager physicsManager) {
		this.physicsManager = physicsManager;
	}

	//@formatter:off
	public IModifierToken envelop(MultiStateEntity player) {
		final IPhysicsModifier modifier = player.modifyPhysics(this.physicsManager);
		final IModifierToken modifierToken = modifier
				.addCircleShape(RADIUS, 0.0f, 0.0f)
				.density(0.0f)
				.collisionId(CollisionIdentifier.BUBBLE)
				.modify();
		return modifierToken;
	}
	//@formatter:on

}
