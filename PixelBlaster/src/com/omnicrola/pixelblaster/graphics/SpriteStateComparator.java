package com.omnicrola.pixelblaster.graphics;

import java.util.Comparator;

public class SpriteStateComparator implements Comparator<ISpriteState> {

	@Override
	public int compare(ISpriteState first, ISpriteState second) {
		return second.priority() - first.priority();
	}

}
