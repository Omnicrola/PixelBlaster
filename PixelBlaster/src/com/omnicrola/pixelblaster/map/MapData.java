package com.omnicrola.pixelblaster.map;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Map")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapData {

	@XmlElement(name = "TilesetName")
	String tilesetName = "Planet";

	@XmlElement(name = "Background")
	String background = "blue_desert.png";

	@XmlElementWrapper
	@XmlElement(name = "MapTile")
	List<MapTileData> mapTiles = new ArrayList<>();

}
