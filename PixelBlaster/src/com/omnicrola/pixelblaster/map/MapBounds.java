package com.omnicrola.pixelblaster.map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.newdawn.slick.geom.Vector2f;

import com.omnicrola.pixelblaster.entity.IGameEntity;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapBounds {

	@XmlAttribute
	private int minX;
	@XmlAttribute
	private int minY;
	@XmlAttribute
	private int maxX;
	@XmlAttribute
	private int maxY;

	@XmlTransient
	private float tileSize;

	public MapBounds(int minX, int minY, int maxX, int maxY) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.tileSize = 1.0f;
	}

	public MapBounds() {
	}

	public void setTileSize(float tileSize) {
		this.tileSize = tileSize;
	}

	public int getMaxX() {
		return this.maxX;
	}

	public int getMaxY() {
		return this.maxY;
	}

	public int getMinX() {
		return this.minX;
	}

	public int getMinY() {
		return this.minY;
	}

	public void containEntity(IGameEntity entity) {
		final Vector2f position = entity.getPosition();
		if (position.x < worldScale(getMinX())) {
			position.x = worldScale(getMinX());
		}
		if (position.x > worldScale(getMaxX())) {
			position.x = worldScale(getMaxX());
		}
		if (position.y < worldScale(getMinY())) {
			position.y = worldScale(getMinY());
		}
		if (position.y > worldScale(getMaxY())) {
			position.y = worldScale(getMaxY());
		}
		entity.setPosition(position);
	}

	private float worldScale(float value) {
		return value * this.tileSize;
	}

}
