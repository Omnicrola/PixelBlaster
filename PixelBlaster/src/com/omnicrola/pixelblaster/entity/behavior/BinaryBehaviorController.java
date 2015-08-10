package com.omnicrola.pixelblaster.entity.behavior;

import java.util.ArrayList;

import com.omnicrola.pixelblaster.entity.IGameEntity;
import com.omnicrola.pixelblaster.entity.IUpdateBehavior;

public class BinaryBehaviorController implements IUpdateBehavior {
	private final ArrayList<IUpdateBehavior> primaryBehaviors;
	private final ArrayList<IUpdateBehavior> alternateBehaviors;
	private boolean isUsingPrimary;

	public BinaryBehaviorController() {
		this.primaryBehaviors = new ArrayList<>();
		this.alternateBehaviors = new ArrayList<>();
		this.isUsingPrimary = true;
	}

	public void addPrimaryBehavior(IUpdateBehavior behavior) {
		this.primaryBehaviors.add(behavior);
	}

	public void addAlternateBehavior(IUpdateBehavior behavior) {
		this.alternateBehaviors.add(behavior);
	}

	public void usePrimaryBehaviors() {
		System.out.println("use primary");
		this.isUsingPrimary = true;
	}

	public void useAlternateBehaviors() {
		System.out.println("use secondary");
		this.isUsingPrimary = false;
	}

	@Override
	public void update(IGameEntity entity, float delta) {
		if (this.isUsingPrimary) {
			behave(this.primaryBehaviors, entity, delta);
		} else {
			behave(this.alternateBehaviors, entity, delta);
		}
	}

	private void behave(ArrayList<IUpdateBehavior> behaviors, IGameEntity entity, float delta) {
		for (final IUpdateBehavior behavior : behaviors) {
			behavior.update(entity, delta);
		}
	}

}
