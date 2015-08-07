package com.omnicrola.pixelblaster.main;

public class GameSettings {

	public static boolean DEBUG = false;
	public static boolean DEBUG_PHYSICS = true;

	public static final String MAP_FILE_PATH = "assets/Levels/";
	public static final int GAME_FPS = 60;

	public static final float GRAVITY_ACCELLERATION = 0.01f;

	public static final float PLAYER_ACCELERATION = 0.01f;
	public static final float PLAYER_JUMP_SPEED = 0.4f;
	public static final float PLAYER_MAXIMUM_VELOCITY = 0.13f;

	public static final float CAMERA_SCROLL_SPEED = 5f;
	public static final float PIXEL_TO_METER_RATIO = 50.0f;
	public static final float MAP_TILE_SIZE_IN_METERS = 2.0f;

	public static final float BUBBLE_POWER_REGEN_RATE = 0.05f;
	public static final float BUBBLE_POWER_USE_RATE = 0.125f;

}
