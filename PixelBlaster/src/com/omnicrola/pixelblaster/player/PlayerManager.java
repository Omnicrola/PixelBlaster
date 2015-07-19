package com.omnicrola.pixelblaster.player;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.EntitySprite;
import com.omnicrola.pixelblaster.entity.IEntityManager;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class PlayerManager implements IGameSubsystem, IPlayerManager {

	private Player player;
	private PlayerKeyListener keyListener;

	public PlayerManager() {
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IPlayerManager.class, this);
	}

	@Override
	public void init(IGameContext context) throws SlickException {
		buildPlayer();
		this.keyListener = new PlayerKeyListener(this.player);
		context.getSubsystem(IEntityManager.class).addEntity(this.player);
		context.getInput().addKeyListener(this.keyListener);

	}

	private void buildPlayer() throws SlickException {
		final Image image = new Image("sprites/alienGreen_stand.png");
		final EntitySprite baseShape = new EntitySprite(image, new Rectangle(0, 0, 1f, 2f));
		this.player = new Player(baseShape);
		this.player.setPosition(new Vector2f(1, 1));
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		this.keyListener.update(delta);
		gameContext.getCamera().focusOn(this.player);
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

}
