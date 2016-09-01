package me.roryclaasen.blood.level;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import me.roryclaasen.blood.graphics.sprite.Sprite;
import me.roryclaasen.blood.graphics.tile.Tile;
import me.roryclaasen.blood.graphics.tile.Tiles;

public class Map {
	private String path;
	private Sprite imageMap;

	private Color[] dataMap;

	private int width, height;

	public Map(String folder) {
		path = "levels/" + folder;
		loadLevel();
	}

	private void loadLevel() {
		imageMap = new Sprite(path + "/level.png");
		if (!imageMap.hasFailed()) {
			Image data = imageMap.getImage();
			width = data.getWidth();
			height = data.getHeight();
			dataMap = new Color[width * height];
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					dataMap[x + y * width] = data.getColor(x, y);
				}
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x + y * width < 0 || x + y * width >= dataMap.length) return Tiles.tileNull;
		return Tiles.getTile(dataMap[x + y * width]);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
