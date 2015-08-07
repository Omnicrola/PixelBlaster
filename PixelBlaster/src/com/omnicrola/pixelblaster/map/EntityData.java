package com.omnicrola.pixelblaster.map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.omnicrola.pixelblaster.util.Coordinate;

@XmlAccessorType(XmlAccessType.FIELD)
public class EntityData {

	@XmlElement(name = "ImageSet")
	public String imageSet = "bee";

	@XmlAttribute(name = "HP")
	public int hp = 1;

	@XmlElement(name = "Position")
	public Coordinate position = new Coordinate();

	public float width = 10;

	public float height = 10;

}
