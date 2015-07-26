package com.omnicrola.pixelblaster.map;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.Shape;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.graphics.GameBackground;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.physics.IPhysicsWrapper;
import com.omnicrola.pixelblaster.physics.PhysicsDefinition;
import com.omnicrola.pixelblaster.physics.PhysicsType;
import com.omnicrola.pixelblaster.util.Coordinate;

public class LevelMap implements ILevelMap {

	private static final float HORIZ_PHYSICS_OFFSET = 0.5f;
	private final MapTileDataSet tileData;
	private final float tileSize;
	private final List<IPhysicsEntity> physicsEntities;
	private final GameBackground background;
	private final XmlMapData mapData;

	public LevelMap(float tileSize, MapTileDataSet tileData, GameBackground background, XmlMapData mapData) {
		this.tileSize = tileSize;
		this.tileData = tileData;
		this.background = background;
		this.mapData = mapData;
		this.physicsEntities = new ArrayList<>();

		mapData.mapBounds.setTileSize(tileSize);
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		this.background.render(graphics);
		this.tileData.allTiles((x, y, mapTile) -> mapTile.render(x * this.tileSize, y * this.tileSize, graphics));
	}

	@Override
	public void loadPhysics(IPhysicsManager physicsManager) {
		this.tileData.allButAir((x, y, mapTile) -> createPhysics(physicsManager, mapTile.getShape(),
				x * LevelMap.this.tileSize, y * LevelMap.this.tileSize));
	}

	@Override
	public Vector2f getPlayerSpawn() {
		final Coordinate playerSpawn = this.mapData.playerSpawn;
		final float x = playerSpawn.getX() * this.tileSize;
		final float y = playerSpawn.getY() * this.tileSize;
		return new Vector2f(x, y);
	}

	private void createPhysics(IPhysicsManager physicsManager, Shape shape, float pX, float pY) {
		final PhysicsDefinition physicsDefinition = new PhysicsDefinition(shape);
		physicsDefinition.setPosition(pX + HORIZ_PHYSICS_OFFSET, pY);
		physicsDefinition.setFriction(0.9f);
		physicsDefinition.setType(PhysicsType.STATIC);
		final IPhysicsEntity physics = physicsManager.createPhysics(physicsDefinition);
		this.physicsEntities.add(physics);
	}

	@Override
	public MapBounds getMapBounds() {
		return this.mapData.mapBounds;
	}

	@Override
	public void destroy(IPhysicsWrapper physics) {
		for (final IPhysicsEntity entity : this.physicsEntities) {
			physics.destroyEntity(entity);
		}
	}

	@Override
	public void setMaximumVelocity(float maximumVelocity) {
	}

	@Override
	public void setPosition(Vector2f position) {
	}

	@Override
	public void update(IGameEntity gameEntity, float delta) {
	}

	@Override
	public void moveRight(float force) {
	}

	@Override
	public void moveLeft(float force) {
	}

	@Override
	public void moveUp(float force) {
	}

	@Override
	public void moveDown(float force) {
	}

	@Override
	public void jump(float force) {
	}
}
