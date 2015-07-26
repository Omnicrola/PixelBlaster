package com.omnicrola.pixelblaster.player;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;
import com.omnicrola.pixelblaster.map.IMapManager;
import com.omnicrola.pixelblaster.map.MapBounds;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.util.AssetManager;

public class PlayerManager implements IGameSubsystem, IPlayerManager {

	private Player player;
	private PlayerKeyListener keyListener;
	private IGameContext context;
	private final PlayerBuilder playerBuilder;

	public PlayerManager(PlayerBuilder playerBuilder) {
		this.playerBuilder = playerBuilder;
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IPlayerManager.class, this);
	}

	@Override
	public void init(IGameContext context) throws SlickException {
		this.context = context;
		buildPlayer();
		this.keyListener = new PlayerKeyListener(this.player);
		final IEntityManager entityManager = context.getSubsystem(IEntityManager.class);
		entityManager.addEntity(this.player);
		entityManager.addEntity(this.player.getBubble());
		context.getInput().addKeyListener(this.keyListener);
	}

	private void buildPlayer() throws SlickException {
		final AssetManager assetManager = this.context.getAssetManager();
		final IPhysicsManager subsystem = this.context.getSubsystem(IPhysicsManager.class);
		this.player = this.playerBuilder.build(assetManager, subsystem);
		respawnPlayer();
	}

	private void respawnPlayer() {
		final IMapManager mapManager = this.context.getSubsystem(IMapManager.class);
		final Vector2f spawnPoint = mapManager.getPlayerSpawn();
		this.player.setPosition(spawnPoint);
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		this.keyListener.update(delta);
		gameContext.getCamera().focusOn(this.player);
		containPlayerInMap();
	}

	private void containPlayerInMap() {
		final IMapManager mapManager = this.context.getSubsystem(IMapManager.class);
		final MapBounds mapBounds = mapManager.getMapBounds();
		mapBounds.containEntity(this.player);
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

}
