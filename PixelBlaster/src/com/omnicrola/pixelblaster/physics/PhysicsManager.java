package com.omnicrola.pixelblaster.physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;
import com.omnicrola.pixelblaster.physics.jbox2d.JBox2dPhysicsWrapper;

public class PhysicsManager implements IGameSubsystem, IPhysicsManager {

	private JBox2dPhysicsWrapper physicsWrapper;

	@Override
	public void loadPhysics(IEntityPhysics entityPhysics) {
		entityPhysics.create(this.physicsWrapper);
	}

	@Override
	public void destroyPhysics(IEntityPhysics physics) {
		physics.destroy(this.physicsWrapper);
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IPhysicsManager.class, this);
	}

	@Override
	public void init(IGameContext context) throws SlickException {
		final World world = new World(new Vec2(0, GameSettings.GRAVITY_ACCELLERATION), true);
		this.physicsWrapper = new JBox2dPhysicsWrapper(world);
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		this.physicsWrapper.step(delta, 6, 2);
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

}
