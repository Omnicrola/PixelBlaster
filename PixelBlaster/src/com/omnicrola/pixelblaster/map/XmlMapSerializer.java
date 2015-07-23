package com.omnicrola.pixelblaster.map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.omnicrola.xml.XmlSerializationService;

public class XmlMapSerializer {
	public static XmlSerializationService loadInstance() {
		try {
			return new XmlSerializationService(JAXBContext.newInstance(XmlMapData.class, XmlMapTileData.class));
		} catch (final JAXBException e) {
		}
		return null;
	}

}
