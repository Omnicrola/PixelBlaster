package com.omnicrola.pixelblaster.physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class PhysicsManager implements IGameSubsystem, IPhysicsManager {

	private World world;

	@Override
	public void addEntity(IGameEntity entity) {
		final EntityPhysicsDefinition physicsDefinition = entity.getPhysicsDefinition();
		final boolean usesPhysics = !physicsDefinition.getPhysicsType().equals(PhysicsType.NONE);
		if (usesPhysics) {
			final Body body = this.world.createBody(physicsDefinition.getPhysicsBody());
			body.createFixture(physicsDefinition.getShape(), physicsDefinition.getDensity());
			final PhysicsLinkBehavior physicsLinkBehavior = new PhysicsLinkBehavior(body);
			entity.addUpdateBehavior(physicsLinkBehavior);
		}
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IPhysicsManager.class, this);
	}

	@Override
	public void init(IGameContext context) throws SlickException {
		this.world = new World(new Vec2(0, 1), true);
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		this.world.step(delta, 1, 1);
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

}
