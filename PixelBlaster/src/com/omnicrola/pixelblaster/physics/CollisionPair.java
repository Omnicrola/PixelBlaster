package com.omnicrola.pixelblaster.physics;

public class CollisionPair {

	private final CollisionIdentifier id1;
	private final CollisionIdentifier id2;

	public CollisionPair(CollisionIdentifier id1, CollisionIdentifier id2) {
		this.id1 = id1;
		this.id2 = id2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		final int subHash1 = (this.id1 == null) ? 0 : this.id1.hashCode();
		final int subHash2 = (this.id2 == null) ? 0 : this.id2.hashCode();
		result = prime * result ^ subHash1 ^ subHash2;
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
		final CollisionPair other = (CollisionPair) obj;
		if (this.id1 != other.id1 && this.id1 != other.id2) {
			return false;
		}
		if (this.id2 != other.id2 && this.id2 != other.id1) {
			return false;
		}
		return true;
	}

	public CollisionIdentifier getPrimary() {
		return this.id1;
	}

}
