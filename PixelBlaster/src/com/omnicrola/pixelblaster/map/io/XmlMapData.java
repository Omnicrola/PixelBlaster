package com.omnicrola.pixelblaster.map.io;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.omnicrola.pixelblaster.map.EntityData;
import com.omnicrola.pixelblaster.map.MapBounds;
import com.omnicrola.pixelblaster.util.Coordinate;

@XmlRootElement(name = "Map")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlMapData {

	@XmlElement(name = "Title")
	public String title = "Level1";

	@XmlElement(name = "SubTitle")
	public String subtitle = "the beginning";

	@XmlElement(name = "TilesetName")
	public String tilesetName = "Planet";

	@XmlElement(name = "Background")
	public String background = "blue_desert.png";

	@XmlElementWrapper
	@XmlElement(name = "MapTile")
	public List<XmlMapTileData> mapTiles = new ArrayList<>();

	public int mapWidth = 1;
	public int mapHeight = 1;

	@XmlElement(name = "MapBounds")
	public MapBounds mapBounds = new MapBounds(0, 0, 1, 1);

	@XmlElement(name = "playerSpawn")
	public Coordinate playerSpawn;

	@XmlElementWrapper
	@XmlElement(name = "powerups")
	public List<PowerupData> powerups = new ArrayList<>();

	@XmlElementWrapper
	@XmlElement(name = "entities")
	public List<EntityData> entities = new ArrayList<>();

}
