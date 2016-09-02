package me.roryclaasen.blood.level.entity;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class Blood extends Entity {

	private int shape = -1;
	private int size;
	private int time;

	public Blood(Vector2f pos) {
		super(pos.x - 32 + (new Random()).nextInt(64), pos.y- 32 + (new Random()).nextInt(64));
		this.shape = (new Random()).nextInt(4);
		this.size = 25 + (new Random()).nextInt(25);
	}

	public Blood(float x, float y) {
		this(new Vector2f(x, y));
	}

	@Override
	public void update(int delta) {
		time += delta;
		if (time > 15 * 1000) {
			remove();
		}
	}

	public void render(int x_off, int y_off, Graphics g) {
		g.setColor(Color.red);
		Vector2f r = new Vector2f(position);
		r.add(new Vector2f(x_off, y_off));
		switch (shape) {
			case (0): {
				g.drawOval(r.x, r.y, size, size);
			}
			case (1): {
				g.drawLine(r.x, r.y, r.x + size, r.y + 5);
			}
			case (2): {
				g.drawLine(r.x, r.y, r.x + 5, r.y + size);
			}
			case (3): {
				g.drawRect(r.x, r.y, size, size);
			}
			default: {
				g.drawRect(r.x, r.y, size, size);
			}
		}
	}
}
