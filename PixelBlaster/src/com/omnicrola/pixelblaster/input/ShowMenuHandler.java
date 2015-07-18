package com.omnicrola.pixelblaster.input;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;
import com.omnicrola.pixelblaster.main.MenuState;
import com.omnicrola.pixelblaster.main.PixelBlasterGame;

public class ShowMenuHandler implements IGameSubsystem, KeyListener {

	private final PixelBlasterGame game;
	private final MenuState menuState;

	public ShowMenuHandler(PixelBlasterGame game, MenuState menuState) {
		this.game = game;
		this.menuState = menuState;
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
			this.game.setState(this.menuState);
		}
	}

}
