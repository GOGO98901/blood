package me.roryclaasen.blood.level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.Graphics;

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
		player.update(delta);
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			it.next().update(delta);
		}
	}

	public void render(Graphics g) {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				Tile tile = current.getTile(x, y);
				if (tile != null) {
					tile.getSprite().getImage().draw(x * 64, y * 64);
				}
			}
		}
		// TODO Only render the entities that are on the screen
		player.render(g);
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			Entity entity = it.next();
			if (entity instanceof Mob) {
				((Mob) entity).render(g);
			}
		}
	}

	public static Map getCurrentMap() {
		return current;
	}
}
