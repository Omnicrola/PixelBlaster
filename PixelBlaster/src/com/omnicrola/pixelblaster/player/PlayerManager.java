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
		this.player = new Player(new EntitySprite(new Image("sprites/alienGreen_stand.png"), new Rectangle(0, 0, 0.5f,
				1f)));
		this.player.setPosition(new Vector2f(1, 1));
		this.keyListener = new PlayerKeyListener(this.player);
		context.getSubsystem(IEntityManager.class).addEntity(this.player);
		context.getInput().addKeyListener(this.keyListener);

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
