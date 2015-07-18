package com.omnicrola.pixelblaster.collision;

import java.util.ArrayList;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;
import com.omnicrola.pixelblaster.map.IMapManager;

public class CollisionManager implements IGameSubsystem, ICollisionManager {
	private final ArrayList<ICollidable> collidables;

	public CollisionManager() {
		this.collidables = new ArrayList<>();
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(ICollisionManager.class, this);
	}

	@Override
	public void init(IGameContext context) {
		this.collidables.clear();
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		final IMapManager mapManager = gameContext.getSubsystem(IMapManager.class);
		collideWithFloor(delta, mapManager);
	}

	private void collideWithFloor(float delta, final IMapManager mapManager) {
		for (final ICollidable entity : this.collidables) {
			final Vector2f position = entity.getPosition();
			final float elevation = mapManager.getFloorFrom(position);
			final Vector2f velocity = entity.getVelocity();
			if (position.y < elevation) {
				velocity.y += GameSettings.GRAVITY_ACCELLERATION * delta;
			} else if (velocity.y > 0) {
				velocity.y = 0;
			}
			entity.setVelocity(velocity);
		}
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

	@Override
	public void addCollidable(ICollidable collidable) {
		this.collidables.add(collidable);
	}

}
