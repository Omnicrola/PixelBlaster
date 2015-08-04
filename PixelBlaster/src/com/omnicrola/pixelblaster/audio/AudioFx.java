package com.omnicrola.pixelblaster.audio;

public enum AudioFx implements IAudioResource {
	SPLASH("drip2.ogg");

	private final String filename;

	private AudioFx(String filename) {
		this.filename = filename;
	}

	@Override
	public String getPath() {
		return "audio/fx/" + this.filename;
	}

}
