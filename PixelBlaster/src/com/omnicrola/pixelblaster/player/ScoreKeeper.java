package com.omnicrola.pixelblaster.player;

import com.omnicrola.pixelblaster.main.GameSettings;

public class ScoreKeeper {
	private float elapsed;
	private final float decrementThreshold;

	public ScoreKeeper(float pointsPerSecond) {
		this.decrementThreshold = GameSettings.GAME_FPS / pointsPerSecond;
		this.elapsed = 0;
	}

	public int updateScore(int score, float delta) {
		this.elapsed += delta;
		if (this.elapsed >= this.decrementThreshold) {
			this.elapsed = 0;
			return --score;
		}
		return score;
	}

}
