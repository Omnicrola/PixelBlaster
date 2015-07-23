package com.omnicrola.pixelblaster.map;

import com.omnicrola.xml.XmlSerializationService;

public class XmlMapWriter {

	private final XmlSerializationService serializer;

	public XmlMapWriter() {
		this.serializer = XmlMapSerializer.loadInstance();
	}

	public void write(String filename, XmlMapData mapData) {
		this.serializer.write(filename, mapData);
	}

}
