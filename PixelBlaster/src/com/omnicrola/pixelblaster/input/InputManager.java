package com.omnicrola.pixelblaster.input;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSettings;
import com.omnicrola.pixelblaster.main.GameStates;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class InputManager extends AbstractKeyListener implements IGameSubsystem {

	private final StateBasedGame game;

	public InputManager(StateBasedGame game) {
		this.game = game;
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
	}

	@Override
	public void init(IGameContext context) throws SlickException {
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

	@Override
	public void keyReleased(int key, char c) {
		if (key == Keyboard.KEY_ESCAPE) {
			transitionToMenu();
		}
		if (key == Keyboard.KEY_F3) {
			GameSettings.DEBUG = !GameSettings.DEBUG;
		}
		if (key == Keyboard.KEY_F4) {
			GameSettings.DEBUG_PHYSICS = !GameSettings.DEBUG_PHYSICS;
		}
	}

	private void transitionToMenu() {
		final FadeOutTransition leave = new FadeOutTransition(Color.black, 250);
		final FadeInTransition enter = new FadeInTransition(Color.black, 250);
		this.game.enterState(GameStates.MAIN_MENU.ordinal(), leave, enter);
	}

	@Override
	public void enter(IGameContext context) {
		context.getInput().addKeyListener(this);
	}

	@Override
	public void leave(IGameContext context) {
		context.getInput().removeKeyListener(this);
	}

}
