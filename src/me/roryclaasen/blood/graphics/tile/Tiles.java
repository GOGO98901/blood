package me.roryclaasen.blood.graphics.tile;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;

import me.roryclaasen.blood.graphics.sprite.Sprite;
import me.roryclaasen.blood.graphics.sprite.Spritesheet;

public class Tiles {
	public static final Tile tileNull;
	private static List<Tile> tiles = new ArrayList<Tile>();

	static {
		tileNull = new Tile(new Sprite("textures/null.png"));
		
		tiles.add(new TileGround(new Sprite("textures/tiles/tileGroundWhite.png"), new Color(255, 255, 255)));
		tiles.add(new TileWall(new Sprite("textures/tiles/tileWallBlack.png"), new Color(0, 0, 0)));
		
		Spritesheet wallsBlack = new Spritesheet("textures/tiles/tilesetWallBlack.png");
		tiles.add(new TileWall(wallsBlack.getSprite(0, 0), new Color(10, 10, 10)));
		tiles.add(new TileWall(wallsBlack.getSprite(64, 0), new Color(20, 20, 20)));
		tiles.add(new TileWall(wallsBlack.getSprite(64, 64), new Color(30, 30, 30)));
		tiles.add(new TileWall(wallsBlack.getSprite(0, 64), new Color(40, 40, 40)));

		tiles.add(new TileWall(wallsBlack.getSprite(128, 0), new Color(50, 50, 50)));
		tiles.add(new TileWall(wallsBlack.getSprite(128, 64), new Color(60, 60, 60)));
		tiles.add(new TileWall(wallsBlack.getSprite(192, 64), new Color(70, 70, 70)));
		tiles.add(new TileWall(wallsBlack.getSprite(192, 0), new Color(80, 80, 80)));
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
		return tileNull;
	}
}
