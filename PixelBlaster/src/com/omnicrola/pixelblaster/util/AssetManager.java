package com.omnicrola.pixelblaster.util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AssetManager {

	public Image getImage(String string) {
		try {
			return new Image(string);
		} catch (final SlickException e) {
			e.printStackTrace();
		}
		return null;
	}

}
