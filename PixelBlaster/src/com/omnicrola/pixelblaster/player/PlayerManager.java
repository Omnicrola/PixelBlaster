package com.omnicrola.pixelblaster.player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.entity.EntityShape;
import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class PlayerManager implements IGameSubsystem, IPlayerHandler {

	private Player player;

	public PlayerManager() {
	}

	@Override
	public void init(GameContainer container, GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IPlayerHandler.class, this);
		try {
			this.player = new Player(new EntityShape(new Image("sprites/alienGreen_stand.png")));
		} catch (final SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

}
