package com.omnicrola.pixelblaster.util;

public class Timekeeper {
	private long lapStart;

	public Timekeeper() {
		this.lapStart = System.nanoTime();
	}

	public float lap() {
		final long newStartTime = System.nanoTime();
		final float elapsed = (newStartTime - this.lapStart) / 1_000_000f;
		this.lapStart = newStartTime;
		return elapsed;
	}

	public void printLap(String message) {
		final float elapsed = lap();
		System.out.println("(" + elapsed + ") " + message);
	}
}
