package com.omnicrola.pixelblaster.audio;

public enum AudioMusic implements IAudioResource {
	//@formatter:off
	TITLE_IDENT("ReggaeIdent.ogg"),
	ITALIAN_MOM("ItalianMom.ogg"),
	MISHIEF_STROLL("MishiefStroll.ogg"),
	SWINGING_PANTS("SwingingPants.ogg"),
	FLOWING_ROCKS("FlowingRocks.ogg");
	//@formatter:on

	private final String filename;

	private AudioMusic(String filename) {
		this.filename = filename;
	}

	@Override
	public String getPath() {
		return "assets/audio/music/" + this.filename;
	}

}
