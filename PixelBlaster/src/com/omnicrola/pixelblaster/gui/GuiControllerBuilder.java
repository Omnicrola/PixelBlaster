package com.omnicrola.pixelblaster.gui;

import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.player.IPlayerManager;

public class GuiControllerBuilder {

	public GuiController build(IGameContext context) {
		final IPlayerManager playerManager = context.getSubsystem(IPlayerManager.class);
		return new GuiController(playerManager);
	}

}
