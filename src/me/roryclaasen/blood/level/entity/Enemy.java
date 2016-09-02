package me.roryclaasen.blood.level.entity;

import java.util.List;
import java.util.Random;

import org.newdawn.slick.geom.Vector2f;

import me.roryclaasen.blood.graphics.sprite.Sprite;

public class Enemy extends Mob {

	private double health;

	private Vector2f tracking;

	public Enemy(float x, float y) {
		super(x, y);
		speed = 0.2f;
		health = 1;

		sprite = new Sprite("textures/entities/enemy" + ((new Random()).nextInt(4)) + ".png");
	}

	@Override
	public void update(int delta) {
		float xa = 0, ya = 0;
		if (tracking != null) {
			if (position.x > tracking.x) xa -= speed * delta;
			if (position.x < tracking.x) xa += speed * delta;
			if (position.y > tracking.y) ya -= speed * delta;
			if (position.y < tracking.y) ya += speed * delta;
			if (getDistanceFrom(tracking) > 100) {
				move(xa, ya);
			}
		}
		setAngleToTarget();
	}

	public void update(int delta, List<Projectile> projectiles) {
		update(delta);
		for (Projectile p : projectiles) {
			if (getDistanceFrom(p) < 50 * 20) {
				health--;
				if (health < 0) remove();
				p.remove();
				// TODO add blood
			}
		}
	}

	public Vector2f getTracking() {
		return tracking;
	}

	public void setTracking(Vector2f tracking) {
		this.tracking = tracking;
	}

	private void setAngleToTarget() {
		if (tracking != null) rotation = (float) Math.toDegrees(Math.atan2((tracking.y - (position.y)), (tracking.x - (position.x))));
		else rotation = 0f;
	}
}
