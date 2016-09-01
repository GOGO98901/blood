package me.roryclaasen.blood.level.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import me.roryclaasen.blood.handler.HandlerMouse;

public class Player extends Mob {

	public Player() {
		super(64, 64);
	}

	@Override
	public void update(int delta) {
		this.setPosition(HandlerMouse.getX(), HandlerMouse.getY());
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(position.x, position.y, size.x, size.y);
	}
}
