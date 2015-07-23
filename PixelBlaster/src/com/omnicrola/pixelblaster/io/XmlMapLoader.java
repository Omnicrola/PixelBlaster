package com.omnicrola.pixelblaster.io;

import com.omnicrola.pixelblaster.map.XmlMapData;
import com.omnicrola.pixelblaster.map.XmlMapSerializer;
import com.omnicrola.xml.XmlSerializationService;

public class XmlMapLoader {

	private final XmlSerializationService xmlSerializer;

	public XmlMapLoader() {
		this.xmlSerializer = XmlMapSerializer.loadInstance();
	}

	public XmlMapData load(String filename) {
		final XmlMapData mapData = this.xmlSerializer.unmarshal(XmlMapData.class, filename);
		if (mapData == null) {
			return new XmlMapData();
		}
		return mapData;
	}

}
