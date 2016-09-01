package me.roryclaasen.blood.level;

import org.newdawn.slick.Graphics;

import net.roryclaasen.language.LangUtil;

public class WaveSystem {
	private int time;
	private GameLevel level;

	private int currentWave = 0;

	private double mul = 0.8;

	private int toSpawnBase = 10;
	private int toSpawn = 0;

	private boolean renderWave = false;

	public WaveSystem(GameLevel level) {
		this.level = level;
	}

	public void start() {
		nextWave();
	}

	public void nextWave() {
		renderWave = true;
		currentWave++;
		time = 0;
		toSpawn = (int) Math.ceil(currentWave * toSpawnBase * mul);
	}

	public void update(int delta) {
		time += delta;
		if (time > 50) {
			if (toSpawn != 0) {
				level.spawnNewEnemy();
				time = 0;
				toSpawn--;
			} else {
				if (time > 100) {
					nextWave();
				}
			}
		}
	}

	public void render(Graphics g) {
		if (renderWave) {
			g.drawString(LangUtil.get("game.wave") + " " + currentWave, 100, 100);
		}
	}
}
