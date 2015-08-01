package com.omnicrola.pixelblaster.main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.omnicrola.pixelblaster.entity.EntityManager;
import com.omnicrola.pixelblaster.gui.MainMenuBuilder;
import com.omnicrola.pixelblaster.input.ShowMenuHandler;
import com.omnicrola.pixelblaster.map.MapManager;
import com.omnicrola.pixelblaster.particles.ParticleManager;
import com.omnicrola.pixelblaster.physics.PhysicsManager;
import com.omnicrola.pixelblaster.player.PlayerManager;

public class PixelBlasterGame extends StateBasedGame {

	public PixelBlasterGame() {
		super("Pixel Blaster");
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
		mainGameState.addSubsystem(new MapManager());
		mainGameState.addSubsystem(new EntityManager());
		mainGameState.addSubsystem(new ParticleManager());
		mainGameState.addSubsystem(new PlayerManager());
		mainGameState.addSubsystem(new ShowMenuHandler(this));
		mainGameState.addSubsystem(new PhysicsManager());
		addState(mainGameState);
	}

}
