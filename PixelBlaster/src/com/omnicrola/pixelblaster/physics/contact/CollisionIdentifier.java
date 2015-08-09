package com.omnicrola.pixelblaster.physics.contact;

public class CollisionIdentifier {
	// NONE, PLAYER_BODY, BUBBLE, MAP_TILE, SENSOR, POWERUP, PLAYER_FOOT;
	public static final CollisionIdentifier NONE = new CollisionIdentifier(1);
	public static final CollisionIdentifier PLAYER_BODY = new CollisionIdentifier(2);
	public static final CollisionIdentifier BUBBLE = new CollisionIdentifier(3);
	public static final CollisionIdentifier MAP_TILE = new CollisionIdentifier(4);
	public static final CollisionIdentifier PLAYER_FOOT = new CollisionIdentifier(5);

	private static int nextId = 100;

	private final int id;

	public CollisionIdentifier() {
		this(nextId++);
	}

	private CollisionIdentifier(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ID=" + this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 97;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final CollisionIdentifier other = (CollisionIdentifier) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

}
