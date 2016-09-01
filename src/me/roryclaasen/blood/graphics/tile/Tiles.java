package me.roryclaasen.blood.graphics.tile;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;

import me.roryclaasen.blood.graphics.sprite.Sprite;

public class Tiles {
	private static List<Tile> tiles = new ArrayList<Tile>();

	static {
		tiles.add(new TileGround(new Sprite("textures/tiles/tileGroundWhite.png"), new Color(255, 255, 255)));
		tiles.add(new TileWall(new Sprite("textures/tiles/tileWallBlack.png"), new Color(0, 0, 0)));
	}

	public void addTile(Tile tile) {
		tiles.add(tile);
	}

	public static Tile getTile(int r, int g, int b) {
		return getTile(new Color(r, g, b));
	}

	public static Tile getTile(Color color) {
		for (Tile tile : tiles) {
			if (tile.getColor() != null) {
				if (tile.getColor().equals(color)) return tile;
			}
		}
		return null;
	}
}
