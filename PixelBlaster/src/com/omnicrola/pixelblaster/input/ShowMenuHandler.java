package com.omnicrola.pixelblaster.input;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameStates;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class ShowMenuHandler implements IGameSubsystem, KeyListener {

	private final StateBasedGame game;

	public ShowMenuHandler(StateBasedGame game) {
		this.game = game;
	}

	@Override
	public void load(GameSubsystemInterlink interlink) {
	}

	@Override
	public void init(IGameContext context) throws SlickException {
		context.getInput().addKeyListener(this);
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
	}

	@Override
	public void setInput(Input input) {
	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void inputEnded() {
	}

	@Override
	public void inputStarted() {
	}

	@Override
	public void keyPressed(int key, char c) {
	}

	@Override
	public void keyReleased(int key, char c) {
		if (key == Keyboard.KEY_ESCAPE) {
			final FadeOutTransition leave = new FadeOutTransition(Color.black, 250);
			final FadeInTransition enter = new FadeInTransition(Color.black, 250);
			this.game.enterState(GameStates.MAIN_MENU.ordinal(), leave, enter);
		}
	}

}
