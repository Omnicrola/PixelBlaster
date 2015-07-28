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
import com.omnicrola.pixelblaster.physics.CollisionIds;
import com.omnicrola.pixelblaster.physics.IPhysicsManager;
import com.omnicrola.pixelblaster.util.AssetManager;

public class PlayerManager implements IGameSubsystem, IPlayerManager {

	private PlayerKeyListener keyListener;
	private IGameContext context;
	private final PlayerBuilder playerBuilder;
	private PlayerModel playerModel;
	private PlayerController playerController;

	public PlayerManager(PlayerBuilder playerBuilder) {
		this.playerBuilder = playerBuilder;
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IPlayerManager.class, this);
		this.playerModel = new PlayerModel();
	}

	@Override
	public void init(IGameContext context) throws SlickException {
		this.context = context;
		buildPlayer(context.getSubsystem(IEntityManager.class));
		this.keyListener = new PlayerKeyListener(this.playerController);
		context.getInput().addKeyListener(this.keyListener);
	}

	private void buildPlayer(IEntityManager entityManager) throws SlickException {
		final AssetManager assetManager = this.context.getAssetManager();
		final IPhysicsManager subsystem = this.context.getSubsystem(IPhysicsManager.class);
		final MultiStateEntity playerEntity = this.playerBuilder.build(assetManager, subsystem);

		this.playerModel.setEntity(playerEntity);
		entityManager.addEntity(playerEntity);
		this.playerController = new PlayerController(this.playerModel);
		final PlayerFootCollisionDetector footDetector = new PlayerFootCollisionDetector(CollisionIds.PLAYER_FOOT,
				this.playerController);
		playerEntity.getPhysics().addCollisionDetector(footDetector);
		respawnPlayer();
	}

	private void respawnPlayer() {
		final IMapManager mapManager = this.context.getSubsystem(IMapManager.class);
		final Vector2f spawnPoint = mapManager.getPlayerSpawn();
		this.playerModel.getEntity().setPosition(spawnPoint);
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		this.keyListener.update(delta);
		gameContext.getCamera().focusOn(this.playerModel.getEntity());
		containPlayerInMap();
	}

	private void containPlayerInMap() {
		final IMapManager mapManager = this.context.getSubsystem(IMapManager.class);
		final MapBounds mapBounds = mapManager.getMapBounds();
		mapBounds.containEntity(this.playerModel.getEntity());
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

}
