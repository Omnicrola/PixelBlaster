package com.omnicrola.pixelblaster.map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmlMapTileData {
	public XmlMapTileData() {
	}

	public XmlMapTileData(int x, int y, int tileIndex) {
		this.x = x;
		this.y = y;
		this.tileIndex = tileIndex;
	}

	@XmlAttribute(name = "x")
	int x = 0;
	@XmlAttribute(name = "y")
	int y = 0;
	@XmlAttribute(name = "index")
	int tileIndex = 0;
}
