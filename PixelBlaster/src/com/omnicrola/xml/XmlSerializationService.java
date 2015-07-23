package com.omnicrola.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlSerializationService {

	private final JAXBContext jaxbContext;

	public XmlSerializationService(JAXBContext jaxbContext) {
		this.jaxbContext = jaxbContext;
	}

	@SuppressWarnings("unchecked")
	public <T> T unmarshal(Class<T> returnClass, String filename) {
		try {
			final Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
			return (T) unmarshaller.unmarshal(new File(filename));
		} catch (final JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void write(String filename, Object data) {
		try {
			final Marshaller marshaller = this.jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(data, new File(filename));
		} catch (final JAXBException e) {
			e.printStackTrace();
		}
	}

}
