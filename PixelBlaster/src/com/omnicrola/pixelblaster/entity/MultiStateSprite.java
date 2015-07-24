package com.omnicrola.pixelblaster.entity;

import java.util.HashSet;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.omnicrola.pixelblaster.graphics.IGraphicsWrapper;

public class MultiStateSprite extends EntitySprite {
	public static enum State {
		HIT, JUMP, DUCK, WALK, STAND;
	}

	public static enum Facing {
		LEFT, RIGHT;
	}

	public static final int STAND = 0;
	public static final int FRONT = 1;
	public static final int WALK1 = 2;
	public static final int WALK2 = 3;
	public static final int SWIM1 = 4;
	public static final int SWIM2 = 5;
	public static final int JUMP = 6;
	public static final int HIT = 7;
	public static final int DUCK = 8;
	public static final int CLIMB1 = 9;
	public static final int CLIMB2 = 10;

	private final Image[] images;
	private State currentState;
	private float currentFrameCount;
	private float lastFrameChange;
	private int currentFrameIndex;
	private boolean flippedX;
	private final HashSet<State> states;

	public MultiStateSprite(Image[] images, Rectangle bounds) {
		super(images[0], bounds);
		assert(images.length == 11);
		this.images = images;
		this.currentFrameIndex = 0;
		this.flippedX = false;
		this.states = new HashSet<>();
		this.currentState = State.STAND;
		this.states.add(State.STAND);
	}

	public void setState(State state) {
		this.states.add(state);
		updateState();
	}

	public void removeState(State state) {
		this.states.remove(state);
		updateState();
	}

	private void updateState() {
		this.currentState = State.STAND;
		for (final State state : this.states) {
			if (state.ordinal() < this.currentState.ordinal()) {
				this.currentState = state;
			}
		}
	}

	@Override
	public void render(IGraphicsWrapper graphics) {
		graphics.drawImage(this.image.getFlippedCopy(this.flippedX, false), this.bounds);
	}

	@Override
	public void update(float delta) {
		this.currentFrameCount += delta;
		switch (this.currentState) {
		case STAND:
			setImage(STAND);
			break;
		case WALK:
			animateWalk(delta);
			break;
		case JUMP:
			setImage(JUMP);
			break;
		case HIT:
			setImage(HIT);
			break;
		case DUCK:
			setImage(DUCK);
			break;
		default:
			break;
		}
	}

	public void setFacing(Facing facing) {
		this.flippedX = facing.equals(Facing.LEFT) ? true : false;
	}

	private void animateWalk(float delta) {
		final float elapsed = this.currentFrameCount - this.lastFrameChange;
		if (elapsed >= 5.0f) {
			final int newFrame = (this.currentFrameIndex == WALK1) ? WALK2 : WALK1;
			setImage(newFrame);
		}
	}

	private void setImage(int imageIndex) {
		this.image = this.images[imageIndex];
		this.currentFrameIndex = imageIndex;
		this.lastFrameChange = this.currentFrameCount;
	}

}
