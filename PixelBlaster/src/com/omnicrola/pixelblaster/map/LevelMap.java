package com.omnicrola.pixelblaster.map;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.graphics.GameBackground;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.physics.IPhysicsWrapper;
import com.omnicrola.pixelblaster.util.Coordinate;
import com.omnicrola.pixelblaster.util.PointSet;

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
		System.out.println("loading map physics");
		this.tileData.allButAir((x, y, mapTile) -> createPhysics(physicsManager, mapTile.getShape(), x
				* LevelMap.this.tileSize, y * LevelMap.this.tileSize));
		System.out.println("finished loading map physics");
	}

	@Override
	public Vector2f getPlayerSpawn() {
		final Coordinate playerSpawn = this.mapData.playerSpawn;
		final float x = playerSpawn.getX() * this.tileSize;
		final float y = playerSpawn.getY() * this.tileSize;
		return new Vector2f(x, y);
	}

	//@formatter:off
	private void createPhysics(IPhysicsManager physicsManager, PointSet shape, float pX, float pY) {
		final IPhysicsEntity physics = physicsManager.getBuilder()
				.setStatic()
				.friction(0.9f)
				.position(pX + HORIZ_PHYSICS_OFFSET, pY)
				.addPolygon(shape)
				.build();
		this.physicsEntities.add(physics);
	}
	//@formatter:on

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

}
