package me.roryclaasen.blood.level.entity;

import me.roryclaasen.blood.graphics.sprite.Sprite;

public class Projectile extends Mob {

	private float direction;

	public Projectile(float x, float y, float direction) {
		super(x, y, 3, 10);
		rotation = direction + 90f;
		this.direction = direction;
		speed = 0.95f;
		sprite = new Sprite("textures/entities/projectile.png");
	}

	@Override
	public void update(int delta) {
		float xa = 0, ya = 0;
		xa = (float) (Math.cos(direction * (Math.PI / 180)) * speed * delta);
		ya = (float) (Math.sin(direction * (Math.PI / 180)) * speed * delta);
		move(xa, ya);
	}
}
