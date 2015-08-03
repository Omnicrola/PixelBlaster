package com.omnicrola.pixelblaster.map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.omnicrola.pixelblaster.physics.CollisionIdentifier;

@XmlAccessorType(XmlAccessType.FIELD)
public class PowerupData {

	CollisionIdentifier powerupId;
	String image = "";
	float width;
	float height;
	public float x;
	public float y;

}
