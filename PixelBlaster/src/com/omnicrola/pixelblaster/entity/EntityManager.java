package com.omnicrola.pixelblaster.entity;

import java.util.ArrayList;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;

public class EntityManager implements IGameSubsystem, IEntityManager {
	private final ArrayList<IGameEntity> entities;
	private final ArrayList<IGameEntity> entityCopies;
	private IPhysicsManager physicsManager;

	public EntityManager() {
		this.entities = new ArrayList<>();
		this.entityCopies = new ArrayList<>();
	}

	@Override
	public void addEntity(IGameEntity entity) {
		this.entities.add(entity);
		this.physicsManager.loadPhysics(entity.getPhysics());
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IEntityManager.class, this);
	}

	@Override
	public void init(IGameContext context) {
		this.entities.clear();
		this.entityCopies.clear();
		this.physicsManager = context.getSubsystem(IPhysicsManager.class);
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		this.entityCopies.clear();
		this.entityCopies.addAll(this.entities);
		updateEntities(delta);
		removeDeadEntities();
	}

	private void updateEntities(float delta) {
		for (final IGameEntity gameEntity : this.entities) {
			gameEntity.update(delta);
		}
	}

	private void removeDeadEntities() {
		for (final IGameEntity gameEntity : this.entityCopies) {
			if (!gameEntity.isAlive()) {
				this.entities.remove(gameEntity);
				this.physicsManager.destroyPhysics(gameEntity.getPhysics());
			}
		}
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		for (final IGameEntity gameEntity : this.entities) {
			gameEntity.getSprite().render(graphics);
		}
	}

}
