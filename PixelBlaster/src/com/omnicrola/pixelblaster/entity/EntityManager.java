package com.omnicrola.pixelblaster.entity;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class EntityManager implements IGameSubsystem, IEntityManager {
	private final ArrayList<IGameEntity> entities;
	private final ArrayList<IGameEntity> entityCopies;

	public EntityManager() {
		this.entities = new ArrayList<>();
		this.entityCopies = new ArrayList<>();
	}

	@Override
	public void addEntity(IGameEntity entity) {
		this.entities.add(entity);
	}

	@Override
	public void init(GameContainer container, GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IEntityManager.class, this);
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
			}
		}
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		for (final IGameEntity gameEntity : this.entities) {
			graphics.drawShape(gameEntity.getShape());
		}
	}

}
