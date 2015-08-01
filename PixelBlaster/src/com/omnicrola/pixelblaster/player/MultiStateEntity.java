package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.entity.GameEntity;
import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;
import com.omnicrola.pixelblaster.graphics.ISpriteState;
import com.omnicrola.pixelblaster.graphics.MultiStateSprite;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;

public class MultiStateEntity extends GameEntity {

	private final MultiStateSprite multistateSprite;

	public MultiStateEntity(MultiStateSprite multistateSprite, IPhysicsEntity physics) {
		super(multistateSprite, physics);
		this.multistateSprite = multistateSprite;
	}

	public void addState(ISpriteState state) {
		this.multistateSprite.addState(state);
	}

	public void removeState(ISpriteState state) {
		this.multistateSprite.removeState(state);
	}

	public void setFacing(Facing facing) {
		this.multistateSprite.setFacing(facing);
	}

}
