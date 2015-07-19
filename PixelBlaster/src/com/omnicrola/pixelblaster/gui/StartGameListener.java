package com.omnicrola.pixelblaster.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.omnicrola.pixelblaster.main.GameStates;

public class StartGameListener implements IEventListener {

	private final StateBasedGame game;

	public StartGameListener(StateBasedGame game) {
		this.game = game;
	}

	@Override
	public void trigger() {
		final FadeOutTransition leave = new FadeOutTransition(Color.black, 250);
		final FadeInTransition enter = new FadeInTransition(Color.black, 250);
		this.game.enterState(GameStates.PLAY.ordinal(), leave, enter);
	}

}
