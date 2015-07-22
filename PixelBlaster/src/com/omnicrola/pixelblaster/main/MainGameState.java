package com.omnicrola.pixelblaster.main;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.omnicrola.pixelblaster.graphics.Camera;
import com.omnicrola.pixelblaster.graphics.SlickGraphicsWrapper;
import com.omnicrola.pixelblaster.util.AssetManager;

public class MainGameState extends BasicGameState {
	private final ArrayList<IGameSubsystem> subsystems;
	private boolean isInitialized = false;
	private final GameSubsystemInterlink interlink;
	private AssetManager assetManager;
	private SlickGameContext gameContext;
	private Camera camera;

	public MainGameState() {
		this.subsystems = new ArrayList<>();
		this.interlink = new GameSubsystemInterlink();
	}

	public void addSubsystem(IGameSubsystem subsystem) {
		this.subsystems.add(subsystem);
		subsystem.load(this.interlink);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		if (!this.isInitialized) {
			this.assetManager = new AssetManager();
			this.camera = new Camera(GameSettings.PIXEL_TO_METER_RATIO, container.getWidth(), container.getHeight());
			this.gameContext = new SlickGameContext(this.interlink, container, this.assetManager, this.camera);
			for (final IGameSubsystem subsystem : this.subsystems) {
				subsystem.init(this.gameContext);
			}
			this.isInitialized = true;
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException {
		for (final IGameSubsystem gameSubsystem : this.subsystems) {
			gameSubsystem.render(new SlickGraphicsWrapper(this.camera, graphics));
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		final float fractionOfSixtyFps = delta / (1000f / 60f);
		for (final IGameSubsystem subsystem : this.subsystems) {
			subsystem.update(this.gameContext, fractionOfSixtyFps);
		}
	}

	@Override
	public int getID() {
		return GameStates.PLAY.ordinal();
	}
}
