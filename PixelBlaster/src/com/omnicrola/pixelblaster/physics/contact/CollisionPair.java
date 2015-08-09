package com.omnicrola.pixelblaster.physics.contact;

public class CollisionPair {

	private final CollisionIdentifier id1;
	private final CollisionIdentifier id2;

	public CollisionPair(CollisionIdentifier id1, CollisionIdentifier id2) {
		this.id1 = id1;
		this.id2 = id2;
	}

	public CollisionIdentifier getPrimary() {
		return this.id1;
	}

	@Override
	public String toString() {
		return "CollisionPair (" + this.id1 + ", " + this.id2 + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		final int subHash1 = (this.id1 == null) ? 0 : this.id1.hashCode();
		final int subHash2 = (this.id2 == null) ? 0 : this.id2.hashCode();
		result = prime * result ^ (subHash1 * subHash2);
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
		final boolean id1DoesNotMatch = !this.id1.equals(other.id1);
		final boolean id2DoesNotMatch = !this.id2.equals(other.id2);
		if (id1DoesNotMatch && !this.id1.equals(other.id2)) {
			return false;
		}
		if (id2DoesNotMatch && !this.id2.equals(other.id1)) {
			return false;
		}
		if (this.id1.equals(this.id2) && (id1DoesNotMatch || id2DoesNotMatch)) {
			return false;
		}
		return true;
	}

}
