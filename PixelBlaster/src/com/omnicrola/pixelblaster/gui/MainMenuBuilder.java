package com.omnicrola.pixelblaster.gui;

import java.util.ArrayList;
import java.util.List;

import com.omnicrola.pixelblaster.main.MainGameState;
import com.omnicrola.pixelblaster.main.PixelBlasterGame;

public class MainMenuBuilder {
	private final MainGameState mainState;
	private final PixelBlasterGame game;

	public MainMenuBuilder(PixelBlasterGame game, MainGameState mainState) {
		this.game = game;
		this.mainState = mainState;
	}

	public MainMenu build() {
		final List<ButtonElement> options = new ArrayList<>();
		options.add(createPlayElement());
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

	private ButtonElement createPlayElement() {
		final ButtonElement buttonElement = new ButtonElement("Play");
		buttonElement.setDimensions(200, 30);
		buttonElement.addEventListener(new StartGameListener(this.game, this.mainState));
		return buttonElement;
	}

}
