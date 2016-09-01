package me.roryclaasen.blood.graphics.tile;

import org.newdawn.slick.Color;

import com.sun.istack.internal.NotNull;

import me.roryclaasen.blood.graphics.sprite.Sprite;

public class Tile {
	private Sprite sprite;
	private Color color;

	public Tile(@NotNull Sprite sprite) {
		this(sprite, null);
	}

	public Tile(@NotNull Sprite sprite, Color color) {
		this.sprite = sprite;
		this.color = color;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public Color getColor() {
		return color;
	}

	public boolean isSolid() {
		return false;
	}
}
