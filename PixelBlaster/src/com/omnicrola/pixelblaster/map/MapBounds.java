package com.omnicrola.pixelblaster.map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapBounds {

	@XmlAttribute
	private int minX;
	@XmlAttribute
	private int minY;
	@XmlAttribute
	private int maxX;
	@XmlAttribute
	private int maxY;

	public MapBounds(int minX, int minY, int maxX, int maxY) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public MapBounds() {
	}

	public int getMaxX() {
		return this.maxX;
	}

	public int getMaxY() {
		return this.maxY;
	}

	public int getMinX() {
		return this.minX;
	}

	public int getMinY() {
		return this.minY;
	}

}
