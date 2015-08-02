package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;
import com.omnicrola.pixelblaster.player.IPlayerManager;
import com.omnicrola.pixelblaster.player.PlayerController;

public class UiManager implements IGameSubsystem, IUiManager {
	private BubbleMeter bubbleMeter;
	private IGameContext context;

	public UiManager() {
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IUiManager.class, this);
	}

	@Override
	public void init(IGameContext context) throws SlickException {
		this.context = context;
		final Image fullIcon = context.getAssetManager().getImage("sprites/ui/squareBlue.png");
		final Image emptyIcon = context.getAssetManager().getImage("sprites/ui/squareWhite.png");
		this.bubbleMeter = new BubbleMeter(fullIcon, emptyIcon);
		this.bubbleMeter.setPosition(10, 10);

	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		final PlayerController playerModel = gameContext.getSubsystem(IPlayerManager.class).getPlayerController();
		final float power = playerModel.getBubblePower();
		final float maxPower = playerModel.getMaxBubblePower();

		this.bubbleMeter.setPercentageFull(power / maxPower);
	}

	@Override
	public void render(IGraphicsWrapper graphicsWrapper) {
		final IGraphicsWrapper guiGraphics = this.context.getGuiGraphics();
		this.bubbleMeter.render(guiGraphics, 0, 0);
	}

}
