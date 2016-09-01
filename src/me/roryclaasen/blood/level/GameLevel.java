package me.roryclaasen.blood.level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.Graphics;

import me.roryclaasen.blood.level.entity.Entity;
import me.roryclaasen.blood.level.entity.Mob;
import me.roryclaasen.blood.level.entity.Player;

public class GameLevel {
	private Player player;

	private List<Entity> entities;

	public GameLevel() {
		entities = new ArrayList<Entity>();
		player = new Player();
	}

	public void update(int delta) {
		player.update(delta);
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			it.next().update(delta);
		}
	}

	public void render(Graphics g) {
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
}
