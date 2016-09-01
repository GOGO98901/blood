package me.roryclaasen.blood.graphics.tile;

import org.newdawn.slick.Color;

import com.sun.istack.internal.NotNull;

import me.roryclaasen.blood.graphics.sprite.Sprite;

public class TileWall extends Tile {

	public TileWall(@NotNull Sprite sprite, Color color) {
		super(sprite, color);
	}

	@Override
	public boolean isSolid() {
		return true;
	}
}
