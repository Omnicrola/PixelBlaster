package com.omnicrola.pixelblaster.map;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.PolygonShape;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.physics.IPhysicsBody;
import com.omnicrola.pixelblaster.physics.IPhysicsWrapper;
import com.omnicrola.pixelblaster.physics.PhysicsDefinition;
import com.omnicrola.pixelblaster.physics.PhysicsType;

public class LevelMap implements ILevelMap {

	private final short[][] tileData;
	private final IMapTile[] mapTiles;
	private final float tileSize;
	private final List<IPhysicsBody> physicsBodies;

	public LevelMap(float tileSize, IMapTile[] mapTiles, short[][] tileData) {
		this.tileSize = tileSize;
		this.mapTiles = mapTiles;
		this.tileData = tileData;
		this.physicsBodies = new ArrayList<>();
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		for (int x = 0; x < this.tileData.length; x++) {
			for (int y = 0; y < this.tileData[x].length; y++) {
				final short tileIndex = this.tileData[x][y];
				final IMapTile tile = this.mapTiles[tileIndex];
				tile.render(x * this.tileSize, y * this.tileSize, graphics);
			}
		}
	}

	@Override
	public void create(IPhysicsWrapper physics) {
		for (int x = 0; x < this.tileData.length; x++) {
			for (int y = 0; y < this.tileData[x].length; y++) {
				final short tileIndex = this.tileData[x][y];
				final IMapTile mapTile = this.mapTiles[tileIndex];
				if (!mapTile.equals(MapTile.AIR)) {
					final float pX = x * this.tileSize;
					final float pY = y * this.tileSize;
					createPhysics(physics, pX, pY);
				}
			}
		}

	}

	private void createPhysics(IPhysicsWrapper physics, float pX, float pY) {
		final PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(this.tileSize, this.tileSize);
		final PhysicsDefinition physicsDefinition = new PhysicsDefinition(polygonShape);
		physicsDefinition.setPosition(pX, pY);
		physicsDefinition.setType(PhysicsType.STATIC);
		physics.createBody(physicsDefinition);

	}

	@Override
	public void destroy(IPhysicsWrapper physics) {
		for (final IPhysicsBody body : this.physicsBodies) {
			physics.destroyBody(body);
		}
	}
}
