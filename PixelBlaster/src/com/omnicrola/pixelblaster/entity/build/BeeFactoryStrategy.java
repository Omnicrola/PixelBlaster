package com.omnicrola.pixelblaster.entity.build;

import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.graphics.IEntitySprite;
import com.omnicrola.pixelblaster.graphics.SpriteBuilder;
import com.omnicrola.pixelblaster.graphics.SpriteData;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;

public class BeeFactoryStrategy implements IEntityFactoryStrategy {
	private final SpriteData spriteData;

	public BeeFactoryStrategy() {
		this.spriteData = new SpriteData("bee", new Rectangle(0, 0, 1f, 1f));
	}

	@Override
	public IEntitySprite buildSprite(SpriteBuilder spriteBuilder) {
		return spriteBuilder.build(this.spriteData);
	}

	@Override
	//@formatter:off
	public IPhysicsEntity buildPhysics(IPhysicsManager physicsManager) {
		return physicsManager.getBuilder()
				.setDynamic()
				.disableRotation()
				.affectedByGravity(false)
				.addCircle(0.25f, 0, -0.5f)
				.build();
	}
	//@formatter:on

}
