package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.gui.MainMenu;
import com.omnicrola.pixelblaster.gui.MainMenuBuilder;
import com.omnicrola.pixelblaster.input.MainMenuKeyHandler;

public class MenuState implements IGameState {

	private MainMenu menu;
	private final MainMenuBuilder menuBuilder;

	public MenuState(MainMenuBuilder menuBuilder) {
		this.menuBuilder = menuBuilder;
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.menu = this.menuBuilder.build();
		final MainMenuKeyHandler keyHandler = new MainMenuKeyHandler(this.menu);
		container.getInput().addKeyListener(keyHandler);
	}

	@Override
	public void update(GameContainer container, float delta) throws SlickException {
	}

	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
		this.menu.render(graphics, 0, 0);
	}

}
