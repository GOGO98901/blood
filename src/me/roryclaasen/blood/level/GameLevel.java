package me.roryclaasen.blood.level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

import me.roryclaasen.blood.GameMaster;
import me.roryclaasen.blood.graphics.sprite.Sprite;
import me.roryclaasen.blood.graphics.tile.Tile;
import me.roryclaasen.blood.level.entity.Blood;
import me.roryclaasen.blood.level.entity.Enemy;
import me.roryclaasen.blood.level.entity.Entity;
import me.roryclaasen.blood.level.entity.Mob;
import me.roryclaasen.blood.level.entity.Player;
import me.roryclaasen.blood.level.entity.Projectile;

public class GameLevel {
	private Random random = new Random();
	private Player player;

	private List<Entity> entities;
	private List<Enemy> enemies;
	private List<Projectile> projectiles;

	private Map base;

	private static Map current;

	private int x_off = 0;
	private int y_off = 0;

	private WaveSystem waves;

	public GameLevel() {
		entities = new ArrayList<Entity>();
		enemies = new ArrayList<Enemy>();
		projectiles = new ArrayList<Projectile>();
		waves = new WaveSystem(this);
	}

	public void init() {
		base = new Map("base");

		current = base;
		player = new Player();
		player.setSprite(new Sprite("textures/entities/player.png"));
		waves.start();
	}

	public void update(int delta) {
		waves.update(delta);
		x_off = (int) Math.round((-(player.getPosition().x - (GameMaster.SIZE.width / 2)) - 32)) - 16;
		y_off = (int) Math.round((-(player.getPosition().y - (GameMaster.SIZE.height / 2)) - 32)) - 16;

		if (x_off > 0) x_off = 0;
		if (y_off > 0) y_off = 0;
		int x_offTest = -((current.getWidth() * 64) - GameMaster.SIZE.width);
		int y_offTest = -((current.getHeight() * 64) - GameMaster.SIZE.height);
		if (x_off < x_offTest) x_off = x_offTest;
		if (y_off < y_offTest) y_off = y_offTest;

		player.update(delta);
		player.updateMouseAngle(x_off, y_off);

		Iterator<Projectile> itPro = projectiles.iterator();
		while (itPro.hasNext()) {
			Projectile pro = itPro.next();
			pro.update(delta);
			if (pro.isRemoved()) itPro.remove();
		}
		Iterator<Entity> itEnt = entities.iterator();
		while (itEnt.hasNext()) {
			Entity entity = itEnt.next();
			entity.update(delta);
			if (entity.isRemoved()) itEnt.remove();
			if (entity instanceof Enemy) {
				((Enemy) entity).setTracking(player.getPosition());
			}
		}
		Iterator<Enemy> itEnm = enemies.iterator();
		while (itEnm.hasNext()) {
			Enemy enemy = itEnm.next();
			enemy.update(delta, projectiles);
			if (enemy.isRemoved()) itEnm.remove();
			enemy.setTracking(player.getPosition());
		}
	}

	public void render(Graphics g) {
		/*
		 * int px, py;
		 * px = (int) Math.round(player.getPosition().x / 64);
		 * py = (int) Math.round(player.getPosition().y / 64);
		 * for (int x = px - (renderWidth / 2); x < px + renderWidth; x++) {
		 * for (int y = py - (renderHeight / 2); y < py + renderHeight; y++) {
		 */
		for (int x = 0; x < current.getWidth(); x++) {
			for (int y = 0; y < current.getHeight(); y++) {
				if (x < 0 || y < 0 || x >= current.getWidth() || y >= current.getHeight()) continue;
				Tile tile = current.getTile(x, y);
				if (tile != null) {
					tile.getSprite().getImage().draw(x_off + x * 64, y_off + y * 64);
				}
			}
		}
		// TODO Only render the entities that are on the screen
		Iterator<Projectile> itPro = projectiles.iterator();
		while (itPro.hasNext()) {
			Projectile pro = itPro.next();
			pro.render(x_off, y_off, g);
		}
		Iterator<Entity> itEnt = entities.iterator();
		while (itEnt.hasNext()) {
			Entity entity = itEnt.next();
			if (entity instanceof Mob) {
				((Mob) entity).render(x_off, y_off, g);
			}
			if (entity instanceof Blood) {
				((Blood) entity).render(x_off, y_off, g);
			}
		}
		Iterator<Enemy> itEnm = enemies.iterator();
		while (itEnm.hasNext()) {
			Enemy enemy = itEnm.next();
			enemy.render(x_off, y_off, g);
		}
		player.render(x_off, y_off, g);
		waves.render(g);
	}

	public void add(Entity entity) {
		if (entity instanceof Enemy) {
			enemies.add((Enemy) entity);
		} else if (entity instanceof Projectile) {
			projectiles.add((Projectile) entity);
		} else {
			entities.add(entity);
		}
	}

	public void spawnNewEnemy() {
		Vector2f pos = getRandomPosition();
		// TODO better spawning
		add(new Enemy(pos.x, pos.y));
	}

	private Vector2f getRandomPosition() {
		return new Vector2f(64 + random.nextInt((current.getWidth() - 2) * 64), 64 + random.nextInt((current.getHeight() - 2) * 64));
	}

	public static Map getCurrentMap() {
		return current;
	}
}
