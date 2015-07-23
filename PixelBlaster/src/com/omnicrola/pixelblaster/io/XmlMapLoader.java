package com.omnicrola.pixelblaster.io;

import com.omnicrola.pixelblaster.map.MapData;
import com.omnicrola.pixelblaster.map.XmlMapSerializer;
import com.omnicrola.xml.XmlSerializationService;

public class XmlMapLoader {

	private final XmlSerializationService xmlSerializer;

	public XmlMapLoader() {
		this.xmlSerializer = XmlMapSerializer.loadInstance();
	}

	public MapData load(String filename) {
		final MapData mapData = this.xmlSerializer.unmarshal(MapData.class, filename);
		if (mapData == null) {
			return new MapData();
		}
		return mapData;
	}

}
