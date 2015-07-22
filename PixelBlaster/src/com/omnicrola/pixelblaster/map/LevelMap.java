package com.omnicrola.pixelblaster.map;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.Shape;

import com.omnicrola.pixelblaster.graphics.GameBackground;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.physics.IPhysicsBody;
import com.omnicrola.pixelblaster.physics.IPhysicsWrapper;
import com.omnicrola.pixelblaster.physics.PhysicsDefinition;
import com.omnicrola.pixelblaster.physics.PhysicsType;

public class LevelMap implements ILevelMap {

	private static final float HORIZ_PHYSICS_OFFSET = 0.5f;
	private final short[][] tileData;
	private final IMapTile[] mapTiles;
	private final float tileSize;
	private final List<IPhysicsBody> physicsBodies;
	private final GameBackground background;

	public LevelMap(float tileSize, IMapTile[] mapTiles, short[][] tileData, GameBackground background) {
		this.tileSize = tileSize;
		this.mapTiles = mapTiles;
		this.tileData = tileData;
		this.background = background;
		this.physicsBodies = new ArrayList<>();
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		this.background.render(graphics);
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
		for ( int x = 0; x < this.tileData.length; x++) {
			for (int y = 0; y < this.tileData[x].length; y++) {
				final short tileIndex = this.tileData[x][y];
				final IMapTile mapTile = this.mapTiles[tileIndex];
				if (!mapTile.equals(MapTile.AIR)) {
					final float pX = x * this.tileSize;
					final float pY = y * this.tileSize;
					createPhysics(physics, mapTile.getShape(), pX, pY);
				}
			}
		}

	}

	private void createPhysics(IPhysicsWrapper physics, Shape shape, float pX, float pY) {
		final PhysicsDefinition physicsDefinition = new PhysicsDefinition(shape);
		physicsDefinition.setPosition(pX + HORIZ_PHYSICS_OFFSET, pY);
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
