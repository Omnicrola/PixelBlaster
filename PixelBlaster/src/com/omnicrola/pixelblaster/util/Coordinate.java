package com.omnicrola.pixelblaster.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinate {

	@XmlAttribute(name = "x")
	private int x;
	@XmlAttribute(name = "y")
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Coordinate() {
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
