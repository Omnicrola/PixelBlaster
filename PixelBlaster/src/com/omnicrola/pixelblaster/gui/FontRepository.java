package com.omnicrola.pixelblaster.gui;

import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.Font;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class FontRepository {

	public static Font get(FontResource fontResource, int size) {
		final FontType type = fontResource.getType();
		switch (type) {
		case TRUE_TYPE:
			return new TrueTypeFont(javaFont(fontResource, size), true);
		default:
			return new TrueTypeFont(javaFont(fontResource, 50), true);

		}
	}

	public static java.awt.Font javaFont(FontResource fontResource, int size) {
		try {
			final InputStream fontStream = ResourceLoader
					.getResourceAsStream("assets/fonts/" + fontResource.getFilename());
			return java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, fontStream).deriveFont(java.awt.Font.PLAIN,
					size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return javaFont("Helvetica", size);
	}

	private static java.awt.Font javaFont(String fontName, int size) {
		return new java.awt.Font(fontName, java.awt.Font.PLAIN, size);
	}

}
