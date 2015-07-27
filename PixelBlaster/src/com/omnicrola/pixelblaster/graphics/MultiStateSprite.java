package com.omnicrola.pixelblaster.graphics;

import java.util.HashSet;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.graphics.EntitySprite.Facing;

public class MultiStateSprite implements IEntitySprite {

	private final HashSet<ISpriteState> states;
	private final Map<ISpriteState, IEntitySprite> animatedSprites;
	private IEntitySprite currentSprite;
	private final ISpriteState defaultState;
	private Facing facing;
	private float transparency;

	public MultiStateSprite(Map<ISpriteState, IEntitySprite> sprites, Rectangle bounds, ISpriteState defaultState) {
		this.animatedSprites = sprites;
		this.defaultState = defaultState;
		this.states = new HashSet<>();
		this.facing = Facing.RIGHT;
		this.currentSprite = sprites.values().iterator().next();
		this.transparency = 1f;
	}

	public void setState(ISpriteState state) {
		this.states.clear();
		this.states.add(state);
		updateState();
	}

	public void addState(ISpriteState state) {
		this.states.add(state);
		updateState();
	}

	public void removeState(ISpriteState state) {
		this.states.remove(state);
		updateState();
	}

	@Override
	public void update(float delta) {
		this.currentSprite.setFacing(this.facing);
		this.currentSprite.setTransparency(this.transparency);
		this.currentSprite.update(delta);
	}

	@Override
	public IEntitySprite setPosition(Vector2f position) {
		return this.currentSprite.setPosition(position);
	}

	@Override
	public IEntitySprite setRotation(float rotation) {
		return this.currentSprite.setRotation(rotation);
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		this.currentSprite.render(graphics);
	}

	@Override
	public void setFacing(Facing facing) {
		this.facing = facing;
	}

	@Override
	public Image getImage() {
		return this.currentSprite.getImage();
	}

	@Override
	public float getX() {
		return this.currentSprite.getX();
	}

	@Override
	public float getY() {
		return this.currentSprite.getY();
	}

	@Override
	public Rectangle getBounds() {
		return this.currentSprite.getBounds();
	}

	@Override
	public float getRotation() {
		return this.currentSprite.getRotation();
	}

	@Override
	public void setTransparency(float value) {
		this.transparency = value;
	}

	private void updateState() {
		ISpriteState newState = this.defaultState;
		if (this.states.isEmpty()) {
			this.states.add(this.defaultState);
		} else {
			for (final ISpriteState state : this.states) {
				if (state.priority() < newState.priority()) {
					newState = state;
				}
			}
		}
		this.currentSprite = this.animatedSprites.get(newState);
	}

	public void clearStates() {
		this.states.clear();
	}
}
