package com.omnicrola.pixelblaster.map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.omnicrola.xml.XmlSerializationService;

public class XmlMapSerializer {
	public static XmlSerializationService loadInstance() {
		try {
			return new XmlSerializationService(JAXBContext.newInstance(MapData.class, MapTileData.class));
		} catch (final JAXBException e) {
		}
		return null;
	}

}
