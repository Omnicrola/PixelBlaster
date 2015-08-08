package com.omnicrola.pixelblaster.map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.omnicrola.pixelblaster.entity.build.EntityType;
import com.omnicrola.pixelblaster.util.Coordinate;

@XmlAccessorType(XmlAccessType.FIELD)
public class EntityData {

	@XmlElement(name = "EntityType")
	public EntityType entityType = EntityType.BEE;

	@XmlElement(name = "Position")
	public Coordinate position = new Coordinate();

}
