package com.omnicrola.pixelblaster.gui;

public enum FontResource {
	KEN_VECTOR_FUTURE_THIN(FontType.TRUE_TYPE, "KenVectorFutureThin.ttf");

	private final FontType type;
	private final String filename;

	private FontResource(FontType type, String filename) {
		this.type = type;
		this.filename = filename;
	}

	public FontType getType() {
		return this.type;
	}

	public String getFilename() {
		return this.filename;
	}

}
