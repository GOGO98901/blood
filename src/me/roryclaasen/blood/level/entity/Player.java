package me.roryclaasen.blood.level.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import me.roryclaasen.blood.handler.HandlerKeyboard;

public class Player extends Mob {

	public Player() {
		super(64, 64);
		this.speed = 1.2F;
	}

	@Override
	public void update(int delta) {
		float xa = 0, ya = 0;
		if (HandlerKeyboard.w ^ HandlerKeyboard.s) {
			if (HandlerKeyboard.w) ya -= speed;
			else if (HandlerKeyboard.s) ya += speed;
		}
		if (HandlerKeyboard.a ^ HandlerKeyboard.d) {
			if (HandlerKeyboard.a) xa -= speed;
			else if (HandlerKeyboard.d) xa += speed;
		}
		move(xa, ya);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(position.x, position.y, size.x, size.y);
		if (sprite != null) g.drawImage(sprite.getImage(), position.x, position.y);
	}
}
