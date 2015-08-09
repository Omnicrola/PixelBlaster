package com.omnicrola.pixelblaster.util;

import java.util.ArrayList;
import java.util.Iterator;

public class ModifiableList<T> extends ArrayList<T> {
	private static final long serialVersionUID = -5196735559472224696L;
	private final ArrayList<T> iteratorList;

	public ModifiableList() {
		this.iteratorList = new ArrayList<T>();
	}

	@Override
	public Iterator<T> iterator() {
		this.iteratorList.clear();
		this.iteratorList.addAll(this);
		return this.iteratorList.iterator();
	}
}
