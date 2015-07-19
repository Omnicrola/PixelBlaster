package com.omnicrola.pixelblaster.gui;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.state.StateBasedGame;

public class MainMenuBuilder {

	public MainMenu build(StateBasedGame game) {
		final List<ButtonElement> options = new ArrayList<>();
		options.add(createPlayElement(game));
		options.add(createQuitElement());
		final MainMenu mainMenu = new MainMenu(options);
		mainMenu.setPosition(100, 100);
		return mainMenu;
	}

	private ButtonElement createQuitElement() {
		final ButtonElement buttonElement = new ButtonElement("Quit");
		buttonElement.setPosition(0, 35);
		buttonElement.setDimensions(200, 30);
		buttonElement.addEventListener(new QuitListener());
		return buttonElement;
	}

	private ButtonElement createPlayElement(StateBasedGame game) {
		final ButtonElement buttonElement = new ButtonElement("Play");
		buttonElement.setDimensions(200, 30);
		buttonElement.addEventListener(new StartGameListener(game));
		return buttonElement;
	}

}
