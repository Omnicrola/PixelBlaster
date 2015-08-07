package com.omnicrola.pixelblaster.map;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.omnicrola.pixelblaster.util.Coordinate;

@XmlRootElement(name = "Map")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlMapData {

	@XmlElement(name = "Title")
	String title = "Level1";

	@XmlElement(name = "SubTitle")
	String subtitle = "the beginning";

	@XmlElement(name = "TilesetName")
	String tilesetName = "Planet";

	@XmlElement(name = "Background")
	String background = "blue_desert.png";

	@XmlElementWrapper
	@XmlElement(name = "MapTile")
	List<XmlMapTileData> mapTiles = new ArrayList<>();

	int mapWidth = 1;
	int mapHeight = 1;

	@XmlElement(name = "MapBounds")
	MapBounds mapBounds = new MapBounds(0, 0, 1, 1);

	@XmlElement(name = "playerSpawn")
	public Coordinate playerSpawn;

	@XmlElementWrapper
	@XmlElement(name = "powerups")
	public List<PowerupData> powerups = new ArrayList<>();

}
