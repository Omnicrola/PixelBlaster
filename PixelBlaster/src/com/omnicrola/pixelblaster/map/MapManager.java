package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;
import com.omnicrola.pixelblaster.main.GameSubsystemInterlink;
import com.omnicrola.pixelblaster.main.IGameContext;
import com.omnicrola.pixelblaster.main.IGameSubsystem;

public class MapManager implements IGameSubsystem, IMapManager {

	private static final float FLOOR = 500f;

	@Override
	public void load(GameSubsystemInterlink interlink) {
		interlink.setSubsystem(IMapManager.class, this);
	}

	@Override
	public void init(IGameContext context) {
	}

	@Override
	public void update(IGameContext gameContext, float delta) {
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		graphics.setColor(Color.green);
		graphics.drawLine(0, FLOOR, 800, FLOOR);
	}

	@Override
	public float getFloorFrom(Vector2f position) {
		return FLOOR;
	}

}
