package me.roryclaasen.blood.level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.Graphics;

import me.roryclaasen.blood.GameMaster;
import me.roryclaasen.blood.graphics.sprite.Sprite;
import me.roryclaasen.blood.graphics.tile.Tile;
import me.roryclaasen.blood.level.entity.Entity;
import me.roryclaasen.blood.level.entity.Mob;
import me.roryclaasen.blood.level.entity.Player;

public class GameLevel {
	private Player player;

	private List<Entity> entities;

	private Map base;

	private static Map current;

	private int x_off = 0;
	private int y_off = 0;

	public GameLevel() {
		entities = new ArrayList<Entity>();
		player = new Player();
	}

	public void init() {
		base = new Map("base");

		current = base;
		player.setSprite(new Sprite("textures/tiles/tileGroundWhite.png"));
	}

	public void update(int delta) {
		x_off = (int) Math.round((-(player.getPosition().x - (GameMaster.SIZE.width / 2)) - 32));
		y_off = (int) Math.round((-(player.getPosition().y - (GameMaster.SIZE.height / 2)) - 32));

		if (x_off > 0) x_off = 0;
		if (y_off > 0) y_off = 0;
		// if (x_off < width / 64) x_off = width * 64;
		// if (y_off < height / 64) y_off = height * 64;

		player.update(delta);
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			it.next().update(delta);
		}
	}

	public void render(Graphics g) {
		int px, py;
		px = (int) Math.round(player.getPosition().x / 64);
		py = (int) Math.round(player.getPosition().y / 64);
		int renderWidth = 10, renderHeight = 10;
		for (int x = px - (renderWidth / 2); x < renderWidth; x++) {
			for (int y = py - (renderHeight / 2); y < renderHeight; y++) {
				Tile tile = current.getTile(x, y);
				if (tile != null) {
					tile.getSprite().getImage().draw(x_off + x * 64, y_off + y * 64);
				}
			}
		}
		// TODO Only render the entities that are on the screen
		player.render(x_off, y_off, g);
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			Entity entity = it.next();
			if (entity instanceof Mob) {
				((Mob) entity).render(x_off, y_off, g);
			}
		}
	}

	public static Map getCurrentMap() {
		return current;
	}
}
