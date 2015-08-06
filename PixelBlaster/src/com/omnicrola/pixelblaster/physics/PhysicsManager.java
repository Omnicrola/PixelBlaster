package com.omnicrola.pixelblaster.physics;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.Camera;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;
import com.omnicrola.pixelblaster.physics.jbox2d.JBox2DPhysicsBuilder;
import com.omnicrola.pixelblaster.physics.jbox2d.JBox2DPhysicsModifier;
import com.omnicrola.pixelblaster.physics.jbox2d.JBox2dContactListener;
import com.omnicrola.pixelblaster.physics.jbox2d.Slick2dDebugDraw;

public class PhysicsManager implements IGameSubsystem, IPhysicsManager {

	private World world;
	private Slick2dDebugDraw slick2dDebugDraw;
	private Camera camera;
	private JBox2dContactListener contactListener;

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IPhysicsManager.class, this);
		this.world = new World(new Vec2(0, GameSettings.GRAVITY_ACCELLERATION));
		this.contactListener = new JBox2dContactListener();
		this.world.setContactListener(this.contactListener);
	}

	@Override
	public void init(IGameContext context) throws SlickException {
		this.camera = context.getCamera();
		final GameContainer container = context.getGameContainer();
		this.slick2dDebugDraw = new Slick2dDebugDraw(container.getGraphics());
		this.slick2dDebugDraw.setFlags(DebugDraw.e_shapeBit);
		this.world.setDebugDraw(this.slick2dDebugDraw);
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		this.world.step(delta, 6, 2);
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		this.camera.applyTo(this.slick2dDebugDraw.getViewportTranform());
		if (GameSettings.DEBUG_PHYSICS) {
			this.world.drawDebugData();
		}
	}

	@Override
	public IPhysicsBuilder getBuilder() {
		return new JBox2DPhysicsBuilder(this.world, this.contactListener);
	}

	@Override
	public IPhysicsModifier modifyEntity(IPhysicsEntity physicsEntity) {
		return new JBox2DPhysicsModifier(physicsEntity);
	}

	@Override
	public void enter(IGameContext context) {
	}

	@Override
	public void leave(IGameContext context) {
	}

}
