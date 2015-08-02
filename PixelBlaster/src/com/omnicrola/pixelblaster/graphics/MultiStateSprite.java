package com.omnicrola.pixelblaster.graphics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;

public class MultiStateSprite implements IEntitySprite {

	private final TreeSet<ISpriteState> states;
	private final Map<ISpriteState, IEntitySprite> animatedSprites;
	private final ISpriteState defaultState;
	private Facing facing;
	private final HashSet<IEntitySprite> activeSprites;

	public MultiStateSprite(Map<ISpriteState, IEntitySprite> sprites, Rectangle bounds, ISpriteState defaultState) {
		this.animatedSprites = sprites;
		this.defaultState = defaultState;
		this.states = new TreeSet<>(new SpriteStateComparator());
		this.activeSprites = new HashSet<>();
		this.facing = Facing.RIGHT;
		updateState();
	}

	public void addState(ISpriteState newState) {
		removeAllStatesInGroup(newState.group());
		this.states.add(newState);
		updateState();
	}

	private void removeAllStatesInGroup(int groupId) {
		final Iterator<ISpriteState> iterator = this.states.iterator();
		while (iterator.hasNext()) {
			if (groupId == iterator.next().group()) {
				iterator.remove();
			}
		}
	}

	public void removeState(ISpriteState state) {
		this.states.remove(state);
		updateState();
	}

	@Override
	public void update(float delta) {
		for (final IEntitySprite sprite : this.activeSprites) {
			sprite.setFacing(this.facing);
			sprite.update(delta);
		}
	}

	@Override
	public void setPosition(Vector2f position) {
		for (final IEntitySprite sprite : this.activeSprites) {
			sprite.setPosition(position);
		}
	}

	@Override
	public void setRotation(float rotation) {
		for (final IEntitySprite sprite : this.activeSprites) {
			sprite.setRotation(rotation);
		}
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		for (final IEntitySprite sprite : this.activeSprites) {
			sprite.render(graphics);
		}
	}

	@Override
	public void setFacing(Facing facing) {
		this.facing = facing;
	}

	@Override
	public Rectangle getBounds() {
		final Rectangle bounds = new Rectangle(0, 0, 0, 0);
		for (final IEntitySprite sprite : this.activeSprites) {
			combine(bounds, sprite.getBounds());
		}
		return bounds;
	}

	private void combine(Rectangle bounds, Rectangle r2) {
		final float x1 = Math.min(bounds.getMinX(), r2.getMinX());
		final float y1 = Math.min(bounds.getMinY(), r2.getMinY());
		final float x2 = Math.max(bounds.getMaxX(), r2.getMaxX());
		final float y2 = Math.max(bounds.getMaxY(), r2.getMaxY());
		final float width = x2 - x1;
		final float height = y2 - y1;
		bounds.setX(x1);
		bounds.setY(y1);
		bounds.setWidth(width);
		bounds.setHeight(height);
	}

	@Override
	public void setTransparency(float value) {
	}

	private void updateState() {
		this.activeSprites.clear();
		if (this.states.isEmpty()) {
			this.states.add(this.defaultState);
		} else {
			for (final ISpriteState iSpriteState : this.states) {
				this.activeSprites.add(this.animatedSprites.get(iSpriteState));
			}
		}
	}

}
