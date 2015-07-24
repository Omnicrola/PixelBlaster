package com.omnicrola.pixelblaster.map;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.Shape;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.GameBackground;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.physics.IPhysicsBody;
import com.omnicrola.pixelblaster.physics.IPhysicsWrapper;
import com.omnicrola.pixelblaster.physics.PhysicsDefinition;
import com.omnicrola.pixelblaster.physics.PhysicsType;
import com.omnicrola.pixelblaster.util.Coordinate;

public class LevelMap implements ILevelMap {

	private static final float HORIZ_PHYSICS_OFFSET = 0.5f;
	private final MapTileDataSet tileData;
	private final float tileSize;
	private final List<IPhysicsBody> physicsBodies;
	private final GameBackground background;
	private final XmlMapData mapData;

	public LevelMap(float tileSize, MapTileDataSet tileData, GameBackground background, XmlMapData mapData) {
		this.tileSize = tileSize;
		this.tileData = tileData;
		this.background = background;
		this.mapData = mapData;
		this.physicsBodies = new ArrayList<>();

		mapData.mapBounds.setTileSize(tileSize);
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		this.background.render(graphics);
		this.tileData.allTiles((x, y, mapTile) -> mapTile.render(x * this.tileSize, y * this.tileSize, graphics));
	}

	@Override
	public void create(IPhysicsWrapper physics) {
		this.tileData.allButAir((x, y, mapTile) -> createPhysics(physics, mapTile.getShape(), x
				* LevelMap.this.tileSize, y * LevelMap.this.tileSize));
	}

	@Override
	public Vector2f getPlayerSpawn() {
		final Coordinate playerSpawn = this.mapData.playerSpawn;
		final float x = playerSpawn.getX() * this.tileSize;
		final float y = playerSpawn.getY() * this.tileSize;
		return new Vector2f(x, y);
	}

	private void createPhysics(IPhysicsWrapper physics, Shape shape, float pX, float pY) {
		final PhysicsDefinition physicsDefinition = new PhysicsDefinition(shape);
		physicsDefinition.setPosition(pX + HORIZ_PHYSICS_OFFSET, pY);
		physicsDefinition.setFriction(0.9f);
		physicsDefinition.setType(PhysicsType.STATIC);
		physics.createBody(physicsDefinition);
	}

	@Override
	public MapBounds getMapBounds() {
		return this.mapData.mapBounds;
	}

	@Override
	public void destroy(IPhysicsWrapper physics) {
		for (final IPhysicsBody body : this.physicsBodies) {
			physics.destroyBody(body);
		}
	}
}
