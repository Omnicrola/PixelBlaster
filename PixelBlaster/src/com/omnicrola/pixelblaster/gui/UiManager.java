package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class UiManager implements IGameSubsystem, IUiManager {
	private IGameContext context;
	private final UserInterfaceBuilder userInterfaceBuilder;
	private final GuiControllerBuilder uiControllerBuilder;
	private IUserInterface rootElement;
	private GuiController userController;

	public UiManager(UserInterfaceBuilder userInterfaceBuilder, GuiControllerBuilder uiControllerBuilder) {
		this.userInterfaceBuilder = userInterfaceBuilder;
		this.uiControllerBuilder = uiControllerBuilder;
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IUiManager.class, this);
	}

	@Override
	public void init(IGameContext context) throws SlickException {
		this.context = context;
		this.rootElement = this.userInterfaceBuilder.build(context);
		this.userController = this.uiControllerBuilder.build(context);
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
		this.userController.update(this.rootElement);
	}

	@Override
	public void render(IGraphicsWrapper graphicsWrapper) {
		final IGraphicsWrapper guiGraphics = this.context.getGuiGraphics();
		this.rootElement.render(guiGraphics);
	}

}
