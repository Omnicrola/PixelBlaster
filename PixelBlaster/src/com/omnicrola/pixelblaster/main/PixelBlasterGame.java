package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.omnicrola.pixelblaster.audio.AudioLibraryLoader;
import com.omnicrola.pixelblaster.audio.AudioManager;
import com.omnicrola.pixelblaster.entity.EntityManager;
import com.omnicrola.pixelblaster.gui.GuiControllerBuilder;
import com.omnicrola.pixelblaster.gui.MainMenuBuilder;
import com.omnicrola.pixelblaster.gui.UiManager;
import com.omnicrola.pixelblaster.gui.UserInterfaceBuilder;
import com.omnicrola.pixelblaster.input.InputManager;
import com.omnicrola.pixelblaster.map.MapManager;
import com.omnicrola.pixelblaster.map.io.MapTemplateReaderBuilder;
import com.omnicrola.pixelblaster.particles.ParticleManager;
import com.omnicrola.pixelblaster.physics.PhysicsManager;
import com.omnicrola.pixelblaster.player.PlayerManager;

public class PixelBlasterGame extends StateBasedGame {

	public PixelBlasterGame() {
		super("Space Plus");
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		createMainGameState();
		createMainMenuState();
		enterState(GameStates.MAIN_MENU.ordinal());
	}

	private void createMainMenuState() {
		final MenuState menuState = new MenuState(new MainMenuBuilder());
		addState(menuState);
	}

	private void createMainGameState() {
		final MainGameState mainGameState = new MainGameState();
		mainGameState.addSubsystem(new AudioManager(new AudioLibraryLoader()));
		mainGameState.addSubsystem(new MapManager(new MapTemplateReaderBuilder()));
		mainGameState.addSubsystem(new EntityManager());
		mainGameState.addSubsystem(new ParticleManager());
		mainGameState.addSubsystem(new PlayerManager());
		mainGameState.addSubsystem(new InputManager(this));
		mainGameState.addSubsystem(new PhysicsManager());

		final UiManager subsystem = buildGuiManager();
		mainGameState.addSubsystem(subsystem);
		addState(mainGameState);
	}

	private UiManager buildGuiManager() {
		return new UiManager(new UserInterfaceBuilder(), new GuiControllerBuilder());
	}

}
