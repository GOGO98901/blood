package me.roryclaasen.blood.level.entity;

import me.roryclaasen.blood.GameMaster;
import me.roryclaasen.blood.graphics.sprite.Sprite;
import me.roryclaasen.blood.handler.HandlerKeyboard;
import me.roryclaasen.blood.handler.HandlerMouse;
import me.roryclaasen.blood.level.GameLevel;
import me.roryclaasen.blood.states.StateGame;

public class Player extends Mob {

	private int coolTime;

	public Player() {
		super(64, 64);
		this.speed = 0.5F;
		sprite = new Sprite("textures/entities/player.png");
	}

	@Override
	public void update(int delta) {
		coolTime += delta;
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

		if (HandlerMouse.getButton() == HandlerMouse.BTN_LEFT) {
			if (coolTime > 15) {
				coolTime = 0;
				GameLevel level = ((StateGame) GameMaster.getLoop().getCurrentState()).getLevel();
				level.add(new Projectile(position.x, position.y, rotation - 90f));
			}
		}
	}

	public void updateMouseAngle(int x_off, int y_off) {
		int mx = HandlerMouse.getX(), my = HandlerMouse.getY();
		rotation = 90f + (float) Math.toDegrees(Math.atan2((my - (y_off + position.y)), (mx - (x_off + position.x))));
	}
}
