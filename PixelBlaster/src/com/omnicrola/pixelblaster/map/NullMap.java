package com.omnicrola.pixelblaster.map;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class NullMap implements ILevelMap {
	public static final NullMap NULL = new NullMap();

	private NullMap() {
	}

	@Override
	public void render(IGraphicsWrapper graphics) {

	}

	@Override
	public Vector2f getPlayerSpawn() {
		return new Vector2f();
	}

	@Override
	public MapBounds getMapBounds() {
		return new MapBounds(0, 0, 1, 1);
	}

	@Override
	public void load() {

	}

	@Override
	public String getTitle() {
		return "";
	}

	@Override
	public String getSubtitle() {
		return "";
	}

}
