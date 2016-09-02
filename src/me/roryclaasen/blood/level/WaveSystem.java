package me.roryclaasen.blood.level;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import me.roryclaasen.blood.graphics.FontMannager;
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
		currentWave++;
		time = 0;
		toSpawn = (int) Math.ceil(currentWave * toSpawnBase * mul);
		renderWave = true;
	}

	public void update(int delta) {
		time += 0.5 * delta;
		if (renderWave) {
			if (time > 3 * 1000) {
				renderWave = false;
			}
		} else {
			if (time > 500 - (currentWave * (1 + mul))) {
				if (toSpawn > 0) {
					toSpawn--;
					level.spawnNewEnemy();
					time = 0;
					if (toSpawn == 0) nextWave();
				}
			}
		}
	}

	public void render(Graphics g) {
		if (renderWave) {
			g.setFont(FontMannager.ka1);
			g.setColor(Color.black);
			g.drawString(LangUtil.get("game.wave") + " " + currentWave, 50, 50);
		}
	}
}
