package me.roryclaasen.blood.level.entity;

import me.roryclaasen.blood.handler.HandlerKeyboard;
import me.roryclaasen.blood.handler.HandlerMouse;

public class Player extends Mob {

	public Player() {
		super(64, 64);
		this.speed = 1.2F;
	}

	@Override
	public void update(int delta) {
		float xa = 0, ya = 0;
		if (HandlerKeyboard.w ^ HandlerKeyboard.s) {
			if (HandlerKeyboard.w) ya -= speed * delta;
			else if (HandlerKeyboard.s) ya += speed * delta;
		}
		if (HandlerKeyboard.a ^ HandlerKeyboard.d) {
			if (HandlerKeyboard.a) xa -= speed * delta;
			else if (HandlerKeyboard.d) xa += speed * delta;
		}
		move(xa, ya);
	}

	public void updateMouseAngle(int x_off,int y_off) {
		int mx = HandlerMouse.getX(), my = HandlerMouse.getY();
		rotation = (float) Math.toDegrees(Math.atan2((my - (y_off + position.y)), (mx - (x_off + position.x))));
	}
}
