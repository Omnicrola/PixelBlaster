package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.omnicrola.pixelblaster.gui.MainMenu;
import com.omnicrola.pixelblaster.gui.MainMenuBuilder;
import com.omnicrola.pixelblaster.input.MainMenuKeyHandler;

public class MenuState extends BasicGameState {

	private MainMenu menu;
	private final MainMenuBuilder menuBuilder;

	public MenuState(MainMenuBuilder menuBuilder) {
		this.menuBuilder = menuBuilder;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.menu = this.menuBuilder.build(game);
		final MainMenuKeyHandler keyHandler = new MainMenuKeyHandler(this.menu);
		container.getInput().addKeyListener(keyHandler);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException {
		this.menu.render(graphics, 0, 0);
	}

	@Override
	public int getID() {
		return GameStates.MAIN_MENU.ordinal();
	}

}
