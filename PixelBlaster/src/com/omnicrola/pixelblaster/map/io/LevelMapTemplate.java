package com.omnicrola.pixelblaster.map.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;

import com.omnicrola.pixelblaster.graphics.GameBackground;
import com.omnicrola.pixelblaster.map.BasicLevelMap;
import com.omnicrola.pixelblaster.map.EntityFactory;
import com.omnicrola.pixelblaster.map.ILevelMap;
import com.omnicrola.pixelblaster.map.IMapTile;
import com.omnicrola.pixelblaster.map.MapTileDataSet;
import com.omnicrola.pixelblaster.physics.CollisionIdentifier;
import com.omnicrola.pixelblaster.physics.IPhysicsEntity;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.util.AssetManager;
import com.omnicrola.pixelblaster.util.PointSet;

public class LevelMapTemplate {

	private static final float HORIZ_PHYSICS_OFFSET = 0.5f;
	private final float tileSize;
	private final IPhysicsManager physicsManager;
	private final XmlMapData mapData;
	private final PowerupFactory powerupFactory;
	private final MapTileLoader mapTileLoader;
	private final AssetManager assetManager;
	private final EntityFactory entityFactory;

	public LevelMapTemplate(float tileSize, MapTileLoader mapTileLoader, XmlMapData mapData,
			PowerupFactory powerupFactory, EntityFactory entityFactory, IPhysicsManager physicsManager,
			AssetManager assetManager) {
		this.tileSize = tileSize;
		this.mapTileLoader = mapTileLoader;
		this.mapData = mapData;
		this.powerupFactory = powerupFactory;
		this.entityFactory = entityFactory;
		this.physicsManager = physicsManager;
		this.assetManager = assetManager;

		mapData.mapBounds.setTileSize(tileSize);
	}

	public ILevelMap load() {
		final MapTileDataSet tileData = loadTiles();
		this.powerupFactory.buildAll(this.tileSize, this.mapData.powerups);
		this.entityFactory.buildAll(this.tileSize, this.mapData.entities);
		final GameBackground background = createBackground();
		return new BasicLevelMap(this.tileSize, tileData, background, this.mapData);
	}

	private MapTileDataSet loadTiles() {
		final MapTileDataSet tileData = this.mapTileLoader.loadData(this.mapData);
		final List<IPhysicsEntity> physicsEntities = new ArrayList<>();
		tileData.allButAir((x, y, mapTile) -> physicsEntities.add(createPhysics(x, y, mapTile)));
		return tileData;
	}

	private GameBackground createBackground() {
		final String background = "Backgrounds" + File.separator + this.mapData.background;
		final Image image = this.assetManager.getImage(background);
		return new GameBackground(image);
	}

	//@formatter:off
	private IPhysicsEntity createPhysics(float pX, float pY, IMapTile mapTile) {
		pX *= this.tileSize;
		pY *= this.tileSize;
		final PointSet shape = mapTile.getShape();
		return this.physicsManager.getBuilder()
				.setStatic()
				.collisionId(CollisionIdentifier.MAP_TILE)
				.friction(0.9f)
				.position(pX + HORIZ_PHYSICS_OFFSET, pY)
				.addPolygon(shape)
				.build();
	}
	//@formatter:on

}
